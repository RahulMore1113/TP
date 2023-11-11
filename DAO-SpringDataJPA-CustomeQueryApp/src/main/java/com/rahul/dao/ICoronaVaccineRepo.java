package com.rahul.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

	public List<CoronaVaccine> findByCompany(String company);

}
