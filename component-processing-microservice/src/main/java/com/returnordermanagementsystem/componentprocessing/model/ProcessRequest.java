package com.returnordermanagementsystem.componentprocessing.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="process_request")
public class ProcessRequest {
	@Id
	private int userId;
	private String userName;
	private long contactNumber;
	private long creditCardNumber;
	private String componentType;
	private String componentName;
	private int numberOfDefective;
	@JsonProperty
	private boolean isPriorityRequest;
}
