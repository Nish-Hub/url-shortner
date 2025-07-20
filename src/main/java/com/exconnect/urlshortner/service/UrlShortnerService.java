package com.exconnect.urlshortner.service;

import com.exconnect.urlshortner.exception.UrlNotShortened;
import com.exconnect.urlshortner.pojo.ShortUrlPojo;
import com.exconnect.urlshortner.util.GenerateUUID;
import com.exconnect.urlshortner.util.UrlShortenerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class UrlShortnerService {

    Map<Long, ShortUrlPojo> shortUrlMap = new ConcurrentHashMap<>();

    public String shortenUrl(String originalUrl){
        try{
            this.getShortUrl(originalUrl);
        } catch (UrlNotShortened e) {
            log.info("Url not shortened");
        }

        String shortUrl = UrlShortenerUtil.generateUrlSuffix();
        shortUrlMap.put(GenerateUUID.generateRandomUUID(originalUrl),
                ShortUrlPojo.builder()
                        .originalUrl(originalUrl)
                        .shortUrlGenerationTimestamp(System.currentTimeMillis())
                        .shortUrl(shortUrl)
                        .build());
        return shortUrl;

    }

    public String getShortUrl(String originalUrl) throws UrlNotShortened {
        long uuid  = GenerateUUID.generateRandomUUID(originalUrl);
        if(shortUrlMap.containsKey(uuid))
            return shortUrlMap.get(uuid).getShortUrl();

        throw new UrlNotShortened("Url not found");

    }
}
