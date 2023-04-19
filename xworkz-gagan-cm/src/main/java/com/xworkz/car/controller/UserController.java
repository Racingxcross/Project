package com.xworkz.car.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.car.dto.userDTO;
import com.xworkz.car.service.CarService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class UserController {

	@Autowired
	private CarService carService;

	public UserController() {
		log.info("" + this.getClass().getSimpleName());
	}

	@PostMapping("/Save")
	public String userInfo(userDTO dto, Model model) {
		Set<ConstraintViolation<userDTO>> violations = this.carService.validateandsave(dto);

		if (violations != null && violations.isEmpty() && dto != null) {
			model.addAttribute("message", "Registration sucessfull");
			log.info("Running in no violations condition ");
			log.info("" + dto);
			return "SignUp";
		}
		model.addAttribute("errors", violations);
		model.addAttribute("message", "Registration failed");
		model.addAttribute(dto);
		log.info("Running in  violations condition ");
		return "SignUp";

	}

	@PostMapping("/signin")
	public String userSignIn(String userName, String password, Model model, HttpServletRequest request) {
		log.info("Running in userSignIn condition ");
		try {
			userDTO dto = this.carService.userSignIn(userName, password);
			log.info("Login count" + dto.getLoginCount());
			if (dto.getLoginCount() >= 3) {
				model.addAttribute("msg", "Account locked Reset password");
				log.info("Acount locked due to wrong password entering 3 times");
				return "SignIn";
			}
			if (dto != null) {

				if (dto.getResetPassword() == true) {
					log.info("Running in ResetPassword true condition");
					if (!dto.getPasswordChangedTime().isAfter(LocalTime.now())) {
						log.info("Running in time verifying condition");
						model.addAttribute("msgs", "Time out plz try again");
						return "SignIn";
					}
					model.addAttribute("userName", dto.getUserName());
					log.info("Running in reset condition");
					log.info("ResetPassword---" + dto.getResetPassword());
					log.info("Timer-----" + dto.getPasswordChangedTime().isBefore(LocalTime.now()));
					return "updatePassword";
				}
				System.currentTimeMillis();
				log.info("User Name and password is matched");
				// model.addAttribute("userID", udto.getUserId());//request scope
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userName", dto.getUserName());
				return "loginSuccess";
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		log.info("UserName OR Password is not matching");
		model.addAttribute("match", "userName OR Password is not matching");
		return "SignIn";

	}

	@PostMapping("/reset")
	public String resetPassword(String email, Model model) {
		userDTO dto = this.carService.resetPassword(email);
		if (dto.getResetPassword() == true) {
			model.addAttribute("msg", "Password reset sucessful plz login");
			return "resetPassword";
		}
		return "resetPassword";
	}

	@PostMapping("/passwordUpdate")
	public String updatePassword(String userName, String password, String confirmPassword) {
		this.carService.updatePassword(userName, password, confirmPassword);
		return "success";
	}

	@PostMapping("/upload")
	public String onUpload(@RequestParam("chitra") MultipartFile multipartFile, String userId, String email,
			Long mobile, Model model) throws IOException {
		log.info("multipartFile" + multipartFile);
		log.info(multipartFile.getOriginalFilename());
		log.info(multipartFile.getContentType());
		log.info("Size of file" + multipartFile.getSize());
		log.info("Size of bite" + multipartFile.getBytes());
		if (multipartFile.isEmpty()) {
			log.info("file not uploaded");
			model.addAttribute("error", "please select file");
			return "profileUpdate";
		}
		model.addAttribute("sucess", "image uploaded sucessfully");
		byte[] bytes = multipartFile.getBytes();
		Path path = Paths.get("D:\\highway\\" + userId + System.currentTimeMillis() + ".jpg");
		Files.write(path, bytes);
		String imageName = path.getFileName().toString();
		log.info("Image name--" + imageName);
		log.info("Image name in tostring--" + path.toString());
		log.info("Image file name--" + path.getFileName());
		this.carService.updateProfile(userId, email, mobile, imageName);
		return "profileUpdate";
	}

	@GetMapping("/download")
	public void onDownload(HttpServletResponse response, @RequestParam String fileName, userDTO user)
			throws IOException {
		Path path = Paths.get("D:\\\\" + user.getPicName());
		path.toFile();
		response.setContentType("image/jpeg");
		File file = new File("D:\\highway\\" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();

	}

}
