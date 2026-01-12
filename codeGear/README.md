# CodeGear

codegear.tistory.com/147 사이트를 참고하여 실습하는 샘플 풀스택 애플리케이션 프로젝트입니다.

## 프로젝트 개요

CodeGear 유튜브 채널과 블로그를 홍보하고 소개하는 웹사이트로, AI에 관심 있는 개발자를 대상으로 실용적이고 전문적인 정보를 제공합니다.

## 아키텍처

- **프론트엔드**: Next.js 16 (App Router)
- **백엔드**: goLang (향후 구현 예정)
- **데이터베이스**: SQLite3 (향후 구현 예정)

## 프로젝트 구조

```
codeGear/
├── frontend/          # Next.js 프론트엔드 애플리케이션
│   ├── src/
│   │   ├── app/       # App Router 페이지
│   │   ├── components/ # 재사용 컴포넌트
│   │   └── lib/       # 유틸리티 함수
│   ├── plan.md        # 프론트엔드 구현 계획서
│   ├── requirement.md # 프론트엔드 요구사항 문서
│   └── README.md      # 프론트엔드 상세 문서
├── backend/           # Go 백엔드 (향후 구현)
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

### 페이지 구성

1. **홈 페이지** (`/`)
   - 히어로 섹션 (메인 헤드라인)
   - 인기 유튜브 영상 3개 임베드
   - CTA 버튼 (유튜브 채널, 블로그 방문)

2. **About 페이지** (`/about`)
   - CodeGear 소개
   - 주요 콘텐츠 카테고리
   - 채널 및 블로그 링크

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

## 백엔드 (향후 구현 예정)

Go 기반 백엔드 API 서버 구현 예정

## 데이터베이스 (향후 구현 예정)

SQLite3를 사용한 데이터베이스 구현 예정

## 배포

### 프론트엔드 배포 (권장: Vercel)

1. GitHub에 저장소 푸시
2. [Vercel](https://vercel.com)에서 프로젝트 import
3. `frontend` 디렉토리를 루트 디렉토리로 설정
4. 자동 배포 완료

### 기타 배포 플랫폼

- Netlify
- AWS Amplify
- Cloudflare Pages

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
- ⏳ 백엔드 API 서버 (예정)
- ⏳ 데이터베이스 설계 및 구현 (예정)

## 라이센스

이 프로젝트는 학습 목적으로 만들어졌습니다.

---

© 2026 CodeGear. All rights reserved.
