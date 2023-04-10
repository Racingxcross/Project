package com.xworkz.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.dto.CmDTO;
import com.xworkz.service.CmService;

@Controller
@RequestMapping
public class CmController {
	@Autowired
	private CmService cmService;

	public CmController() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	@PostMapping("/cm")
	public String onCm(CmDTO cmdto, Model model) {
		System.out.println("Running the OnCm..." + cmdto);
		Set<ConstraintViolation<CmDTO>> constraintViolations = this.cmService.validateAndSave(cmdto);
		if (!constraintViolations.isEmpty()) {
			System.out.println("Validation Failed Check the errors..");
			constraintViolations.forEach((cv) -> System.err.println(cv.getMessage()));
		} else {
			System.out.println("Validation is Succesfully done, Displaying the data.." + cmdto);
		}

		return "Cm";
	}

}
