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

    //REQUEST HEADER
    //Client servera gizli olarak data gönderir
    // Asagidaki link @RestControllera gidecek ve geri gelecek
    // http://localhost:8080/controller/client/header
    @GetMapping("/controller/client/header")
    @ResponseBody
    public String getRequestHeaderController(){
        String URL = "http://localhost:8080/service/client/header";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("key_header", "Bu data Headere gidecek");

        HttpEntity<String> httpEntity = new HttpEntity<>("Bu data verisi", httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class);
        String result = responseEntity.getBody();
        return "@Controller(Client): " + result;
    }

    //RESPONSE HEADER
    //Server header olusturup clienta gönderir
    // http://localhost:8080/controller/response/header
    @GetMapping("/controller/response/header")
    @ResponseBody
    public String getResponseHeaderController(){
        String URL = "http://localhost:8080/service/response/header";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> data = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String gelenData = data.getHeaders().getFirst("key_response");
        String body = data.getBody();
        return "@Controller(Client): " + body + " " + gelenData;
    }

    //REQUEST COOKIE
    // http://localhost:8080/controller/client/cookie
    @GetMapping("/controller/client/cookie")
    @ResponseBody
    public String getRequestCookie(){
        String URL = "http://localhost:8080/service/client/cookie";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.COOKIE, "key_cookie=cookieValue");

        HttpEntity<String> httpEntity = new HttpEntity<>("Bu data verisi", httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class);
        String result = responseEntity.getBody();
        return "@Controller(Client): " + result;
    }

    //RESPONSE COOKIE
    // http://localhost:8080/controller/response/cookie
    @GetMapping("/controller/response/cookie")
    @ResponseBody
    public String getResponseCookie(){
        String URL = "http://localhost:8080/service/response/cookie";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> data = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String gelenData = data.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        String body = data.getBody();

        return "@Controller(Client): " + body + " " + gelenData;
    }
}
