const app = require('express');
const router = app.Router();
const http = require('http').Server(app);
const io = require('socket.io')(http);

const room = io.of('/test');
const aroom = io.of('/a');
const broom = io.of('/b');
const croom = io.of('/c');

const userList = [
  {
    "id": "1",
    "name": "ns",
    "isConneted": false
  },
  {
    "id": "2",
    "name": "jm",
    "isConneted": false
  },
  {
    "id": "3",
    "name": "jh",
    "isConneted": false
  },
  {
    "id": "4",
    "name": "hj",
    "isConneted": false
  }
]

const chatRoom = [
  {
    'name' : 'room1',
  },
  {
    'name' : 'room2',
  }
]


router.get('/', function (req, res) {
  console.log('call /');
  room.emit('test', {
    'Hello': 'World',
    'test': 'good'
  });
  res.send('<h1>AppCoda - SocketChat Server</h1>');
});


router.get('/getChatList/:name', (req, res) => {
  const name = req.params.name
  const list = []

  chatRoom.forEach(element => {
    if( element.name == name ){
      list.push(element)
    }
  });

  res.send(list)
})

room.on('connection', (clientSocket) => {
  console.log('*** test connected ***');
  console.log(clientSocket.id)

  clientSocket.join(chatRoom[0].name, () => {
    console.log(' join a ' + chatRoom[0].name)
    console.log(clientSocket.client.conn.server)
  });

  //echo
  //user = 0, other = 1
  clientSocket.on('test', (msg) => {
    console.log(msg)
    room.emit('test', {
      'type' : 1,
     'message' : msg })
  })

  clientSocket.on('disconnect', function () {
    clientSocket.disconnect();
    console.log('test disconnected');
    console.log(clientSocket.client.conn.server.clientsCount)
  })

  clientSocket.on('msg', (msg) => {
    console.log(msg)
    console.log(msg["nick"])
    console.log(msg["msg"])

    room.to(chatRoom[0].name).emit('test', { 'nick': msg["nick"], 'res': 'response - ' + msg["msg"] })
    // clientSocket.join('123456')
    // clientSocket.set('room', '123456')
    // clientSocket.emit('test', { 'nick': msg["nick"], 'res': 'response - ' + msg["msg"] })
    // io.sockets.in('123456').emit('test', { 'nick': msg["nick"], 'res': 'response - ' + msg["msg"] })
    // io.sockets.emit('test', { 'nick': msg["nick"], 'res': 'response - ' + msg["msg"] })
  })
})


http.listen(9000, function () {
  console.log('Listening on *:9000');
});
