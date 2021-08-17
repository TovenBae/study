import unittest
import server
import requests
import json

class BlockChainTest(unittest.TestCase):
    def setUp(self):
        self.app = server.app_.test_client()

    def ttest_get_chain(self):
        response = self.app.get('/chain', data=None)
        data = json.loads(response.get_data())
        print(data)
        self.assertEqual(1, data['length'])
        self.assertEqual(100, data['chains'][0]['nonce'])
        self.assertEqual('1', data['chains'][0]['prevhash'])

    def test_add_node(self):
        response = self.app.post('/node', data=None)
        data = json.loads(response.get_data())
        print(data)
        self.assertEqual('New node have been added.', data['message'])

        response = self.app.get('/chain', data=None)
        data = json.loads(response.get_data())
        # print(data)
        self.assertEqual(1, data['length'])
        self.assertEqual(100, data['chains'][0]['nonce'])
        self.assertEqual('1', data['chains'][0]['prevhash'])

if __name__ == '__main__':
    unittest.main()