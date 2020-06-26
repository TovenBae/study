const http = require('http');
const socketio = require('socket.io');

var server = http.createServer(function (request, response) {
}).listen(9000, function() {
  console.log('Server running at http://127.0.0.1:9000');
})

var io = socketio.listen(server);


io.sockets.on('connection', function(socket) {
  console.log('connected socket');
})
