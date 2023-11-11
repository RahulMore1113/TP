package com.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.bo.CoronaVaccine;
import com.rahul.dao.ICoronaVaccineRepo;

@Service("service")
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService {

	@Autowired
	private ICoronaVaccineRepo repo;

	@Override
	public String registerVaccine(CoronaVaccine vaccine) {

		CoronaVaccine saveVaccine = null;

		if (vaccine != null)
			saveVaccine = repo.save(vaccine);

		return saveVaccine != null ? "vaccine registered successfully with id " + saveVaccine.getRegNo()
				: "vaccine registration failed";
	}

	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {

		if (vaccines != null)
			return repo.saveAll(vaccines);
		else
			throw new IllegalArgumentException("Batch insertion not done");

	}

	@Override
	public Long getVaccineCount() {
		return repo.count();
	}

	@Override
	public boolean checkAvaibilityByRegNo(Long regNo) {
		return repo.existsById(regNo);
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return repo.findAll();
	}

	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public Optional<CoronaVaccine> fetchVaccineByID(Long id) {
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Long id) {

		Optional<CoronaVaccine> optional = repo.findById(id);

		if (optional.isPresent()) {
			repo.deleteById(id);
			return "Record deleted having id :: " + id;
		} else
			return "Record not available for deletion with the id :: " + id;

	}

	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {

		Optional<CoronaVaccine> optional = repo.findById(vaccine.getRegNo());
		if (optional.isPresent()) {
			repo.delete(vaccine);
			return "Record deleted for the id :: " + vaccine.getRegNo();
		}

		return "Record not available for deletion with the id :: " + vaccine.getRegNo();
	}

	@Override
	public String removeVaccinesById(List<Long> ids) {

		Iterable<CoronaVaccine> iterable = repo.findAllById(ids);
		int count = ids.size();
		if (count == ((List<CoronaVaccine>) iterable).size()) {
			repo.deleteAllById(ids);
			return count + " no of ids are deleted...";
		}

		return "Problem with deletion records";
	}

}
