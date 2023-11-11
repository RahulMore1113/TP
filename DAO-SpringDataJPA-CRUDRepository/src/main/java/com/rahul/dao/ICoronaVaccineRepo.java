package com.rahul.dao;

import org.springframework.data.repository.CrudRepository;

import com.rahul.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}
