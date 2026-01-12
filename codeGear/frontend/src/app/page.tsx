import Link from "next/link";
import { YouTubeEmbed } from "@/components/features/youtube-embed";
import { ArrowRightIcon, PlayCircleIcon, DocumentTextIcon } from "@heroicons/react/24/outline";

export default function Home() {
  const featuredVideos = [
    {
      id: "AWWNCGXFTfw",
      title: "Cursor AI 대체, 무료 오픈소스 Cline AI 쓸만할까?",
    },
    {
      id: "XXurwjs307s",
      title: "AI로 [유튜브 요약+노트 저장] 자동화하는 법 - MCP+Obsidian+Cline+Gemini",
    },
    {
      id: "rZnBHanWiZg",
      title: "n8n(AI워크플로우자동화) AWS 셀프호스팅 방법",
    },
  ];

  return (
    <div className="flex flex-col">
      <section className="relative overflow-hidden bg-gradient-to-b from-background to-muted/20 py-20 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-2xl text-center">
            <h1 className="text-4xl font-bold tracking-tight text-foreground sm:text-6xl animate-fade-in">
              AI 개발자를 위한
              <span className="block bg-gradient-to-r from-primary-500 to-secondary-500 bg-clip-text text-transparent">
                실용적인 정보
              </span>
            </h1>
            <p className="mt-6 text-lg leading-8 text-muted-foreground animate-slide-up">
              AI 관련 정보는 많지만, 개발자에게 꼭 필요한 정보는 찾기 어렵습니다.
              CodeGear는 전문적이고 실용적인 정보를 명확하고 효율적으로 전달합니다.
            </p>
            <div className="mt-10 flex items-center justify-center gap-x-6">
              <Link
                href="https://www.youtube.com/@codegear-21"
                target="_blank"
                rel="noopener noreferrer"
                className="group flex items-center gap-2 rounded-full bg-primary-500 px-6 py-3 text-sm font-semibold text-white shadow-sm hover:bg-primary-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-primary-500 transition-all hover:scale-105"
              >
                <PlayCircleIcon className="h-5 w-5" />
                유튜브 채널 방문
                <ArrowRightIcon className="h-4 w-4 transition-transform group-hover:translate-x-1" />
              </Link>
              <Link
                href="https://codegear.tistory.com/"
                target="_blank"
                rel="noopener noreferrer"
                className="group flex items-center gap-2 rounded-full bg-secondary-500 px-6 py-3 text-sm font-semibold text-white shadow-sm hover:bg-secondary-600 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-secondary-500 transition-all hover:scale-105"
              >
                <DocumentTextIcon className="h-5 w-5" />
                블로그 방문
                <ArrowRightIcon className="h-4 w-4 transition-transform group-hover:translate-x-1" />
              </Link>
            </div>
          </div>
        </div>

        <div className="absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]">
          <div className="relative left-[calc(50%+3rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-primary-500 to-secondary-500 opacity-20 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]" />
        </div>
      </section>

      <section className="py-20 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-2xl text-center mb-16">
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
              인기 영상
            </h2>
            <p className="mt-4 text-lg text-muted-foreground">
              가장 많은 사랑을 받은 CodeGear의 영상을 만나보세요
            </p>
          </div>

          <div className="grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-3">
            {featuredVideos.map((video) => (
              <YouTubeEmbed
                key={video.id}
                videoId={video.id}
                title={video.title}
              />
            ))}
          </div>
        </div>
      </section>

      <section className="bg-muted/50 py-20 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-2xl text-center">
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl">
              CodeGear와 함께하세요
            </h2>
            <p className="mt-6 text-lg leading-8 text-muted-foreground">
              최신 AI 기술과 개발 팁을 정기적으로 업데이트합니다.
              지금 바로 구독하고 더 많은 콘텐츠를 만나보세요.
            </p>
            <div className="mt-10 flex items-center justify-center gap-x-6">
              <Link
                href="/about"
                className="text-sm font-semibold leading-6 text-foreground hover:text-primary-500 transition-colors flex items-center gap-2 group"
              >
                더 알아보기
                <ArrowRightIcon className="h-4 w-4 transition-transform group-hover:translate-x-1" />
              </Link>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}
