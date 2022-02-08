package com.innova.repository;

import com.innova.entity.ComputerEntity;
import org.springframework.data.repository.CrudRepository;

public interface IComputerRepository extends CrudRepository<ComputerEntity,Long> {
}
