package com.innova.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//Client
@Controller
public class HeaderBodyController {

    //Client servera gizli olarak data gönderir
    // Asagidaki link @RestControllera gidecek ve geri gelecek
    // http://localhost:8080/controller/client/header
    @GetMapping("/controller/client/header")
    @ResponseBody
    public String getHeaderController(){
        String URL = "http://localhost:8080/service/client/header";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("key_header", "Bu data Headere gidecek");

        HttpEntity<String> httpEntity = new HttpEntity<>("Bu data verisi", httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class);
        String result = responseEntity.getBody();
        return "@Controller(Client): "+result;
    }
}
