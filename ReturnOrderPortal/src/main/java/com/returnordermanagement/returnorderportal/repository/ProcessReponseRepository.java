package com.returnordermanagement.returnorderportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanagement.returnorderportal.model.ProcessResponse;


@Repository
public interface ProcessReponseRepository extends JpaRepository<ProcessResponse, Integer> {

}
