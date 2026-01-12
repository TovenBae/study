import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import { ThemeProvider } from "@/components/theme-provider";
import { Header } from "@/components/layout/header";
import { Footer } from "@/components/layout/footer";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "CodeGear - AI 개발자를 위한 실용적인 정보",
  description: "AI에 관심 있는 개발자를 위한 실용적이고 전문적인 정보를 제공하는 CodeGear 유튜브 채널과 블로그",
  keywords: ["AI", "개발", "프로그래밍", "유튜브", "블로그", "CodeGear"],
  authors: [{ name: "CodeGear" }],
  openGraph: {
    title: "CodeGear - AI 개발자를 위한 실용적인 정보",
    description: "AI에 관심 있는 개발자를 위한 실용적이고 전문적인 정보",
    type: "website",
    locale: "ko_KR",
  },
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="ko" suppressHydrationWarning>
      <body
        className={`${geistSans.variable} ${geistMono.variable} antialiased`}
      >
        <ThemeProvider
          attribute="class"
          defaultTheme="system"
          enableSystem
          disableTransitionOnChange
        >
          <div className="relative flex min-h-screen flex-col">
            <Header />
            <main className="flex-1">{children}</main>
            <Footer />
          </div>
        </ThemeProvider>
      </body>
    </html>
  );
}
