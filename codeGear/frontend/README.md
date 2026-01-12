# CodeGear 웹사이트

CodeGear 유튜브 채널과 블로그를 소개하는 웹사이트입니다.

## 기술 스택

- **Framework**: Next.js 16+ (App Router)
- **Language**: TypeScript
- **Styling**: Tailwind CSS
- **UI Components**: Custom Components
- **Icons**: Heroicons
- **Theme**: next-themes (다크모드 지원)
- **Animation**: Framer Motion

## 주요 기능

- ✨ 반응형 디자인 (모바일, 태블릿, 데스크톱)
- 🌓 다크모드 지원 (라이트/다크/시스템)
- 🎬 유튜브 영상 임베드
- 🚀 SEO 최적화 (메타태그, sitemap, robots.txt)
- ⚡ 성능 최적화 (이미지 lazy loading, 코드 스플리팅)
- ♿ 웹 접근성 (ARIA 속성, 키보드 내비게이션)
- 🎨 Clean & Modern 디자인

## 시작하기

### 개발 환경 설정

1. 의존성 설치:
```bash
npm install
```

2. 개발 서버 실행:
```bash
npm run dev
```

3. 브라우저에서 [http://localhost:3000](http://localhost:3000) 접속

### 빌드

프로덕션 빌드:
```bash
npm run build
```

프로덕션 서버 실행:
```bash
npm run start
```

## 프로젝트 구조

```
frontend/
├── src/
│   ├── app/              # App Router 페이지
│   │   ├── layout.tsx    # 루트 레이아웃
│   │   ├── page.tsx      # 홈 페이지
│   │   ├── about/        # About 페이지
│   │   ├── sitemap.ts    # Sitemap 생성
│   │   └── robots.ts     # Robots.txt 생성
│   ├── components/       # 재사용 컴포넌트
│   │   ├── layout/       # 레이아웃 컴포넌트
│   │   │   ├── header.tsx
│   │   │   ├── footer.tsx
│   │   │   └── theme-toggle.tsx
│   │   ├── features/     # 기능별 컴포넌트
│   │   │   └── youtube-embed.tsx
│   │   └── theme-provider.tsx
│   ├── lib/              # 유틸리티 함수
│   │   └── utils.ts
│   └── styles/
│       └── globals.css   # 글로벌 스타일
├── public/               # 정적 파일
├── plan.md              # 구현 계획서
├── requirement.md       # 요구사항 문서
└── package.json
```

## 페이지

### 홈 페이지 (/)
- 히어로 섹션 (메인 헤드라인, CTA 버튼)
- 인기 유튜브 영상 3개 임베드
- 간단한 소개 섹션

### About 페이지 (/about)
- CodeGear 소개
- 주요 콘텐츠 카테고리
- 유튜브 채널 및 블로그 링크

## 디자인 가이드

### 컬러 팔레트
- **Primary**: Sky Blue (#0ea5e9)
- **Secondary**: Purple (#a855f7)
- **Light Mode**: White background, Dark text
- **Dark Mode**: Dark background, Light text

### 타이포그래피
- **Headings**: Bold, 48px-32px
- **Body**: Regular, 16px-18px
- **Font**: Geist Sans, Geist Mono

## 배포

### Vercel (권장)
1. GitHub에 저장소 푸시
2. [Vercel](https://vercel.com)에서 프로젝트 import
3. 자동 배포 완료

### 기타 플랫폼
- Netlify
- AWS Amplify
- Cloudflare Pages

## 환경 변수

현재 환경 변수가 필요하지 않습니다.
향후 API나 외부 서비스 연동 시 `.env.local` 파일을 생성하여 사용하세요.

## 성능 최적화

- ✅ Next.js Image 컴포넌트 사용
- ✅ 코드 스플리팅 (자동)
- ✅ Lazy loading (YouTube iframe)
- ✅ Font 최적화 (next/font)
- ✅ 정적 페이지 생성 (SSG)

## 접근성

- ✅ 시맨틱 HTML
- ✅ ARIA 속성
- ✅ 키보드 내비게이션
- ✅ 충분한 색상 대비
- ✅ 스크린 리더 지원

## 라이센스

이 프로젝트는 학습 목적으로 만들어졌습니다.

## 링크

- 유튜브: [https://www.youtube.com/@codegear-21](https://www.youtube.com/@codegear-21)
- 블로그: [https://codegear.tistory.com/](https://codegear.tistory.com/)

## 참고

이 프로젝트는 [requirement.md](requirement.md)와 [plan.md](plan.md)의 요구사항에 따라 구현되었습니다.
