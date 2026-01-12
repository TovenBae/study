"use client";

import { useTheme } from "next-themes";
import { useEffect, useState } from "react";
import { SunIcon, MoonIcon, ComputerDesktopIcon } from "@heroicons/react/24/outline";
import { cn } from "@/lib/utils";

export function ThemeToggle() {
  const [mounted, setMounted] = useState(false);
  const { theme, setTheme } = useTheme();

  useEffect(() => {
    setMounted(true);
  }, []);

  if (!mounted) {
    return (
      <div className="w-10 h-10 rounded-md bg-muted animate-pulse" />
    );
  }

  const themes = [
    { value: "light", icon: SunIcon, label: "라이트" },
    { value: "dark", icon: MoonIcon, label: "다크" },
    { value: "system", icon: ComputerDesktopIcon, label: "시스템" },
  ];

  return (
    <div className="relative inline-flex rounded-lg bg-muted p-1">
      {themes.map(({ value, icon: Icon, label }) => (
        <button
          key={value}
          onClick={() => setTheme(value)}
          className={cn(
            "relative inline-flex items-center justify-center rounded-md px-3 py-2 text-sm font-medium transition-all",
            "focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring focus-visible:ring-offset-2",
            theme === value
              ? "bg-background text-foreground shadow-sm"
              : "text-muted-foreground hover:text-foreground"
          )}
          title={label}
        >
          <Icon className="h-4 w-4" />
          <span className="sr-only">{label}</span>
        </button>
      ))}
    </div>
  );
}
