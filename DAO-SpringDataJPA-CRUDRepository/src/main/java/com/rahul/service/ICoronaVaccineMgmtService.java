package com.rahul.service;

import java.util.List;
import java.util.Optional;

import com.rahul.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public String registerVaccine(CoronaVaccine vaccine);

	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);

	public Long getVaccineCount();

	public boolean checkAvaibilityByRegNo(Long regNo);

	public Iterable<CoronaVaccine> fetchAllDetails();

	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids);

	public Optional<CoronaVaccine> fetchVaccineByID(Long id);

	public String removeVaccineById(Long id);

	public String removeVaccineByObject(CoronaVaccine vaccine);

	public String removeVaccinesById(List<Long> ids);

}
