package com.exconnect.urlshortner.service;

import com.exconnect.urlshortner.exception.UrlNotShortened;
import com.exconnect.urlshortner.util.UrlShortenerUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortnerServiceTest {

    @Test
    void shortenAndRetrieveUrl() throws UrlNotShortened {
        UrlShortnerService service = new UrlShortnerService();
        String original = "https://example.com/page";
        String shortUrl = service.shortenUrl(original);
        assertEquals(shortUrl, service.shortenUrl(original));
        String code = shortUrl.substring(UrlShortenerUtil.baseUrl.length());
        assertEquals(original, service.getOriginalUrl(code));
    }
}
