package com.example.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class PersonForm {

	@NotBlank
	@Size(max = 31)
	private String name;
	
	@Min(0)
	private int age;

}
