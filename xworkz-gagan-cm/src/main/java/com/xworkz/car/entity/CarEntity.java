package com.xworkz.car.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "car_table")

@NamedQuery(name = "find", query = "select ent from CarEntity ent")
@NamedQuery(name = "userName", query = "select count(*) from  CarEntity ent where ent.userName=:userBy")
@NamedQuery(name = "emailId", query = "select count(*) from  CarEntity ent where ent.email=:emailBy")
@NamedQuery(name = "mobileId", query = "select count(*) from  CarEntity ent where ent.mobile=:mobileBy")
@NamedQuery(name = "userANDpassword", query = "select ent from CarEntity ent where ent.userName=:ui")
@NamedQuery(name = "emailid", query = "select ent from CarEntity ent where ent.email=:ei")
@NamedQuery(name = "user", query = "select ent from CarEntity ent where ent.userName=:ui")
@NamedQuery(name = "updateLoginCount", query = "update CarEntity ent set ent.loginCount=:count where ent.userName=:userID")
@NamedQuery(name = "updatePassword", query = "update CarEntity ent set ent.password=:up , ent.resetPassword=:urp where ent.userName=:uu")
public class CarEntity {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_Name")
	private String userName;
	@Column(name = "email_ID")
	private String email;
	@Column(name = "mobile")
	private long mobile;
	@Column(name = "password")
	private String password;
	@Column(name = "agreement")
	private Boolean agreement;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	@Column(name = "updatedBy")
	private String updatedBy;
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;
	@Column(name = "logincount")
	private int loginCount;
	@Column(name = "RESET_PWD")
	private Boolean resetPassword;
}
