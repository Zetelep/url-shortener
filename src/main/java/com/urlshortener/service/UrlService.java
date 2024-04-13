package com.urlshortener.service;

import com.urlshortener.data.Url;
import com.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.urlshortener.generator.GenerateShortUrl.getShortUrl;
import static com.urlshortener.generator.GenerateShortUrl.isUrlValid;


@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Url generateShortUrl(String url){
        if(! isUrlValid(url)){
            System.out.println("Url is not valid!");
            return null;
        }

        Url urlObject = new Url();
        urlObject.setShort_url(getShortUrl(url));
        urlObject.setOriginal_url(url);

        return urlRepository.save(urlObject);
    }

    public String getOriginalUrl(String id){
        return urlRepository.findByShortUrl(id);
    }
}
