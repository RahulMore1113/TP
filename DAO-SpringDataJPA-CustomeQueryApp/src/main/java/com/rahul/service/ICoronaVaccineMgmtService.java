package com.rahul.service;

import java.util.List;

import com.rahul.bo.CoronaVaccine;

public interface ICoronaVaccineMgmtService {
	
	public List<CoronaVaccine> fetchVaccineByCompany(String company);

}
