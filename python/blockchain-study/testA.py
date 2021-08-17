import unittest
import server
import requests
import json

class BlockChainTest(unittest.TestCase):
    def setUp(self):
        self.app = server.app_.test_client()
        self.new_mine = {
            'node_id': 1
        }
        self.new_transaction = {
            'sender': '0',
            'recipient': '0',
            'amount': 2000
        }

    def test_get_chain(self):
        response = self.app.get('/chain', data=None)
        self.assertEqual(200, response.status_code)
        data = json.loads(response.get_data())
        print(data)
        self.assertEqual(1, data['length'])
        self.assertEqual(100, data['chains'][0]['nonce'])
        self.assertEqual('1', data['chains'][0]['prevhash'])

    def test_add_node(self):
        response = self.app.post('/node', data=None)
        self.assertEqual(201, response.status_code)
        data = json.loads(response.get_data())
        print(data)
        self.assertEqual('New node have been added.', data['message'])
        self.new_mine['node_id'] = data['node_id']

        response = self.app.get('/chain', data=None)
        self.assertEqual(200, response.status_code)
        data = json.loads(response.get_data())
        # print(data)
        self.assertEqual(1, data['length'])
        self.assertEqual(100, data['chains'][0]['nonce'])
        self.assertEqual('1', data['chains'][0]['prevhash'])
    
    def test_add_mine(self):
        self.test_add_node()

        response = self.app.post('/mine', data=json.dumps(self.new_mine), content_type='application/json')
        self.assertEqual(200, response.status_code)
        data = json.loads(response.get_data())
        print(data)
        self.assertEqual('New Block Forged', data['message'])
        self.assertEqual('1.0', data['block']['version'])
        self.assertEqual(self.new_mine['node_id'], data['block']['transaction'][0]['recipient'])

    def test_add_transaction(self):
        self.test_add_node()

        self.test_add_mine()

        self.new_transaction['recipient'] = self.new_mine['node_id']
        response = self.app.post('/transaction', data=json.dumps(self.new_transaction), content_type='application/json')
        self.assertEqual(200, response.status_code)
        data = json.loads(response.get_data())
        print(data)
        self.assertEqual('New Block Forged', data['message'])
        self.assertEqual('1.0', data['block']['version'])
        self.assertEqual(self.new_mine['node_id'], data['block']['transaction'][0]['recipient'])

if __name__ == '__main__':
    unittest.main()