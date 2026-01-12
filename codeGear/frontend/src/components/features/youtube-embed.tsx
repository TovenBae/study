"use client";

import { useState } from "react";

interface YouTubeEmbedProps {
  videoId: string;
  title: string;
}

export function YouTubeEmbed({ videoId, title }: YouTubeEmbedProps) {
  const [isLoading, setIsLoading] = useState(true);

  return (
    <div className="group relative overflow-hidden rounded-xl bg-muted transition-all hover:shadow-xl hover:scale-[1.02]">
      <div className="relative aspect-video w-full">
        {isLoading && (
          <div className="absolute inset-0 flex items-center justify-center bg-muted">
            <div className="h-12 w-12 animate-spin rounded-full border-4 border-primary-500 border-t-transparent" />
          </div>
        )}
        <iframe
          src={`https://www.youtube.com/embed/${videoId}`}
          title={title}
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowFullScreen
          onLoad={() => setIsLoading(false)}
          className="absolute inset-0 h-full w-full"
          loading="lazy"
        />
      </div>
      <div className="p-4">
        <h3 className="line-clamp-2 text-sm font-semibold text-foreground group-hover:text-primary-500 transition-colors">
          {title}
        </h3>
      </div>
    </div>
  );
}
