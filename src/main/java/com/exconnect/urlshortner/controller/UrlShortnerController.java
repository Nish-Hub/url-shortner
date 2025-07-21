package com.exconnect.urlshortner.controller;

import com.exconnect.urlshortner.exception.UrlNotShortened;
import com.exconnect.urlshortner.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UrlShortnerController {

    private UrlShortnerService urlShortnerService;

    @Autowired
    public UrlShortnerController(UrlShortnerService urlShortnerService){
        this.urlShortnerService = urlShortnerService;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String,String> data) throws UrlNotShortened {

        String originalUrl = data.get("url");

        // shorten the url
        return this.urlShortnerService.shortenUrl(originalUrl);

    }

    @GetMapping("/{shortCode}")
    public String redirect(@PathVariable String shortCode) throws UrlNotShortened {

        return this.urlShortnerService.getOriginalUrl(shortCode);
    }

}
