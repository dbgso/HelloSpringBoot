package com.example.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class SampleController {

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
			model.addAttribute("message", "your name: " + name + ", your age: " + age);
		}
		return "sample";
	}

}
