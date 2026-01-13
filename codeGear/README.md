# CodeGear

codegear.tistory.com/147 사이트를 참고하여 실습하는 샘플 풀스택 애플리케이션 프로젝트입니다.

## 프로젝트 개요

CodeGear 유튜브 채널과 블로그를 홍보하고 소개하는 웹사이트로, AI에 관심 있는 개발자를 대상으로 실용적이고 전문적인 정보를 제공합니다.

## 아키텍처

- **프론트엔드**: Next.js 16 (App Router)
- **백엔드**: Go (Gin Framework)
- **데이터베이스**: SQLite3
- **인증**: Google OAuth 2.0 + JWT

## 프로젝트 구조

```
codeGear/
├── frontend/          # Next.js 프론트엔드 애플리케이션
│   ├── src/
│   │   ├── app/       # App Router 페이지
│   │   │   ├── login/ # 로그인 페이지
│   │   │   └── ...
│   │   ├── components/ # 재사용 컴포넌트
│   │   ├── contexts/  # React Context (Auth)
│   │   └── lib/       # 유틸리티 함수 (API 클라이언트)
│   ├── .env.local.example # 환경변수 예제
│   └── README.md      # 프론트엔드 상세 문서
├── backend/           # Go 백엔드 애플리케이션
│   ├── config/        # 데이터베이스 및 OAuth 설정
│   ├── controllers/   # API 컨트롤러 (Auth, Health)
│   ├── middleware/    # 미들웨어 (JWT 인증)
│   ├── models/        # 데이터 모델 (User)
│   ├── routes/        # 라우트 설정
│   ├── utils/         # 유틸리티 (JWT, OAuth)
│   ├── database/      # SQLite 데이터베이스 파일
│   ├── .env.example   # 환경변수 예제
│   └── main.go        # 진입점
└── README.md          # 전체 프로젝트 문서 (현재 파일)
```

## 프론트엔드 (현재 구현 완료)

### 기술 스택

- **Framework**: Next.js 16 (App Router)
- **Language**: TypeScript
- **Styling**: Tailwind CSS v3
- **UI**: Custom Components with Heroicons
- **Theme**: next-themes (다크모드)
- **Animation**: Framer Motion

### 주요 기능

- ✅ 반응형 디자인 (모바일/태블릿/데스크톱)
- ✅ 다크모드 지원 (라이트/다크/시스템)
- ✅ 유튜브 영상 임베드 (3개 인기 영상)
- ✅ SEO 최적화 (메타태그, sitemap, robots.txt)
- ✅ 성능 최적화 (lazy loading, 코드 스플리팅)
- ✅ 웹 접근성 (ARIA, 키보드 내비게이션)
- ✅ Clean & Modern 디자인
- ✅ Google OAuth 2.0 로그인
- ✅ 사용자 인증 및 세션 관리

### 페이지 구성

1. **홈 페이지** (`/`)
   - 히어로 섹션 (메인 헤드라인)
   - 인기 유튜브 영상 3개 임베드
   - CTA 버튼 (유튜브 채널, 블로그 방문)

2. **About 페이지** (`/about`)
   - CodeGear 소개
   - 주요 콘텐츠 카테고리
   - 채널 및 블로그 링크

3. **로그인 페이지** (`/login`)
   - Google OAuth 로그인
   - OAuth 콜백 처리
   - 자동 리디렉션

### 시작하기

```bash
# 프론트엔드 디렉토리로 이동
cd frontend

# 의존성 설치
npm install

# 개발 서버 실행
npm run dev

# 프로덕션 빌드
npm run build

# 프로덕션 서버 실행
npm run start
```

개발 서버 실행 후 브라우저에서 [http://localhost:3000](http://localhost:3000) 접속

### 디자인 가이드

- **Primary Color**: Sky Blue (#0ea5e9)
- **Secondary Color**: Purple (#a855f7)
- **Typography**: Geist Sans, Geist Mono
- **Style**: Clean & Modern Minimalism

## 백엔드 (구현 완료)

### 기술 스택

- **Framework**: Gin (Go web framework)
- **Database**: GORM + SQLite3
- **Authentication**: Google OAuth 2.0
- **Token**: JWT (JSON Web Token)
- **Documentation**: Swagger/OpenAPI

### API 엔드포인트

#### 인증 API (`/api/v1/auth`)

- `GET /google/url` - Google OAuth 로그인 URL 조회
- `GET /google/callback` - Google OAuth 콜백 처리 및 JWT 발급
- `GET /me` - 현재 로그인한 사용자 정보 조회 (인증 필요)
- `POST /logout` - 로그아웃

#### 헬스체크 API

- `GET /health` - 서버 상태 확인
- `GET /api/v1/ping` - API 상태 확인

### 시작하기

```bash
# 백엔드 디렉토리로 이동
cd backend

# 환경변수 설정
cp .env.example .env
# .env 파일을 열어 Google OAuth 정보 입력

# 의존성 설치
go mod download

# 개발 서버 실행
go run main.go

# 프로덕션 빌드
go build -o codegear-api
./codegear-api
```

서버 실행 후:
- API 서버: [http://localhost:8080](http://localhost:8080)
- Swagger 문서: [http://localhost:8080/swagger/index.html](http://localhost:8080/swagger/index.html)

### Google OAuth 설정

1. [Google Cloud Console](https://console.cloud.google.com/)에서 프로젝트 생성
2. "API 및 서비스" > "사용자 인증 정보"로 이동
3. "OAuth 2.0 클라이언트 ID" 생성
4. 승인된 리디렉션 URI 추가:
   - `http://localhost:8080/api/v1/auth/google/callback` (개발)
   - `http://localhost:3000/login` (프론트엔드)
5. 클라이언트 ID와 Secret을 `.env` 파일에 추가

## 데이터베이스

### 스키마

#### Users 테이블

| 컬럼 | 타입 | 설명 |
|------|------|------|
| id | INTEGER | Primary Key |
| email | TEXT | 이메일 (Unique) |
| name | TEXT | 사용자 이름 |
| picture | TEXT | 프로필 이미지 URL |
| google_id | TEXT | Google 계정 ID (Unique) |
| last_login_at | INTEGER | 마지막 로그인 시간 (Unix timestamp) |
| created_at | DATETIME | 생성 시간 |
| updated_at | DATETIME | 수정 시간 |

데이터베이스 파일: `backend/database/codegear.db`

## 전체 프로젝트 실행 방법

### 1. Google OAuth 설정 (필수)

위의 "Google OAuth 설정" 섹션을 참고하여 Google Cloud Console에서 OAuth 클라이언트 설정

### 2. 백엔드 실행

```bash
cd backend
cp .env.example .env
# .env 파일에 Google OAuth 정보 입력
go mod download
go run main.go
```

### 3. 프론트엔드 실행

```bash
cd frontend
cp .env.local.example .env.local
# .env.local 파일에 설정 입력
npm install
npm run dev
```

### 4. 접속

- 프론트엔드: [http://localhost:3000](http://localhost:3000)
- 백엔드 API: [http://localhost:8080](http://localhost:8080)
- Swagger 문서: [http://localhost:8080/swagger/index.html](http://localhost:8080/swagger/index.html)

### 로그인 테스트

1. 프론트엔드 헤더에서 "Login" 버튼 클릭
2. Google 계정으로 로그인
3. 로그인 후 헤더에 사용자 프로필 표시 확인

## 배포

### 프론트엔드 배포 (권장: Vercel)

1. GitHub에 저장소 푸시
2. [Vercel](https://vercel.com)에서 프로젝트 import
3. `frontend` 디렉토리를 루트 디렉토리로 설정
4. 환경변수 설정:
   - `NEXT_PUBLIC_API_URL`: 백엔드 API URL
   - `NEXT_PUBLIC_GOOGLE_CLIENT_ID`: Google OAuth 클라이언트 ID
5. 자동 배포 완료

### 백엔드 배포 (권장: Railway, Fly.io)

1. 프로덕션 환경변수 설정
2. Google OAuth 리디렉션 URI에 프로덕션 URL 추가
3. 데이터베이스 파일 영구 스토리지 설정
4. 서버 배포

### 기타 배포 플랫폼

- Netlify (프론트엔드)
- AWS Amplify (프론트엔드)
- Cloudflare Pages (프론트엔드)
- Google Cloud Run (백엔드)
- AWS EC2 (백엔드)

## 문서

- [프론트엔드 상세 문서](frontend/README.md)
- [프론트엔드 구현 계획](frontend/plan.md)
- [프론트엔드 요구사항](frontend/requirement.md)

## 링크

- **유튜브**: [https://www.youtube.com/@codegear-21](https://www.youtube.com/@codegear-21)
- **블로그**: [https://codegear.tistory.com/](https://codegear.tistory.com/)
- **참고 튜토리얼**: [codegear.tistory.com/147](https://codegear.tistory.com/147)

## 개발 현황

- ✅ 프론트엔드 웹사이트 구현 완료
  - Next.js 16 + TypeScript
  - 반응형 디자인 + 다크모드
  - Google OAuth 로그인 UI
- ✅ 백엔드 API 서버 구현 완료
  - Go + Gin Framework
  - Google OAuth 2.0 인증
  - JWT 토큰 기반 인증
  - Swagger API 문서
- ✅ 데이터베이스 구현 완료
  - SQLite3 + GORM
  - User 모델 및 마이그레이션

## 주요 기능 상세

### 인증 시스템

- **Google OAuth 2.0**: 간편한 소셜 로그인
- **JWT 토큰**: 안전한 세션 관리 (24시간 유효)
- **자동 사용자 등록**: 첫 로그인 시 자동으로 사용자 생성
- **프로필 표시**: 헤더에 사용자 프로필 이미지 및 이름 표시
- **로그아웃**: 클라이언트 측 토큰 삭제

### 보안

- JWT Secret 기반 토큰 서명
- Bearer Token 인증 방식
- CORS 설정
- 환경변수를 통한 민감 정보 관리

## 라이센스

이 프로젝트는 학습 목적으로 만들어졌습니다.

---

© 2026 CodeGear. All rights reserved.
