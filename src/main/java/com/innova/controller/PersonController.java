package com.innova.controller;

import com.innova.entity.PersonEntity;
import com.innova.repository.IPersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonController {

    @Autowired
    IPersonRepository iPersonRepository;

    //SAVE
    //http://localhost:8080/person/create2
    @GetMapping("/person/create2")
    @ResponseBody
    public String getSavePerson(){
        for(int i=0; i<10; i++){
            PersonEntity personEntity = PersonEntity.builder()
                    .personId(0L).personName("Person Name" + i).personPrice(i*200)
                    .build();

            iPersonRepository.save(personEntity);
        }
        return PersonEntity.class + " Ekleme Basarili";
    }

    //PAGING
    // http://localhost:8080/person/paging
    @GetMapping("/person/paging")
    @ResponseBody
    public String getPaging(){
        Pageable pageable = PageRequest.of(0,4); //0. Sayfadaki 4 tane datayı getir
        Page<PersonEntity> personEntities = iPersonRepository.findAll(pageable);
        for(PersonEntity temp : personEntities){
            log.info(temp);
        }
        return personEntities+" ";
    }

    //PAGING OPTIONAL
    // http://localhost:8080/person/paging/optional/1 //sayfalama 0 dan basladıgı icin buraya ne yazarsak 1 fazlasını verir
    @GetMapping("/person/paging/optional/{page}")
    @ResponseBody
    public String getPagingOptional( @PathVariable(name = "page") int paging ){
        Pageable pageable = PageRequest.of(paging,4); //Istedigin sayfadaki datayı getir
        Page<PersonEntity> personEntities = iPersonRepository.findAll(pageable);
        for(PersonEntity temp : personEntities){
            log.info(temp);
        }
        return personEntities+" ";
    }

    //SORTING ASCENDING
    // http://localhost:8080/person/sorting/ascending
    @GetMapping("/person/sorting/ascending")
    @ResponseBody
    public String getSortingAsc(){
        Sort sort = Sort.by("personName");
        Iterable<PersonEntity> personEntities = iPersonRepository.findAll(sort);
        for(PersonEntity temp : personEntities){
            log.info(temp);
        }
        return personEntities+" ";
    }

    //SORTING DESCENDING
    // http://localhost:8080/person/sorting/descending
    @GetMapping("/person/sorting/descending")
    @ResponseBody
    public String getSortingDesc(){
        Sort sort = Sort.by("personName").descending();
        Iterable<PersonEntity> personEntities = iPersonRepository.findAll(sort);
        for(PersonEntity temp : personEntities){
            log.info(temp);
        }
        return personEntities+" ";
    }

    //PAGING AND SORTING
    // http://localhost:8080/person/sortingandpaging
    @GetMapping("/person/sortingandpaging")
    @ResponseBody
    public String getSortingAndPaging(){
        Pageable pageable = PageRequest.of(0,4, Sort.by("date").descending());
        Iterable<PersonEntity> personEntities = iPersonRepository.findAll(pageable);
        for(PersonEntity temp : personEntities){
            log.info(temp);
        }
        return personEntities+" ";
    }
}
