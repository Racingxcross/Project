package com.xworkz.car.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AbstractAudit {
	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;

}
