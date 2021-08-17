import unittest
import server
import requests
import json

class BlockChainTest(unittest.TestCase):
    def setUp(self):
        self.host = 'http://localhost:5000'

    def ttest_get_chain(self):
        response = requests.get(self.host + '/chain', data=None)
        data = json.loads(response.text)
        print(data)
        self.assertEqual(1, data['length'])
        self.assertEqual(100, data['chains'][0]['nonce'])
        self.assertEqual('1', data['chains'][0]['prevhash'])

    def test_add_node(self):
        response = requests.post(self.host + '/node', data=None)
        data = json.loads(response.text)
        print(data)
        self.assertEqual('New node have been added.', data['message'])

        response = requests.get(self.host + '/chain', data=None)
        data = json.loads(response.text)
        print(data)
        self.assertEqual(1, data['length'])
        self.assertEqual(100, data['chains'][0]['nonce'])
        self.assertEqual('1', data['chains'][0]['prevhash'])

if __name__ == '__main__':
    unittest.main()