package com.xworkz.car.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.car.dto.userDTO;
import com.xworkz.car.entity.CarEntity;
import com.xworkz.car.repository.CarRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository repository;
	@Autowired
	private PasswordEncoder epassword;

	public Set<ConstraintViolation<userDTO>> validate(userDTO dto) {
		log.info("Running validate in serviceImpl");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<userDTO>> violations = validator.validate(dto);
		return violations;
	}

	public CarServiceImpl() {
		log.info("" + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<userDTO>> validateandsave(userDTO dto) {
		Long userCount = this.repository.findByuserName(dto.getUserName());
		Long emailCount = this.repository.findByEmail(dto.getEmail());
		Long mobileCount = this.repository.findByMobile(dto.getMobile());
		log.error("emailCount-" + emailCount);
		log.error("userCount-" + userCount);
		log.error("mobileCount-" + mobileCount);

		Set<ConstraintViolation<userDTO>> violations = validate(dto);
		if (violations != null && !violations.isEmpty()) {
			log.info("there is Violation in dto");
			return violations;
		}
		if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			return null;
		}
		if (emailCount == 0 && userCount == 0 && mobileCount == 0) {
			log.info("No Violations procceding to save");
			CarEntity entity = new CarEntity();
			entity.setUserName(dto.getUserName());
			entity.setEmail(dto.getEmail());
			entity.setMobile(dto.getMobile());
			entity.setAgreement(dto.getAgreement());
			entity.setCreatedBy(dto.getUserName());
			entity.setPassword(epassword.encode(dto.getPassword()));
			entity.setCreatedDate(LocalDateTime.now());
			entity.setResetPassword(false);
			entity.setPasswordChangedTime(LocalTime.of(0, 0, 0));
			// BeanUtils.copyProperties(dto, entity);
			boolean saved = this.repository.save(entity);
			log.info("Saved in Entity-" + saved);

			if (saved) {
				boolean sent = this.sendMail(dto.getEmail(), "Thanks for registration");
				log.info("Saved in Entity-" + saved);
				log.info("Email sent -:" + sent);

			}
		}
		return Collections.emptySet();
	}

	@Override
	public userDTO userSignIn(String userName, String password) {
		CarEntity entity = this.repository.userSignIn(userName);
		userDTO dto = new userDTO();
		BeanUtils.copyProperties(entity, dto);
		log.info("matching--" + password.matches(password));
		log.info("Time matching--" + entity.getPasswordChangedTime().isBefore(LocalTime.now()));
		log.info("Now Present Time--" + LocalTime.now());
		log.info("PasswordChangedTime--" + entity.getPasswordChangedTime());

//		if (entity.getResetPassword() == true && LocalTime.now().isBefore(entity.getPasswordChangedTime())) {
//			log.info("Running in Time matching");
//			return dto;
//		}

		log.info("Time " + LocalTime.now().isBefore(entity.getPasswordChangedTime()));
		if (entity.getLoginCount() >= 3) {
			log.info("Running in Login count condition");
			return dto;
		}

		if (dto.getUserName().equals(userName) && epassword.matches(password, entity.getPassword())) {
			log.info("Running userId matching and password matching");
			return dto;
		} else {
			this.repository.loginCount(userName, entity.getLoginCount() + 1);
			log.info("count of login" + entity.getLoginCount() + 1);
			return null;
		}
	}

	@Override
	public List<userDTO> findAll() {
		List<CarEntity> carEntity = this.repository.findAll();
		List<userDTO> lists = new ArrayList<userDTO>();
		for (CarEntity entity : carEntity) {
			userDTO dto = new userDTO();
			BeanUtils.copyProperties(entity, dto);
			lists.add(dto);

		}
		return lists;
	}

	@Override
	public Long findByEmail(String email) {
		Long emailcount = this.findByEmail(email);
		log.error("Find  by Email");
		return emailcount;
	}

	@Override
	public Long findByMobile(Long number) {
		Long mobilecount = this.repository.findByMobile(number);
		log.error("Find  by mobile count");
		return mobilecount;

	}

	@Override
	public Long findByuserName(String user) {
		log.error("Find  by user count");
		Long userCount = this.repository.findByuserName(user);
		return userCount;
	}

	@Override
	public userDTO resetPassword(String email) {
		log.info("Running in resetPassword");
		String resetPassword = DefaultPasswordGenerator.generate(6);
		log.info("Reset password--" + resetPassword);
		CarEntity entity = this.repository.resetPassword(email);
		if (entity != null) {
			log.info("entity found for email" + email);
			entity.setPassword(epassword.encode(resetPassword));
			entity.setUpdatedBy("System");
			entity.setUpdatedDate(LocalDateTime.now());
			entity.setLoginCount(0);
			entity.setResetPassword(true);
			entity.setPasswordChangedTime(LocalTime.now().plusSeconds(120));
			log.info("resetPassword---" + resetPassword);
			boolean update = this.repository.update(entity);
			if (update) {
				sendMail(entity.getEmail(), "Your  reseted password is-> " + resetPassword
						+ "   : Plz log in again with in 2 min with this password ");
			}
			log.info("Updated---" + update);
			userDTO updatedDto = new userDTO();
			BeanUtils.copyProperties(entity, updatedDto);

			return updatedDto;
		}
		log.info("entity not found for email" + email);
		return CarService.super.resetPassword(email);
	}

	@Override
	public userDTO updatePassword(String userName, String password, String confirmPassword) {
		log.info("Running in updating password condition");
		if (password.equals(confirmPassword)) {
			boolean passwordUpdated = this.repository.updatePassword(userName, epassword.encode(password), false,
					LocalTime.of(0, 0, 0));
			log.info("passwordUpdated--" + passwordUpdated);
		}

		return CarService.super.updatePassword(userName, password, confirmPassword);
	}

	@Override
	public boolean sendMail(String email, String text) {
		String portNumber = "587";// 485,587,25
		String hostName = "smtp.office365.com";
		String fromEmail = "gagan5144@outlook.com";
		String password = "Gagan@2000";
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration  Completed");
			// message.setText("Thanks for registration and your password is" +
			// reSetPassword);
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			log.info("mail sent sucessfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}

	public final static class DefaultPasswordGenerator {
		private static final String[] charCategories = new String[] { "abcdefghijklmnopqrstuvwxyz",
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "0123456789" };

		public static String generate(int length) {
			StringBuilder password = new StringBuilder(length);
			Random random = new Random(System.nanoTime());

			for (int i = 0; i < length; i++) {
				String charCategory = charCategories[random.nextInt(charCategories.length)];
				int position = random.nextInt(charCategory.length());
				password.append(charCategory.charAt(position));
			}

			return new String(password);
		}
//		String password = DefaultPasswordGenerator.generate(6);[use this reference to generate the password]
	}

	@Override
	public userDTO updateProfile(String userName, String email, Long mobile, String path) {
		CarEntity entity = this.repository.resetPassword(email);
		log.info("userName: " + userName + "email: " + email + "mobile: " + mobile + "image name: " + path);

		entity.setUserName(userName);
		entity.setMobile(mobile);
		entity.setPicName(path);
		boolean updated = this.repository.update(entity);
		log.info("updated--" + updated);
		return CarService.super.updateProfile(userName, email, mobile, path);
	}

}
