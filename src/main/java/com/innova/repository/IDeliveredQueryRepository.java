package com.innova.repository;

import com.innova.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDeliveredQueryRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findByPersonNameStartsWith(String personName);
    List<PersonEntity> findByPersonNameEndsWith(String personName);

}
