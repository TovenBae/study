import Link from "next/link";

export function Footer() {
  return (
    <footer className="w-full border-t border-border/40 bg-background">
      <div className="mx-auto max-w-7xl px-6 py-12 lg:px-8">
        <div className="grid grid-cols-1 gap-8 md:grid-cols-3">
          <div className="space-y-4">
            <h3 className="text-lg font-semibold bg-gradient-to-r from-primary-500 to-secondary-500 bg-clip-text text-transparent">
              CodeGear
            </h3>
            <p className="text-sm text-muted-foreground">
              AI에 관심 있는 개발자를 위한 실용적이고 전문적인 정보를 제공합니다.
            </p>
          </div>

          <div className="space-y-4">
            <h3 className="text-sm font-semibold text-foreground">링크</h3>
            <ul className="space-y-2">
              <li>
                <Link
                  href="https://www.youtube.com/@codegear-21"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-sm text-muted-foreground hover:text-primary-500 transition-colors"
                >
                  유튜브 채널
                </Link>
              </li>
              <li>
                <Link
                  href="https://codegear.tistory.com/"
                  target="_blank"
                  rel="noopener noreferrer"
                  className="text-sm text-muted-foreground hover:text-primary-500 transition-colors"
                >
                  블로그
                </Link>
              </li>
            </ul>
          </div>

          <div className="space-y-4">
            <h3 className="text-sm font-semibold text-foreground">페이지</h3>
            <ul className="space-y-2">
              <li>
                <Link
                  href="/"
                  className="text-sm text-muted-foreground hover:text-primary-500 transition-colors"
                >
                  홈
                </Link>
              </li>
              <li>
                <Link
                  href="/about"
                  className="text-sm text-muted-foreground hover:text-primary-500 transition-colors"
                >
                  소개
                </Link>
              </li>
            </ul>
          </div>
        </div>

        <div className="mt-8 border-t border-border/40 pt-8">
          <p className="text-center text-xs text-muted-foreground">
            © {new Date().getFullYear()} CodeGear. All rights reserved.
          </p>
        </div>
      </div>
    </footer>
  );
}
