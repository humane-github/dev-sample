
var http = require('http');


http.createServer(function(req, res) {

  // CORS‘Î‰ž
  if (req.method === 'OPTION') {
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
    console.log('data:', data.toString());
    var resData = { resultCode: '000', resultInfo: { message: 'hogehoge' }, errorList: null};
    res.writeHead(200, {'Content-Type': 'application/json'});
    res.write(JSON.stringify(resData));
    res.end();
  });
    
}).listen(8081, '127.0.0.1');
