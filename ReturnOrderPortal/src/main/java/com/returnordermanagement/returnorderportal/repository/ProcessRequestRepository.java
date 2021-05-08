package com.returnordermanagement.returnorderportal.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanagement.returnorderportal.model.ProcessRequest;

@Repository
public interface ProcessRequestRepository extends CrudRepository<ProcessRequest, Integer> {

}
