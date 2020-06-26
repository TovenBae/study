//
//  SocketIOManager.swift
//  AlamofireTest
//
//  Created by BaeSungHan on 2020/06/25.
//  Copyright © 2020 BaeSungHan. All rights reserved.
//

import Foundation
import SocketIO

class SocketIOManager:NSObject {
    static let shared = SocketIOManager()
    var manager = SocketManager(socketURL: URL(string: "http://localhost:9000")!, config: [.log(true), .compress])
    var socket: SocketIOClient!
    override init() {
        super.init()
        socket = self.manager.socket(forNamespace: "/test")
        
        socket.on("test") { dataArray, ack in
            print(dataArray)
        }
    }
    
    func establishConnection() {
        socket.connect()
        print("socketIO connect")
    }
    
    func closeConnection() {
        socket.disconnect()
        print("socketIO disconnect")

    }
    
    func sendMessage(message: String, nickname: String) {
        socket.emit("msg", ["nick": nickname, "msg": message])
    }
}
