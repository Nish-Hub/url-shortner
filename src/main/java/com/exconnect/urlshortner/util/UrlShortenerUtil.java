package com.exconnect.urlshortner.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UrlShortenerUtil {

    static AtomicInteger intCounter = new AtomicInteger(Integer.MIN_VALUE);

    static StringBuffer stringPrefix = new StringBuffer();

    static final String baseUrl = "http://localhost:8080/";

    public static String generateUrlSuffix(){
        return baseUrl+getNextSuffix();
    }

    private static String getNextSuffix(){
        if(intCounter.get()==Integer.MAX_VALUE){
            intCounter.set(Integer.MIN_VALUE);
            String nextStringPrefix = getNextString();
            return nextStringPrefix+intCounter;
        }

        return stringPrefix.toString()+intCounter.incrementAndGet();

    }

    private static String getNextString(){
        if(stringPrefix.isEmpty()){
            stringPrefix.append('a');
            return stringPrefix.toString();
        }

        String lastCharacter = stringPrefix.substring(stringPrefix.length()-1);
        if(lastCharacter.equals("z"))
            stringPrefix.append("a");
        else {
            String nextCharacter = String.valueOf((char)(lastCharacter.toCharArray()[0]+1));
            stringPrefix.replace(stringPrefix.length() - 1, stringPrefix.length(), nextCharacter);
        }

        return stringPrefix.toString();

    }


}
