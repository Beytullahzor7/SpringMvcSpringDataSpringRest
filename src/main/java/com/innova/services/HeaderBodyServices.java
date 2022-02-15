package com.innova.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Server
@RestController
@Log4j2
public class HeaderBodyServices {

    // REQUEST HEADER
    // http://localhost:8080/service/client/header
    @GetMapping("/service/client/header")
    public ResponseEntity<?> getRequestHeader(@RequestHeader(value = "key_header", defaultValue = "default header") String gelenHeader){
        log.info("@RestController(Server): "+ gelenHeader);
        return ResponseEntity.ok(gelenHeader);
    }

    //RESPONSE HEADER
    //Server header olusturup clienta gönderir
    // http://localhost:8080/service/response/header
    @GetMapping("/service/response/header")
    public ResponseEntity<?> getResponseHeader(){
        return ResponseEntity
                .ok()
                .header("key_response", "Serverdan gelen response")
                .body("@RestController: gelen veri");
    }

    // REQUEST COOKIE
    // Client cookie olusturup servera gönderir
    // http://localhost:8080/service/client/cookie
    @GetMapping("/service/client/cookie")
    public ResponseEntity<?> getRequestCookie(@CookieValue(value = "key_cookie", defaultValue = "default cookie") String gelenCookie){
        log.info("@RestController(Server): "+ gelenCookie);
        return ResponseEntity.ok(gelenCookie);
    }

    // RESPONSE COOKIE
    // Server cookie olusturup clienta gönderir
    // http://localhost:8080/service/response/cookie
    @GetMapping("/service/response/cookie")
    public ResponseEntity<?> getResponseCookie(){
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, "key_response_cookie")
                .body("@RestController: gelen cookie verisi");
    }
}
