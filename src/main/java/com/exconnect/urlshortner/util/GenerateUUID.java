package com.exconnect.urlshortner.util;

import java.util.UUID;

public class GenerateUUID {

    public static long generateRandomUUID(String inputString){

       return UUID.nameUUIDFromBytes(inputString.getBytes()).getMostSignificantBits();

    }

}
