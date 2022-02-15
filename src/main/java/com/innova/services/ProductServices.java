package com.innova.services;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

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

    ///////////
    // STATUS CODE
    // http://localhost:8080/rest/status1
    @GetMapping("/rest/status1")
    public ResponseEntity<ProductDto> getStatus1(){
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Telefon1").productPrice(5000).build();
        //Datamız varsa, bir sıkıntı yoksa ==> OK

        //return new ResponseEntity<>(productDto, HttpStatus.OK); 1.YOL
        // return ResponseEntity.status(HttpStatus.OK).body(productDto); 2. YOL
        // return ResponseEntity.ok().body(productDto); 3. YOL
        log.info(productDto);
        return ResponseEntity.ok(productDto);
    }

    // http://localhost:8080/rest/status2/notfound/56
    @GetMapping("/rest/status2/notfound/{id}")
    public ResponseEntity<?> getStatus2(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id).productName("Telefon2").productPrice(7000).build();

        if(productDto.getProductId() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt Bulunamadı"); //olmayan kaydı db den çekmek istedigimizde
        }
        return ResponseEntity.status(HttpStatus.OK).body(id + " kayıt bulundu...");
    }

    // http://localhost:8080/rest/status2/badrequest/0
    @GetMapping("/rest/status2/badrequest/{id}")
    public ResponseEntity<?> getStatus3(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id).productName("Telefon3").productPrice(7000).build();

        if(productDto.getProductId() == 0){
            return ResponseEntity.badRequest().build(); //HTTP ERROR 400
        }
        return ResponseEntity.status(HttpStatus.OK).body(id + " kayıt bulundu...");
    }

    // http://localhost:8080/rest/status2/ok4/5
    @GetMapping("/rest/status2/ok4/{id}")
    public ResponseEntity<?> getStatus4(@PathVariable(name = "id") Long id){
        ProductDto productDto = ProductDto.builder().productId(id).productName("Telefon4").productPrice(4000).build();
        return
                (ResponseEntity<?>) ResponseEntity
                        .status(HttpStatus.OK)
                        .contentType(new MediaType("application", "json", Charset.forName("UTF-8")))
                        .body(" Tamamdir");
    }
}
