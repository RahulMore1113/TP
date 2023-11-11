package com.rahul.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rahul.bo.MarriageSeeker;

public interface IMarriageSeekerRepo
		extends PagingAndSortingRepository<MarriageSeeker, Long>, CrudRepository<MarriageSeeker, Long> {

}
