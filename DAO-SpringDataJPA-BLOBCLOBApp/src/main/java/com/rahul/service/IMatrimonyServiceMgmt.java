package com.rahul.service;

import java.util.Optional;

import com.rahul.bo.MarriageSeeker;

public interface IMatrimonyServiceMgmt {

	public String registerMarriageSeeker(MarriageSeeker seeker);

	public Optional<MarriageSeeker> searchSeekerById(Long id);

}
