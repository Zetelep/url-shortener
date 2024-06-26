package com.urlshortener.generator;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;

import java.nio.charset.Charset;

public class GenerateShortUrl {
    public static String getShortUrl(String url){
        String shortUrl = Hashing.murmur3_32_fixed().hashString(
                url, Charset.defaultCharset()).toString();
        return shortUrl;
    }

    public static boolean isUrlValid(String url){
        UrlValidator urlValidator = new UrlValidator(
          new  String[]{"http","https"}
        );
        return urlValidator.isValid(url);
    }
}
