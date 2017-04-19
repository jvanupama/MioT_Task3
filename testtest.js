var express = require('express');
var http = require('http');

var server = express();
server.use('/', express.static(__dirname + '/'));
server.get('/toggle', function(req, res, next) {
	var querystring = require('querystring');
	var data = '{"on":false }';
	var options = {
		host: '192.168.86.111',
		port: 80,
		path: '/api/6hufLC0Cka15j3SI8Dsj5-1jeqfq5tP6w5-RIw20/lights/5/state',
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json',
			'Content-Length': Buffer.byteLength(data)
		}
	};

	var hueReq = http.request(options, function(res) {
		res.setEncoding('utf8');
		res.on('data', function (chunk) {
			console.log("body: " + chunk);
		});
	});
	hueReq.write(data);
	hueReq.end();
	res.sendStatus(200)
});

server.listen(8686, function () {
  console.log('Server is listening on port 8686.')
})