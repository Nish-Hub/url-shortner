package com.exconnect.urlshortner.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShortUrlPojo {
    String originalUrl;
    String shortUrl;
    Long shortUrlGenerationTimestamp;
}
