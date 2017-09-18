
var http = require('http');


http.createServer(function(req, res) {

  // CORS対応
  if (req.method === 'OPTIONS') {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'POST,GET,OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
    res.end();
    return;
  }
  
  var bufs = [];
  bufs.totalLength = 0;
  req.on('data', function(chunk) {
    bufs.push(chunk);
    bufs.totalLength += chunk.length;
  });
  req.on('end', function() {
    var data = Buffer.concat(bufs, bufs.totalLength);
    response(req, res, data);
  });
    
}).listen(8081, '127.0.0.1');

function responseJson(res, data) {
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.writeHead(200, {'Content-Type': 'application/json; charset=utf-8'});
  res.write(JSON.stringify(data));
  res.end();
};

function response(req, res, reqData) {

  switch(req.url) {
  
    case '/search':
      let data = [
        { no: 1, name: '太郎', date: '2017/01/01', xx: 'aaa' },
        { no: 2, name: '次郎', date: '2017/01/02', xx: 'bbb' },
        { no: 3, name: '三郎', date: '2017/01/03', xx: 'ccc' }
      ];
      responseJson(res, data);
      break;
      
    default:
      console.log('no match');
      responseJson(res, {message: 'no match'});
      break;
  
  }
}

