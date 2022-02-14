package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class ProductServices {

    //POST
    // http://localhost:8080/post/basic
    @PostMapping("/post/basic")
    public void postVoid( @RequestBody ProductDto productDto){
        log.info(productDto);
        //database
    }

    // http://localhost:8080/post/productdto
    @PostMapping("/post/productdto")
    public ProductDto postProduct( @RequestBody ProductDto productDto){
        log.info(productDto);
        //database
        return productDto;
    }

    /////////////////////////////////

    //PUT
    // http://localhost:8080/put/productdto
    @PutMapping("/put/productdto")
    public ProductDto putProduct(@RequestBody ProductDto productDto){
        log.info(productDto);
        //database
        return productDto;
    }

    //DELETE
    // http://localhost:8080/delete/productdto
    @DeleteMapping("/delete/productdto/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        log.info("Silindi " + id);
        //database
    }
}
