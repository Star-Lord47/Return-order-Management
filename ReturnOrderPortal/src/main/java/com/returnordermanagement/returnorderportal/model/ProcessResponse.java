package com.returnordermanagement.returnorderportal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@ToString
@Table(name = "process_response")
public class ProcessResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;
	private int userId;
	private double processingCharge;
	private double packagingAndDeliveryCharge;
	private LocalDate dateOfDelivery;
}
