//
//  ViewController.swift
//  AlamofireTest
//
//  Created by BaeSungHan on 2020/06/23.
//  Copyright © 2020 BaeSungHan. All rights reserved.
//

import UIKit
import Alamofire
import SwiftSocket
import SocketIO

class ViewController: UIViewController {
    var client = TCPClient(address: "localhost", port:33333)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
//        AF.request("https://").response { response in
//            debugPrint(response)
//        }
        connectSocket(query: "")
    }

    @IBAction func callAlamofireClick(theButton : UIButton) {
        print("button was clicked!!!")
    }

    @IBAction func callSocketClick(_ sender: UIButton) {
        print("button was clicked!!!")
        print(sendRequest(string: "test data", using: client))
    }
    
    private func connectSocket(query: String) {
        switch client.connect(timeout: 10) {
            case .success:
                print("connected Socket")
            case .failure(let error):
                print("not connected Socket")
                print(error)
        }
    }
    
    @IBOutlet weak var weak: UITextField!
    
    var socket: SocketIOClient!
    
    @IBAction func sendDataSocketIO(_ sender: Any) {
        SocketIOManager.shared.sendMessage(message: self.weak.text!, nickname: "ns")
        print("call sendDataSocketIO")
    }
    
    @IBAction func connectSocketIO(_ sender: Any) {
        SocketIOManager.shared.establishConnection()
    }
    
    @IBAction func disconnectSocketIO(_ sender: Any) {
        SocketIOManager.shared.closeConnection()
    }
    
    private func sendRequest(string: String, using client: TCPClient) -> String? {
        appendToTextField(string: "Sending data ...")
        
        switch client.send(string: string) {
        case .success:
            return readResponse(from: client)
        case .failure(let error):
            appendToTextField(string: String(describing: error))
            return nil
        }
    }
    
    private func readResponse(from client: TCPClient) -> String? {
        guard let response = client.read(1024*10) else { return nil }
        
        return String(bytes: response, encoding: .utf8)
    }
    
    private func appendToTextField(string: String) {
        print(string)
//        textView.text = textView.text.appending("\n(string)")
    }
}

