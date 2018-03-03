let fs = require('fs');
let http = require('http');
let url = require('url');
let os = require('os');
let handleRequest = require('./helloworld');

// HTTPサーバ
class HttpServer {

  // 接続待ち受け開始
  startListen(port) {
    this.server = http.createServer();
    let address = this.getIpv4Addrss();
    new HttpConsoleLogger().message('start listening ' + address + ':' + port);
    this.server.listen(port);
    this.server.on('request', (req, res) => {
      let reqHandler = new RequestHandler(req, res, address, port);
      reqHandler.onRequest();
    });
  };
  
  // IPアドレス取得
  getIpv4Addrss() {
    let interfaces = os.networkInterfaces();
    for (var dev in interfaces) {
      for (let i = 0; i < interfaces[dev].length; i++) {
        let details = interfaces[dev][i];
        if (!details.internal && 'IPv4' === details.family) {
          return details.address;
        }
      };
    }
    return '127.0.0.1';
  };
};

// リクエスト処理を行うクラス
class RequestHandler {

  // コンストラクタ
  constructor(req, res, address, port) {
    this.req = req;
    this.res = res;
    this.reqData = null;
    this.logger = new HttpConsoleLogger();
    this.address = address;
    this.port = port;
  };

  // リクエスト処理
  onRequest() {
  
    // CORS対応
    this.corsResponse();
    if (this.req.method === 'OPTIONS') {
      return;
    }
    
    // リクエストデータを取得
    let reqDataPromise = this.storeReqData(this.req);
    
    // リクエストデータ取得時の処理を設定
    reqDataPromise.then(reqData => {
      this.reqData = reqData;
      this.logger.dumpReq(this.req, this.reqData);
      if (!this.res.headersSent) {
        handleRequest(this);
      }
    });
  };
  
  // CORS用のレスポンス
  corsResponse() {
    this.res.setHeader('Access-Control-Allow-Origin', '*');
    this.res.setHeader('Access-Control-Allow-Methods', 'POST, GET, OPTIONS');
    this.res.setHeader('Access-Control-Allow-Headers', 'Authorization, X-CSRF-TOKEN, Content-Type, If-Modified-Since, Pragma, Cache-Control');
    this.res.end();
  };
  
  // リクエストデータを取得する
  storeReqData() {
    return new Promise((resolve, reject) => {
      let bufs = [];
      bufs.totalLength = 0;
      this.req.on('data', function(chunk) {
        bufs.push(chunk);
        bufs.totalLength += chunk.length;
        
      }).on('end', function() {
        let reqData = Buffer.concat(bufs, bufs.totalLength);
        resolve(reqData);
      });
    });
  };
  
  // JSONデータを返却する
  responseJson(jsonData) {
    this.res.writeHead(200, {'Content-Type': 'application/json;charset=UTF-8'});
    this.logger.dumpRes(jsonData);
    this.res.write(JSON.stringify(jsonData));
    this.res.end();
  };
  
  // エラー情報(JSON)を返却する
  responseError(statusCode, jsonData) {
    if (jsonData) {
      this.res.writeHead(statusCode, {'Content-Type': 'application/json;charset=UTF-8'});
      this.logger.dumpRes(jsonData, statusCode);
      this.res.write(JSON.stringify(jsonData));
    } else {
      this.res.writeHead(statusCode, {});
      this.logger.dumpRes({}, statusCode);
    }
    this.res.end();
  };
  
  // ファイルを返却する
  responseFile(filePath, contentType, contentDisposition) {
    this.logger.dumpRes({"file": filePath, "contentType": contentType, "contentDisposition": contentDisposition});
    this.res.writeHead(200, {'Content-Type': contentType, 'Content-Disposition': contentDisposition});
    fs.createReadStream(filePath).pipe(this.res);
  }
};

// コンソールロガー
class HttpConsoleLogger {

  // リクエスト情報を出力
  dumpReq(req, reqData) {
    this.message("\n========= [" + this.nowDate() + "] =========");
    let headers = '';
    for (let key in req.headers) {
       headers += '\t' + key + ': ' + req.headers[key] + '\n';
    }

    let msg = 'basic:\n'
            + '\taddress: ' + req.connection.remoteAddress + '\n'
            + '\turl: ' + req.url + '\n'
            + '\tmethod: '+ req.method + '\n'
            + 'header:\n' + headers;
            
    if (0 < reqData.length) {
      msg += 'data:\n' + reqData.toString();
    }
    
    this.message('--------------- request -----------------');
    this.message(msg);
  };
  
  // レスポンス情報を出力
  dumpRes(json, statusCode) {
    this.message('--------------- response -----------------');
    if (statusCode) {
      this.message('statusCode:' + statusCode);
    }
    this.message(JSON.stringify(json));
    this.message('=============================================');
  };
  
  // 現在時刻を文字列で取得
  nowDate() {
    let d = new Date();
    return d.getFullYear() + '/' + d.getMonth() + '/' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds() + '.' + d.getMilliseconds();
  };
  
  // メッセージ出力
  message(msg) {
    console.log(msg);
  };
};

new HttpServer().startListen(80);

