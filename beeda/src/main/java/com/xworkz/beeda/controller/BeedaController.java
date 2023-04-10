package com.xworkz.beeda.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.beeda.dto.BeedaDTO;
import com.xworkz.beeda.service.BeedaService;

@Controller
@RequestMapping("/")
public class BeedaController {
	@Autowired
	private BeedaService beedaService;

	private List<String> type = Arrays.asList("sweet", "masala", "spicy", "mix");

	public BeedaController() {
		System.out.println("created:" + getClass().getSimpleName());
	}

	@GetMapping("/eat")
	public String onEat(Model model) {
		System.out.println("Running onEat in controller");
		model.addAttribute("type", type);
		return "register";
	}

	@PostMapping("/eat")
	public String onEat(Model model, BeedaDTO dto) {
		System.out.println("Running post method onEat in controller");
		Set<ConstraintViolation<BeedaDTO>> violation = this.beedaService.validateAndSave(dto);
		if (violation.isEmpty()) {
			System.out.println("no violation in controller go to next page");
			model.addAttribute("stallName", dto.getStallName());
			model.addAttribute("ownerName", dto.getOwnerName());
			model.addAttribute("type", dto.getType());
			model.addAttribute("price", dto.getPrice());
			model.addAttribute("quantity", dto.getQuantity());
			return "register";
		}
		model.addAttribute("type", type);
		model.addAttribute("errors", violation);
		System.err.println("violation in controller");
		return "register";

	}

	@GetMapping("/find")
	public String onSearch(@RequestParam int id, Model model) {
		System.out.println("Running on search for id" + id);

		BeedaDTO dto = this.beedaService.findById(id);
		System.out.println(dto);
		if (dto != null) {
			System.out.println(dto);
			model.addAttribute("dto", dto);
		} else {
			model.addAttribute("message", "data not found,please enter valid data");

		}
		return "search";
	}

	@GetMapping("/pan")
	public String onfind(@RequestParam String stallName, Model model) {
		System.out.println("running onfind in controller" + stallName);
		List<BeedaDTO> list = this.beedaService.findByStallName(stallName);
		if (list != null) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("message", "stallName not found");
		}
		return "searchByStallName";
	}

	@GetMapping("/update")
	public String onUpdate(@RequestParam int id, Model model) {
		System.out.println("Running on update" + id);
		BeedaDTO dto = this.beedaService.findById(id);
		model.addAttribute("dto", dto);
		model.addAttribute("type", type);
		return "updateStall";
	}

	@PostMapping("/update")
	public String onUpdate(BeedaDTO dto, Model model) {
		System.out.println("Running onupdate" + dto);
		Set<ConstraintViolation<BeedaDTO>> constraintViolations = this.beedaService.validateAndUpdate(dto);
		if (constraintViolations.size() > 0) {
			model.addAttribute("errors", constraintViolations);
		} else {
			model.addAttribute("message", "data updated successfully");
		}
		return "updateStall";
	}

	@GetMapping("/delete")
	public String onDelete(@RequestParam int id, Model model) {
		boolean delete = this.beedaService.validateAndDelete(id);
		if (delete = true) {
			model.addAttribute("message", "delete successfully");
			model.addAttribute("id", id);
		} else {
			model.addAttribute("errors", "id not found");
		}
		return "searchByStallName";
	}

}
