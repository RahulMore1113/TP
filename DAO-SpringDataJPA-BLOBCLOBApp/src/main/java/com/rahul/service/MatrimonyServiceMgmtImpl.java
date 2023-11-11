package com.rahul.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.bo.MarriageSeeker;
import com.rahul.dao.IMarriageSeekerRepo;

@Service("service")
public class MatrimonyServiceMgmtImpl implements IMatrimonyServiceMgmt {

	@Autowired
	private IMarriageSeekerRepo repo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {

		return "Marriage Seeker save with the id :: " + repo.save(seeker).getId();

	}

	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id) {

		return repo.findById(id);

	}

}
