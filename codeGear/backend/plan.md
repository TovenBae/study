# CodeGear Backend API 개발 계획

## 프로젝트 개요
- **목적**: codegear.info의 backend API 서비스 개발
- **언어**: Go (Golang)
- **데이터베이스**: SQLite3
- **ORM**: GORM (Go에서 가장 널리 사용되는 ORM)
- **웹 프레임워크**: Gin (Go의 대표적인 웹 프레임워크)
- **API 문서화**: Swagger (swaggo/swag)

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

## 단계별 구현 계획

### Phase 1: 프로젝트 초기화 및 기본 설정
1. **Go 모듈 초기화**
   - `go mod init` 실행
   - 필요한 패키지 설치:
     - github.com/gin-gonic/gin (웹 프레임워크)
     - gorm.io/gorm (ORM)
     - gorm.io/driver/sqlite (SQLite 드라이버)
     - github.com/swaggo/gin-swagger (Swagger)
     - github.com/swaggo/files (Swagger 파일 서빙)

2. **기본 디렉토리 구조 생성**
   - 위에 정의된 디렉토리 구조대로 폴더 생성

3. **데이터베이스 설정**
   - SQLite3 연결 설정
   - GORM 초기화
   - 자동 마이그레이션 설정

### Phase 2: 핵심 기능 구현
1. **기본 모델 구조**
   - Base 모델 정의 (ID, CreatedAt, UpdatedAt)
   - 공통 모델 필드 정의

2. **에러 핸들링**
   - 통일된 에러 응답 구조
   - HTTP 상태 코드별 에러 처리
   - 에러 핸들링 미들웨어

3. **응답 포맷 유틸리티**
   - 성공 응답 포맷
   - 에러 응답 포맷

### Phase 3: API 구현
1. **기본 라우팅 설정**
   - Gin 라우터 초기화
   - 라우트 그룹 설정

2. **헬스체크 API**
   - GET /health - 서버 상태 확인
   - GET /api/v1/ping - API 연결 테스트

3. **라우터 구조**
   - API 버전 관리 (/api/v1)
   - RESTful 구조 준수

### Phase 4: Swagger 문서화
1. **Swagger 설정**
   - swag init 명령어 설정
   - API 주석 작성 규칙
   - Swagger UI 경로 설정 (/swagger/*)

2. **API 문서 작성**
   - 각 엔드포인트에 Swagger 주석 추가
   - 요청/응답 스키마 정의

### Phase 5: 테스트 및 배포 준비
1. **로컬 테스트**
   - 각 API 엔드포인트 테스트
   - Swagger UI에서 테스트

2. **환경 설정**
   - 개발/운영 환경 분리
   - 환경변수 설정

## API 응답 포맷 표준

### 성공 응답
```json
{
  "statusCode": 200,
  "message": "Success",
  "data": {...}
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

## HTTP 상태 코드 사용
- 200: 성공
- 201: 생성 성공
- 400: 잘못된 요청
- 404: 리소스를 찾을 수 없음
- 500: 서버 내부 오류

## 개발 규칙
1. 각 단계별로 커밋하여 버전 관리
2. 코드는 컴포넌트 단위로 분리
3. 에러는 항상 적절한 HTTP 상태 코드와 함께 반환
4. API는 RESTful 원칙을 따름
5. 모든 API는 Swagger 문서화 필수

## 다음 단계 확장 계획 (향후)
- 사용자 인증/인가 (JWT)
- CRUD API 구현 (예: 게시판, 사용자 관리)
- 로깅 시스템
- 유닛 테스트
- CI/CD 파이프라인
