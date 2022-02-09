package com.innova.services;

import com.innova.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonServices {

    //http://localhost:8080/rest/manueljson
    @GetMapping("/rest/manueljson")
    public String getManuelJson(){
        return "{\"adisoyadi\": \"Beytullah Zor\"}";
    }

    //http://localhost:8080/rest/dynamicsjson
    @GetMapping("/rest/dynamicsjson")
    public ProductDto getDynamicsJson(){
        ProductDto productDto = ProductDto.builder()
                .productId(0L)
                .productName("Product55")
                .productPrice(55)
                .build();
        return productDto;
    }

    //http://localhost:8080/rest/mediatype
    @GetMapping(value = "/rest/mediatype", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getProduces(){
        ProductDto productDto = ProductDto.builder()
                .productId(0L)
                .productName("Product66")
                .productPrice(66)
                .build();
        return productDto;
    }

    //http://localhost:8080/rest/pathvariable/kalem
    @GetMapping(value = "/rest/pathvariable/{urunadi}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getProduces(@PathVariable(name = "urunadi") String urunAdi){
        ProductDto productDto = ProductDto.builder()
                .productId(0L)
                .productName(urunAdi)
                .productPrice(66)
                .build();
        return productDto;
    }

    //http://localhost:8080/rest/list
    @GetMapping(value = "/rest/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProducesList(){
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi1").productPrice(66).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi2").productPrice(66).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi3").productPrice(66).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi4").productPrice(66).build());
        return productDtoList;
    }
}
