package com.exconnect.urlshortner.exception;

public class UrlNotShortened extends Exception{
    public UrlNotShortened() {
    }

    public UrlNotShortened(String message) {
        super(message);
    }

    public UrlNotShortened(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlNotShortened(Throwable cause) {
        super(cause);
    }

    public UrlNotShortened(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
