# CodeGear Backend API

codegear.info의 backend API 서비스입니다.

## 기술 스택

- **언어**: Go 1.25
- **웹 프레임워크**: Gin
- **ORM**: GORM
- **데이터베이스**: SQLite3
- **API 문서화**: Swagger (swaggo)

## 프로젝트 구조

```
backend/
├── main.go                 # 애플리케이션 진입점
├── go.mod                  # Go 모듈 파일
├── go.sum                  # 의존성 체크섬
├── config/                 # 설정 파일
│   └── database.go        # 데이터베이스 설정
├── models/                 # 데이터 모델
│   └── base.go            # 기본 모델 구조
├── controllers/            # API 컨트롤러
│   └── health.go          # 헬스체크 컨트롤러
├── routes/                 # 라우팅 설정
│   └── routes.go          # 라우트 정의
├── middleware/             # 미들웨어
│   └── error_handler.go   # 에러 핸들링 미들웨어
├── utils/                  # 유틸리티 함수
│   └── response.go        # API 응답 포맷
├── docs/                   # Swagger 문서 (자동 생성)
└── database/               # 데이터베이스 파일
    └── codegear.db        # SQLite 데이터베이스 파일
```

## 설치 및 실행

### 1. 의존성 설치

```bash
go mod download
```

### 2. Swagger 문서 생성

```bash
swag init
```

### 3. 개발 서버 실행

```bash
go run main.go
```

서버가 http://localhost:8080 에서 실행됩니다.

### 4. 프로덕션 빌드

```bash
go build -o codegear-api main.go
./codegear-api
```

## API 엔드포인트

### 헬스체크
- `GET /health` - 서버 상태 확인

### API v1
- `GET /api/v1/ping` - API 연결 테스트

### Swagger 문서
- `GET /swagger/index.html` - Swagger UI

## API 응답 포맷

### 성공 응답
```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {
    "key": "value"
  }
}
```

### 에러 응답
```json
{
  "statusCode": 400,
  "message": "Bad Request",
  "error": "상세 에러 메시지"
}
```

## 개발 가이드

### 새로운 API 추가하기

1. **모델 생성** (필요한 경우)
   - `models/` 디렉토리에 새 모델 파일 생성
   - `BaseModel`을 임베드하여 기본 필드 상속

2. **컨트롤러 생성**
   - `controllers/` 디렉토리에 새 컨트롤러 파일 생성
   - Swagger 주석 추가

3. **라우트 등록**
   - `routes/routes.go`에 새 라우트 추가

4. **Swagger 문서 업데이트**
   ```bash
   swag init
   ```

### Swagger 주석 예시

```go
// FunctionName godoc
// @Summary 간단한 설명
// @Description 상세한 설명
// @Tags 태그명
// @Accept json
// @Produce json
// @Param id path int true "ID"
// @Success 200 {object} utils.SuccessResponse
// @Failure 400 {object} utils.ErrorResponse
// @Router /api/v1/endpoint [get]
func FunctionName(c *gin.Context) {
    // 구현
}
```

## 테스트

### API 테스트
1. 서버 실행 후 http://localhost:8080/swagger/index.html 접속
2. Swagger UI에서 각 엔드포인트 테스트

### 헬스체크 테스트
```bash
curl http://localhost:8080/health
```

### Ping 테스트
```bash
curl http://localhost:8080/api/v1/ping
```

## 환경 변수

현재는 하드코딩된 설정을 사용하지만, 향후 환경 변수로 관리 예정:
- `PORT`: 서버 포트 (기본값: 8080)
- `DB_PATH`: 데이터베이스 파일 경로
- `GIN_MODE`: Gin 실행 모드 (debug/release)

## 다음 단계

- [ ] 사용자 인증/인가 (JWT)
- [ ] CRUD API 구현
- [ ] 로깅 시스템
- [ ] 유닛 테스트
- [ ] 환경 변수 설정
- [ ] CI/CD 파이프라인

## 라이선스

MIT
