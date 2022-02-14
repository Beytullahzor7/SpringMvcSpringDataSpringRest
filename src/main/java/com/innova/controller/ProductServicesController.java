package com.innova.controller;

import com.innova.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@Log4j2
public class ProductServicesController {

    // http://127.0.0.1:8080/client/controller/string
    @GetMapping("/client/controller/string")
    @ResponseBody
    public String getProductServicesString(){
        String URL = "http://localhost:8080/rest/manueljson";
        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(URL, String.class);
        log.info(jsonData);
        return jsonData;
    }

    // http://localhost:8080/client/controller/productdto
    @GetMapping("/client/controller/productdto")
    @ResponseBody
    public String getProductServicesDto(){
        String URL = "http://localhost:8080/rest/dynamicsjson";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class);
        return "client restten veri aldı " + productDto;
    }

    // http://localhost:8080/client/controller/productdto/special/Deneme55
    @GetMapping("/client/controller/productdto/special/{urun_adi}")
    @ResponseBody
    public String getProductServicesResponseEntity(@PathVariable(name = "urun_adi") String urunAdi){
        String URL = "http://localhost:8080/rest/pathvariable/" + urunAdi;
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto = restTemplate.getForObject(URL, ProductDto.class);
        //Kontrol
        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, ProductDto.class);
        ProductDto productDto2 = responseEntity.getBody();
        return "client restten veri aldı " + productDto2;
    }

    // http://localhost:8080/client/controller/productdto/specialList
    @GetMapping("/client/controller/productdto/specialList")
    @ResponseBody
    public List<ProductDto> getProductServicesResponseEntityList(){
        String URL = "http://localhost:8080/rest/list";
        RestTemplate restTemplate = new RestTemplate();
        //Anonymous Class
        ResponseEntity<List<ProductDto>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ProductDto>>() {});

        List<ProductDto> list = responseEntity.getBody();
        for(ProductDto temp : list){
            log.info(temp);
        }
        //Databaseye, dosyaya kaydetmek
        return list;
    }

    ////////////////////////////////////////////////////////////////

    //POST
    // http://localhost:8080/post/basic
    @GetMapping("/client/controller/post")
    @ResponseBody
    public String postBasic(){
        ProductDto productDto = ProductDto.builder().productId(0L).productName("Beytullah").productPrice(500).build();
        String URL = "http://localhost:8080/post/basic";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(URL, productDto, Void.class);
        return "Success!";
    }

    // http://localhost:8080/client/controller/dto?urun_adi=bilgisayar&urun_fiyati=7000
    @GetMapping("/client/controller/dto")
    @ResponseBody
    public String postProduct(@RequestParam(name = "urun_adi") String urunAdi,
                              @RequestParam(name = "urun_fiyati") double urunFiyati){

        ProductDto productDto = ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();

        String URL = "http://localhost:8080/post/productdto";
        RestTemplate restTemplate = new RestTemplate();
        ProductDto productDto1 = restTemplate.postForObject(URL, productDto, ProductDto.class);
        return "Success " + productDto1;
    }

    // http://localhost:8080/client/controller/post/responseentity?urun_adi=bilgisayar&urun_fiyati=7000
    @GetMapping("/client/controller/post/responseentity")
    @ResponseBody
    public String postProductdtoResponseEntity(@RequestParam(name = "urun_adi") String urunAdi,
                              @RequestParam(name = "urun_fiyati") double urunFiyati){

        ProductDto productDto = ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();
        String URL = "http://localhost:8080/post/productdto";
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<ProductDto> productDtoHttpEntity = new HttpEntity<>(productDto);
        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, productDtoHttpEntity, ProductDto.class);
        ProductDto productDto1 = responseEntity.getBody();
        return "Success HttpEntity bir hata varsa almak icin " + productDto1;
    }

    // http://localhost:8080/client/controller/put/responseentity?urun_adi=bilgisayar2&urun_fiyati=5000
    @GetMapping("/client/controller/put/responseentity")
    @ResponseBody
    public String putProductdtoResponseEntity(@RequestParam(name = "urun_adi") String urunAdi,
                                               @RequestParam(name = "urun_fiyati") double urunFiyati){

        ProductDto productDto = ProductDto.builder().productId(0L).productName(urunAdi).productPrice(urunFiyati).build();
        String URL = "http://localhost:8080/put/productdto";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto), ProductDto.class);
        ProductDto productDto1 = responseEntity.getBody();
        return "Update Success HttpEntity bir hata varsa almak icin " + productDto1;
    }

    // http://localhost:8080/client/controller/delete/5
    @GetMapping("/client/controller/delete/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable(name = "id") Long id){
        String URL = "http://localhost:8080/delete/productdto/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(URL, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
        return "Silindi " + id;
    }
}
