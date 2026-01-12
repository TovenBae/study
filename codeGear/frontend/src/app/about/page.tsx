import Link from "next/link";
import { PlayCircleIcon, DocumentTextIcon } from "@heroicons/react/24/outline";
import type { Metadata } from "next";

export const metadata: Metadata = {
  title: "소개 - CodeGear",
  description: "CodeGear 유튜브 채널과 블로그에 대한 소개",
};

export default function AboutPage() {
  return (
    <div className="flex flex-col">
      <section className="relative overflow-hidden bg-gradient-to-b from-background to-muted/20 py-20 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-2xl text-center">
            <h1 className="text-4xl font-bold tracking-tight text-foreground sm:text-6xl animate-fade-in">
              <span className="block bg-gradient-to-r from-primary-500 to-secondary-500 bg-clip-text text-transparent">
                CodeGear
              </span>
              에 대하여
            </h1>
            <p className="mt-6 text-lg leading-8 text-muted-foreground">
              AI에 관심 있는 개발자를 위한 실용적이고 전문적인 정보를 제공합니다
            </p>
          </div>
        </div>
      </section>

      <section className="py-20 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-3xl">
            <div className="space-y-16">
              <div>
                <h2 className="text-3xl font-bold tracking-tight text-foreground mb-6">
                  우리의 목표
                </h2>
                <div className="prose prose-lg max-w-none text-muted-foreground">
                  <p className="text-lg leading-8">
                    AI 관련 정보는 인터넷에 넘쳐나지만, 개발자에게 정말로 필요한 실용적인 정보를 찾기는 쉽지 않습니다.
                    CodeGear는 이러한 문제를 해결하기 위해 시작되었습니다.
                  </p>
                  <p className="text-lg leading-8 mt-4">
                    우리는 최신 AI 기술, 개발 도구, 자동화 솔루션에 대한 실전 경험과 노하우를 공유합니다.
                    이론보다는 실제로 적용 가능한 지식을, 복잡함보다는 명확하고 효율적인 설명을 제공하는 것이 우리의 목표입니다.
                  </p>
                </div>
              </div>

              <div className="border-t border-border/40 pt-16">
                <h2 className="text-3xl font-bold tracking-tight text-foreground mb-8">
                  주요 콘텐츠
                </h2>
                <div className="grid gap-6 md:grid-cols-2">
                  <div className="rounded-lg border border-border/40 p-6 hover:border-primary-500/50 transition-all hover:shadow-md">
                    <h3 className="text-xl font-semibold text-foreground mb-3">
                      AI 개발 도구
                    </h3>
                    <p className="text-muted-foreground">
                      Cursor, Cline 등 최신 AI 기반 개발 도구의 실제 사용 경험과 활용 팁을 공유합니다.
                    </p>
                  </div>
                  <div className="rounded-lg border border-border/40 p-6 hover:border-primary-500/50 transition-all hover:shadow-md">
                    <h3 className="text-xl font-semibold text-foreground mb-3">
                      워크플로우 자동화
                    </h3>
                    <p className="text-muted-foreground">
                      n8n, MCP 등을 활용한 AI 워크플로우 자동화 방법과 실전 사례를 다룹니다.
                    </p>
                  </div>
                  <div className="rounded-lg border border-border/40 p-6 hover:border-primary-500/50 transition-all hover:shadow-md">
                    <h3 className="text-xl font-semibold text-foreground mb-3">
                      셀프 호스팅
                    </h3>
                    <p className="text-muted-foreground">
                      AWS, Docker 등을 이용한 AI 서비스 셀프 호스팅 가이드를 제공합니다.
                    </p>
                  </div>
                  <div className="rounded-lg border border-border/40 p-6 hover:border-primary-500/50 transition-all hover:shadow-md">
                    <h3 className="text-xl font-semibold text-foreground mb-3">
                      생산성 향상
                    </h3>
                    <p className="text-muted-foreground">
                      AI를 활용한 개발 생산성 향상 방법과 실용적인 팁을 나눕니다.
                    </p>
                  </div>
                </div>
              </div>

              <div className="border-t border-border/40 pt-16">
                <h2 className="text-3xl font-bold tracking-tight text-foreground mb-8">
                  채널 및 블로그
                </h2>
                <div className="grid gap-8 md:grid-cols-2">
                  <div className="group relative overflow-hidden rounded-2xl bg-gradient-to-br from-primary-500/10 to-primary-500/5 p-8 hover:shadow-xl transition-all border border-primary-500/20">
                    <div className="absolute top-0 right-0 -mt-4 -mr-4 h-24 w-24 rounded-full bg-primary-500/10 blur-2xl" />
                    <PlayCircleIcon className="h-12 w-12 text-primary-500 mb-4" />
                    <h3 className="text-2xl font-bold text-foreground mb-3">
                      유튜브 채널
                    </h3>
                    <p className="text-muted-foreground mb-6">
                      영상으로 배우는 AI 개발 실전 가이드
                    </p>
                    <Link
                      href="https://www.youtube.com/@codegear-21"
                      target="_blank"
                      rel="noopener noreferrer"
                      className="inline-flex items-center gap-2 text-sm font-semibold text-primary-500 hover:text-primary-600 transition-colors"
                    >
                      채널 방문하기
                      <span className="transition-transform group-hover:translate-x-1">→</span>
                    </Link>
                  </div>

                  <div className="group relative overflow-hidden rounded-2xl bg-gradient-to-br from-secondary-500/10 to-secondary-500/5 p-8 hover:shadow-xl transition-all border border-secondary-500/20">
                    <div className="absolute top-0 right-0 -mt-4 -mr-4 h-24 w-24 rounded-full bg-secondary-500/10 blur-2xl" />
                    <DocumentTextIcon className="h-12 w-12 text-secondary-500 mb-4" />
                    <h3 className="text-2xl font-bold text-foreground mb-3">
                      블로그
                    </h3>
                    <p className="text-muted-foreground mb-6">
                      깊이 있는 기술 문서와 튜토리얼
                    </p>
                    <Link
                      href="https://codegear.tistory.com/"
                      target="_blank"
                      rel="noopener noreferrer"
                      className="inline-flex items-center gap-2 text-sm font-semibold text-secondary-500 hover:text-secondary-600 transition-colors"
                    >
                      블로그 방문하기
                      <span className="transition-transform group-hover:translate-x-1">→</span>
                    </Link>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section className="bg-muted/50 py-20 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-2xl text-center">
            <h2 className="text-3xl font-bold tracking-tight text-foreground sm:text-4xl mb-6">
              함께 성장해요
            </h2>
            <p className="text-lg leading-8 text-muted-foreground mb-10">
              CodeGear와 함께 최신 AI 기술을 배우고, 개발 생산성을 높이세요.
              여러분의 구독과 관심이 더 나은 콘텐츠를 만드는 원동력입니다.
            </p>
            <div className="flex items-center justify-center gap-x-6">
              <Link
                href="https://www.youtube.com/@codegear-21"
                target="_blank"
                rel="noopener noreferrer"
                className="group flex items-center gap-2 rounded-full bg-primary-500 px-6 py-3 text-sm font-semibold text-white shadow-sm hover:bg-primary-600 transition-all hover:scale-105"
              >
                <PlayCircleIcon className="h-5 w-5" />
                유튜브 구독하기
              </Link>
              <Link
                href="https://codegear.tistory.com/"
                target="_blank"
                rel="noopener noreferrer"
                className="group flex items-center gap-2 rounded-full bg-secondary-500 px-6 py-3 text-sm font-semibold text-white shadow-sm hover:bg-secondary-600 transition-all hover:scale-105"
              >
                <DocumentTextIcon className="h-5 w-5" />
                블로그 읽기
              </Link>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}
