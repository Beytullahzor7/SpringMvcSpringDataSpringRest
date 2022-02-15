package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
public class PostmanServices {

    //http://localhost:8080/api/rest/postman/dynamicsjson
    @GetMapping("/rest/postman/dynamicsjson")
    public ProductDto getDynamicsJson(){
        ProductDto productDto = ProductDto.builder()
                .productId(0L)
                .productName("Product57")
                .productPrice(55)
                .build();
        return productDto;
    }
    //GET
    //http://localhost:8080/rest/postman/list
    @GetMapping(value = "/rest/postman/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProducesList(){
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi1").productPrice(66).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi2").productPrice(66).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi3").productPrice(66).build());
        productDtoList.add(ProductDto.builder().productId(0L).productName("urunAdi4").productPrice(56).build());
        return productDtoList;
    }

    //POST
    // http://localhost:8080/rest/postman/post
    @PostMapping(value = "rest/postman/post")
    public ProductDto postProduct(ProductDto productDto){
        ProductDto productDto1 = productDto;
        log.info(productDto1);
        return productDto1;
    }

    //PUT
    // http://localhost:8080/rest/postman/put
    @PutMapping(value = "rest/postman/put")
    public void putProduct(ProductDto productDto){
        ProductDto productDto2 = productDto;
        log.info(productDto2);
    }

    //DELETE
    // http://localhost:8080/rest/postman/delete/2
    @DeleteMapping(value = "rest/postman/delete/{id}")
    public void putProduct(@PathVariable(name = "id") Long id){
        log.info(id + " silindi");
    }
}
