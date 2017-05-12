package com.office.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.office.common.dto.UserDTO;
import com.office.common.session.SessionAttributeNames;
import com.office.user.form.UserForm;

@RestController
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/rest/main/user/getUser.do",method=RequestMethod.POST)
	public UserForm getUser(@ModelAttribute UserForm form,HttpServletResponse response){
		form.setSuccess();
		return form;
	}
	@RequestMapping(value="/rest/main/user/login.dox",method=RequestMethod.POST)
	public UserForm login(HttpServletRequest request,@ModelAttribute UserForm form){
		try {
			UserDTO userDTO=new UserDTO();
			userDTO.setIdUser(form.getIdUser());
			userDTO.setUserName(form.getUserName());
			
			request.getSession().setAttribute(SessionAttributeNames.CURRENT_USER, userDTO);
		} catch (Exception e) {
			logger.trace(e.getMessage());
			form.setError();
		}
		return form;
	}

}
