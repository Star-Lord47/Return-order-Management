package com.returnordermanagement.returnorderportal.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
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
@Entity
@ToString
@Component
@Table(name = "process_request")
public class ProcessRequest {
	@Id
	private int userId;
	@NotNull
	@Value("${username-error}")
	private String userName;
	private long contactNumber;
	private long creditCardNumber;
	private String componentType;
	@NotNull
	@Value("${componentName-error}")
	private String componentName;
	private int numberOfDefective;
	private boolean isPriorityRequest;
}
