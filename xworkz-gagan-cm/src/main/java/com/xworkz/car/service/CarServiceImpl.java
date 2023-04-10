package com.xworkz.car.service;

import java.time.LocalDateTime;
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
			entity.setCreatedBy(dto.getUserName());
			entity.setCreatedDate(LocalDateTime.now());
			entity.setResetPassword(false);
			BeanUtils.copyProperties(dto, entity);
			boolean saved = this.repository.save(entity);
			if (saved) {
				boolean sent = this.sendMail(dto.getEmail());
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
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		log.info("service dto---" + dto);
		if (entity.getUserName().equals(userName) && entity.getPassword().equals(password)) {
			return dto;
		}
		return null;
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
	public Long findByuserName(String name) {
		Long usercount = this.repository.findByuserName(name);
		return usercount;
	}

	@Override
	public Long findByEmail(String email) {
		Long emailcount = this.findByEmail(email);
		log.error("Find  by Email");
		return emailcount;
	}

	@Override
	public Long findByMobile(Long number) {
		Long mobilecount = this.findByMobile(number);
		return mobilecount;

	}

	@Override
	public boolean sendMail(String email) {
		String portNumber = "587";// 485,587,25
		String hostName = "smtp.office365.com";
		String fromEmail = "gagansv.xworkz@gmail.com";
		String password = "Gagan@5144";
		String to = email;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.startls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocal", "smtp");

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
			message.setText("Thanks for registration");
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

}
