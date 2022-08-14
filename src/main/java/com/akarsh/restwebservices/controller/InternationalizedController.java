package com.akarsh.restwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1")
public class InternationalizedController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping(path = "/good-morning")
    public String goodMorningInternationalized(
//            @RequestHeader(name = "Accept-Language", required = false) Locale locale
            ){
//        return messageSource.getMessage("good.morning.message",null, "?",locale);
        return messageSource.getMessage("good.morning.message",null, "?", LocaleContextHolder.getLocale());
    }

}
