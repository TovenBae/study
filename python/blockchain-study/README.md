# Python을 이용한 BlockChain 기초 학습
ref :
- https://github.com/JoMingyu/Blockchain-py

* flask-restful 설치
```
$ pip install flask-restful
```

* 실행
```
$ python server.py
```

* 테스트
- 접속 테스트
    http://localhost:5000/node
    http://localhost:5000/chain
    http://localhost:5000/mine
    http://localhost:5000/transaction
- unittest : call Method
```
$ python testA.py
```

- unittest : call Url
```
# 전체 실행
$ python testB.py

# Method 실행
$ python -m unittest testA.BlockChainTest.test_add_node
```
