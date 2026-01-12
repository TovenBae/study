# CodeGear 프론트엔드 구현 계획

## 프로젝트 개요
- **목적**: CodeGear 유튜브 채널과 블로그를 소개 및 홍보하는 웹사이트
- **대상**: AI에 관심 있는 개발자
- **프레임워크**: Next.js (App Router)
- **디자인**: Clean & Modern Minimalism + Bold & Expressive Typography
- **주요 기능**: 반응형 디자인, 다크모드, 애니메이션, SEO 최적화

---

## 단계별 구현 계획

### Phase 1: 프로젝트 초기 설정 및 기본 구조
**목표**: Next.js 프로젝트 초기화 및 기본 설정 완료

1. **Next.js 프로젝트 생성**
   - TypeScript, ESLint, Tailwind CSS 포함
   - App Router 사용
   - src 디렉토리 구조 사용

2. **프로젝트 구조 설정**
   ```
   frontend/
   ├── src/
   │   ├── app/              # App Router 페이지
   │   │   ├── layout.tsx    # 루트 레이아웃
   │   │   ├── page.tsx      # 홈 페이지
   │   │   └── about/        # About 페이지
   │   ├── components/       # 재사용 컴포넌트
   │   │   ├── layout/       # 레이아웃 관련 (Header, Footer)
   │   │   ├── ui/           # UI 컴포넌트 (Button, Card 등)
   │   │   └── features/     # 기능별 컴포넌트
   │   ├── lib/              # 유틸리티 함수
   │   └── styles/           # 글로벌 스타일
   ├── public/               # 정적 파일
   └── package.json
   ```

3. **필수 의존성 설치**
   - `@heroicons/react`: 아이콘 패키지
   - `next-themes`: 다크모드 구현
   - `framer-motion`: 애니메이션
   - `clsx` 또는 `tailwind-merge`: 클래스 병합

4. **Tailwind CSS 커스텀 설정**
   - 다크모드 설정 (class 기반)
   - 커스텀 컬러 팔레트
   - 폰트 설정 (타이포그래피)

---

### Phase 2: 레이아웃 및 공통 컴포넌트
**목표**: 모든 페이지에서 사용할 레이아웃 및 공통 컴포넌트 구현

1. **Header 컴포넌트**
   - 로고/사이트명
   - 네비게이션 (Home, About)
   - 다크모드 토글 버튼
   - 반응형 모바일 메뉴

2. **Footer 컴포넌트**
   - 소셜 미디어 링크 (유튜브, 블로그)
   - 저작권 정보
   - 간단한 사이트 설명

3. **테마 프로바이더 설정**
   - next-themes를 사용한 다크모드 구현
   - 라이트/다크/시스템 모드 선택 기능
   - 테마 전환 애니메이션

4. **루트 레이아웃 구성**
   - 메타데이터 설정 (SEO)
   - 글로벌 폰트 적용
   - Header/Footer 통합

---

### Phase 3: 홈 페이지 구현
**목표**: 유튜브 영상을 중심으로 한 매력적인 랜딩 페이지

1. **히어로 섹션**
   - 메인 헤드라인과 서브 헤드라인
   - 간결한 사이트 소개 문구
   - CTA 버튼 (유튜브 채널 방문, 블로그 방문)
   - 스크롤 다운 애니메이션

2. **유튜브 영상 섹션**
   - 3개 인기 영상 임베드 컴포넌트
   - 영상 정보:
     1. "Cursor AI 대체, 무료 오픈소스 Cline AI 쓸만할까?"
     2. "AI로 [유튜브 요약+노트 저장] 자동화하는 법"
     3. "n8n(AI워크플로우자동화) AWS 셀프호스팅 방법"
   - 반응형 그리드 레이아웃 (모바일: 1열, 태블릿: 2열, 데스크톱: 3열)
   - 호버 효과 및 애니메이션

3. **YouTube 임베드 컴포넌트**
   - iframe 최적화 (lazy loading)
   - 반응형 비디오 비율 유지
   - 로딩 상태 표시

4. **추가 섹션 (선택적)**
   - 최신 콘텐츠 미리보기
   - 주요 토픽/카테고리 소개

---

### Phase 4: About 페이지 구현
**목표**: 채널 및 블로그 소개 페이지

1. **채널 소개 섹션**
   - CodeGear 소개
   - 채널의 목표와 비전
   - 주요 콘텐츠 카테고리

2. **유튜브 채널 링크**
   - 채널 카드 컴포넌트
   - 구독 링크 및 정보
   - 아이콘과 함께 시각적 표현

3. **블로그 링크**
   - 블로그 카드 컴포넌트
   - 주요 포스트 소개
   - 방문 링크

4. **컨택트/소셜 미디어**
   - 소셜 미디어 아이콘 그리드
   - Heroicons 사용

---

### Phase 5: 애니메이션 및 인터랙션
**목표**: 사용자 경험을 향상시키는 부드러운 애니메이션

1. **페이지 전환 애니메이션**
   - Framer Motion 사용
   - 페이드 인/아웃 효과

2. **스크롤 애니메이션**
   - 스크롤 시 요소 fade-in
   - Intersection Observer API 활용

3. **호버 효과**
   - 버튼 호버 스케일 및 색상 변화
   - 카드 호버 시 shadow 효과
   - 링크 호버 애니메이션

4. **로딩 상태**
   - 스켈레톤 UI
   - 스피너 컴포넌트

---

### Phase 6: 반응형 디자인 최적화
**목표**: 모든 기기에서 완벽한 사용자 경험

1. **브레이크포인트 설정**
   - Mobile: < 768px
   - Tablet: 768px - 1024px
   - Desktop: > 1024px

2. **레이아웃 조정**
   - 모바일: 단일 열 레이아웃
   - 태블릿: 2열 그리드
   - 데스크톱: 3열 그리드

3. **폰트 크기 조정**
   - 반응형 타이포그래피
   - clamp() 함수 활용

4. **터치 최적화**
   - 모바일 버튼 크기 (최소 44px)
   - 터치 제스처 지원

---

### Phase 7: SEO 및 메타데이터 최적화
**목표**: 검색 엔진 최적화 및 소셜 미디어 공유 최적화

1. **메타데이터 설정**
   - 각 페이지별 title, description
   - Open Graph 태그
   - Twitter Card 태그

2. **구조화된 데이터**
   - JSON-LD 스키마
   - Organization/WebSite 스키마

3. **sitemap.xml 생성**
   - Next.js의 sitemap 기능 활용

4. **robots.txt 설정**

5. **이미지 최적화**
   - Next.js Image 컴포넌트 사용
   - Pixabay 이미지 활용
   - alt 텍스트 추가

---

### Phase 8: 성능 및 접근성 최적화
**목표**: Core Web Vitals 개선 및 웹 접근성 준수

1. **성능 최적화**
   - 이미지 lazy loading
   - 코드 스플리팅
   - 폰트 최적화 (next/font)
   - 번들 크기 분석 및 최적화

2. **Core Web Vitals**
   - LCP (Largest Contentful Paint) < 2.5s
   - FID (First Input Delay) < 100ms
   - CLS (Cumulative Layout Shift) < 0.1

3. **접근성 (WCAG 2.1 AA 준수)**
   - 시맨틱 HTML 사용
   - ARIA 속성 추가
   - 키보드 내비게이션 지원
   - 충분한 색상 대비 (4.5:1)
   - 스크린 리더 테스트

4. **성능 테스트**
   - Lighthouse 점수 90+ 목표
   - WebPageTest 분석

---

### Phase 9: 최종 검토 및 배포 준비
**목표**: 프로덕션 배포 준비

1. **크로스 브라우저 테스트**
   - Chrome, Firefox, Safari, Edge
   - 모바일 브라우저 (iOS Safari, Chrome Mobile)

2. **콘텐츠 최종 검토**
   - 오타 및 문법 확인
   - 링크 작동 확인
   - 이미지 로딩 확인

3. **환경 변수 설정**
   - .env.example 파일 생성
   - API 키 등 민감 정보 분리

4. **빌드 및 배포 설정**
   - Next.js 프로덕션 빌드
   - Vercel/Netlify 배포 설정 (추천)
   - 도메인 연결 준비

---

## 기술 스택 상세

### Core
- **Next.js 14+** (App Router)
- **React 18+**
- **TypeScript**

### Styling
- **Tailwind CSS** - 유틸리티 기반 스타일링
- **CSS Modules** (필요시)

### UI/UX
- **Heroicons** - 아이콘 패키지
- **Framer Motion** - 애니메이션
- **next-themes** - 다크모드

### Performance
- **Next.js Image** - 이미지 최적화
- **next/font** - 폰트 최적화

### Development
- **ESLint** - 코드 품질
- **Prettier** - 코드 포맷팅

---

## 디자인 가이드라인

### 컬러 팔레트
- **Primary**: 브랜드 컬러 (예: 블루/퍼플 계열)
- **Secondary**: 강조 컬러
- **Light Mode**:
  - Background: White (#FFFFFF)
  - Text: Dark Gray (#1F2937)
- **Dark Mode**:
  - Background: Dark Gray (#111827)
  - Text: Light Gray (#F9FAFB)

### 타이포그래피
- **Headings**: Bold, Large (48px-32px)
- **Body**: Regular, Readable (16px-18px)
- **Font Family**: Inter, Pretendard, 또는 시스템 폰트

### 간격 및 레이아웃
- **컨테이너 최대 너비**: 1280px
- **섹션 간격**: 80px-120px
- **요소 간격**: 16px-32px

---

## 체크리스트

### Phase 1: 프로젝트 설정
- [ ] Next.js 프로젝트 생성
- [ ] 의존성 패키지 설치
- [ ] Tailwind CSS 설정
- [ ] 프로젝트 구조 생성

### Phase 2: 레이아웃
- [ ] Header 컴포넌트
- [ ] Footer 컴포넌트
- [ ] 테마 프로바이더
- [ ] 루트 레이아웃

### Phase 3: 홈 페이지
- [ ] 히어로 섹션
- [ ] 유튜브 영상 섹션
- [ ] 임베드 컴포넌트

### Phase 4: About 페이지
- [ ] 채널 소개
- [ ] 유튜브/블로그 링크
- [ ] 소셜 미디어

### Phase 5: 애니메이션
- [ ] 페이지 전환
- [ ] 스크롤 애니메이션
- [ ] 호버 효과

### Phase 6: 반응형
- [ ] 브레이크포인트 설정
- [ ] 레이아웃 조정
- [ ] 모바일 최적화

### Phase 7: SEO
- [ ] 메타데이터
- [ ] 구조화된 데이터
- [ ] sitemap/robots

### Phase 8: 성능/접근성
- [ ] 성능 최적화
- [ ] Core Web Vitals
- [ ] 접근성 준수

### Phase 9: 배포
- [ ] 크로스 브라우저 테스트
- [ ] 콘텐츠 검토
- [ ] 배포 설정

---

## 다음 단계
Phase 1부터 순차적으로 진행하며, 각 단계 완료 후 다음 단계로 이동합니다.
