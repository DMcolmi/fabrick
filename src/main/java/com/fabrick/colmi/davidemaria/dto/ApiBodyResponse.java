package com.fabrick.colmi.davidemaria.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiBodyResponse<T> {
	String status;
	List<String>  errors;
	T payload;
}
