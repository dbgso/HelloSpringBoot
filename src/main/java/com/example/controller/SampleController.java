package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@Controller
@RequestMapping("/test")
public class SampleController {
	@Autowired
	PersonRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	String get(Model model) {
		model.addAttribute("message", "Hello, Spring Boot!");
		return "sample";
	}

	@RequestMapping(method = RequestMethod.POST)
	String post(@ModelAttribute @Valid PersonForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Error");
		} else {
			String name = form.getName();
			int age = form.getAge();
			repository.save(new Person(name, age));
		}
		model.addAttribute("persons", repository.findAll());
		return "sample";
	}

}
