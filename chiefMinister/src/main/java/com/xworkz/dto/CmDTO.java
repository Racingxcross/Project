package com.xworkz.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CmDTO {

	@NotNull(message = "CM name cannot be null and blank")
	@Size(min = 3, max = 20, message = "CM name should be more den 3 and less 20")
	private String name;
	@NotNull(message = "Party name cannot be null and blank")
	@Size(min = 3, max = 20, message = "Party name should be more den 3 and less 20")
	private String party;
	@NotNull(message = "State name cannot be null and blank")
	@Size(min = 1, max = 20, message = "State name should be more den 3 and less 20")
	private String state;
	@Min(value = 1, message = "Tenure cannot be less 1 or Zero.")
	private Integer tenure;
	@NotNull(message = "Gender name cannot be null and blank")
	@Size(min = 3, max = 20, message = "Gender name should be more den 3 and less 20")
	private String gender;
	@NotNull(message = "PortFolio name cannot be null and blank")
	@Size(min = 3, max = 5000, message = "PortFolio name should be more den 3 and less 20")
	private String portFolio;
}
