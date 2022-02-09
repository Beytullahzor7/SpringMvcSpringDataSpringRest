package com.innova.repository;

import com.innova.entity.ComputerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IComputerRepository extends CrudRepository<ComputerEntity,Long> {

    //1. YOL
    List<ComputerEntity> findComputerEntityByComputerName(String computerName);

    //2. YOL
//    @Query("select c from ComputerEntity c where c.computerName=:computerName")
//    List<ComputerEntity> findComputerEntityByComputerName(@Param("computerName") String computerName);
}
