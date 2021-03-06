package com.innova.controller;

import com.innova.entity.ComputerEntity;
import com.innova.repository.IComputerRepository;
import com.innova.repository.impl.MyRepositoryImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class ComputerController {

    @Autowired
    IComputerRepository icomputerRepository;

    //SAVE
    // http://localhost:8080/computer/create
    @GetMapping("/computer/create")
    @ResponseBody
    public String getCreateComputer(){
        ComputerEntity computerEntity = ComputerEntity.builder()
                .computerId(0L)
                .computerName("computerName55")
                .computerTrade("computerTrade55")
                .computerPrice(55)
                .build();
        icomputerRepository.save(computerEntity);
        return "Ekleme Basarili";
    }

    // http://localhost:8080/computer/create2?computer_name=Monster&computer_trade=Abra&computer_price=12000
    @GetMapping("/computer/create2")
    @ResponseBody
    public String getCreateComputerRequestParam(
            @RequestParam(name = "computer_name") String computerName,
            @RequestParam(name = "computer_trade") String computerTrade,
            @RequestParam(name = "computer_price") double computerPrice
    ){
        ComputerEntity computerEntity = ComputerEntity.builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade(computerTrade)
                .computerPrice(computerPrice)
                .build();
        icomputerRepository.save(computerEntity);
        return "Ekleme Basarili RequestParam";
    }

    //FIND
    // http://localhost:8080/computer/find/4
    @GetMapping("/computer/find/{id}")
    @ResponseBody
    public String getFindComputer(@PathVariable(name = "id") Long idim){
        Optional<ComputerEntity> optional = icomputerRepository.findById(idim);
        if(optional.isPresent()){
            ComputerEntity computerEntity = optional.get();
            return "Data bulundu " + computerEntity;
        }else{
            return "Data bulunamad?? ";
        }
    }

    //DELETE
    // http://localhost:8080/computer/delete/4
    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String getDeleteComputer(@PathVariable(name = "id") Long idim){
        Optional<ComputerEntity> optional = icomputerRepository.findById(idim);
        if(optional.isPresent()){
            ComputerEntity computerEntity = optional.get();
            icomputerRepository.deleteById(idim);
            return "Silme Islemi Gerceklesti " + computerEntity;
        }else{
            return "Silinecek Data bulunamad?? ";
        }
    }

    //UPDATE
    // http://localhost:8080/computer/update/2?computer_name=Asus&computer_trade=newModel&computer_price=9000
    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String getUpdateComputer(
            @PathVariable(name = "id") Long idim, //Ilk olarak update edilecek id nin kontrol?? saglan??r
            @RequestParam(name = "computer_name") String computerName, //Sonras??nda fieldlar g??ncellenir
            @RequestParam(name = "computer_trade") String computerTrade,
            @RequestParam(name = "computer_price") double computerPrice
    ){
        Optional<ComputerEntity> optional = icomputerRepository.findById(idim);
        if(optional.isPresent()){
            ComputerEntity computerEntity2 = optional.get();
            computerEntity2.setComputerName(computerName);
            computerEntity2.setComputerTrade(computerTrade);
            computerEntity2.setComputerPrice(computerPrice);
            icomputerRepository.save(computerEntity2);
            return "Guncelleme Islemi Gerceklesti " + computerEntity2;
        }else{
            return "G??ncellenecek Data bulunamad?? ";
        }
    }

    //SELECT
    // http://localhost:8080/computer/select/findall
    @GetMapping("/computer/select/findall")
    @ResponseBody
    public String getComputerSelectAll(){
       Iterable<ComputerEntity> iterableList = icomputerRepository.findAll();

       for(ComputerEntity temp : iterableList){
           log.info(temp);
       }
       return iterableList+""; //Yap??n??n string olmas??n?? saglad??k
    }

    //SELECT
    // http://localhost:8080/computer/select/findall/spesific/name55
    @GetMapping("/computer/select/findall/spesific/{computer_name}")
    @ResponseBody
    public String getComputerSelectAllSpesific( @PathVariable(name = "computer_name") String InputComputerName ){
        List<ComputerEntity> list = icomputerRepository.findComputerEntityByComputerName(InputComputerName);

        for(ComputerEntity temp : list){
            log.info(temp);
        }
        return list+""; //Yap??n??n string olmas??n?? saglad??k
    }

    //Kendi yazd??g??m repositoryi kullanacag??m

    @Autowired
    MyRepositoryImp myRepositoryImp;

    //SELECT
    // http://localhost:8080/computer/select/minprice/8000
    @GetMapping("/computer/select/minprice/{computer_price}")
    @ResponseBody
    public String getComputerSelectPriceMin( @PathVariable(name = "computer_price") double InputComputerPrice ){
        List<ComputerEntity> list = myRepositoryImp.findComputerPriceMin(InputComputerPrice);

        for(ComputerEntity temp : list){
            log.info(temp);
        }
        return list+"";
    }









}
