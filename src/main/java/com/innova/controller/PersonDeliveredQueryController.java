package com.innova.controller;

import com.innova.entity.PersonEntity;
import com.innova.repository.IDeliveredQueryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class PersonDeliveredQueryController {

    @Autowired
    IDeliveredQueryRepository iDeliveredQueryRepository;

    //SAVE
    //http://localhost:8080/person/create/
    @GetMapping("/person/create")
    @ResponseBody
    public String getSavePerson(){
        for(int i=0; i<10; i++){
            PersonEntity personEntity = PersonEntity.builder()
                    .personId(0L).personName("Person Name" + i).personPrice(i*200)
                    .build();

            iDeliveredQueryRepository.save(personEntity);
        }
        return PersonEntity.class + " Ekleme Basarili";
    }

    //FIND-STARTSWITH
    //http://localhost:8080/person/find/starts/a     // LIKE a% sql
    @GetMapping("/person/find/starts/{starts}")
    @ResponseBody
    public String getFindStartsPerson(@PathVariable(name = "starts") String personStarts){
        Iterable<PersonEntity> iterable = iDeliveredQueryRepository.findByPersonNameStartsWith(personStarts);
        for(PersonEntity temp : iterable){
            log.info(temp);
        }
        return iterable+"";
    }

    //FIND-ENDSWITH
    //http://localhost:8080/person/find/ends/5   // LIKE %a sql
    @GetMapping("/person/find/ends/{ends}")
    @ResponseBody
    public String getFindEndsPerson(@PathVariable(name = "ends") String personEnds){
        Iterable<PersonEntity> iterable = iDeliveredQueryRepository.findByPersonNameEndsWith(personEnds);
        for(PersonEntity temp : iterable){
            log.info(temp);
        }
        return iterable+"";
    }
}
