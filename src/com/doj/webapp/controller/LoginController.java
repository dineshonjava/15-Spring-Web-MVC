/**
 * 
 */
package com.doj.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.doj.webapp.model.User;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class LoginController {
	
	//@RequestMapping(value="/login", method=RequestMethod.GET)
	@GetMapping(value="/login")//as of spring 4.3
	public String login() {
		return "login" ;
	}
	
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	@PostMapping(value="/login")
	public String doLogin(
			@RequestParam String username, 
			@RequestParam String password, ModelMap model) {
		if("XYZ".equals(username) && "123".equals(password)){
			model.put("user", username);
			return "success";
		}
		model.put("message", "Invalid Credential!!!");
		return "login" ;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() {
		return "register" ;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(User user, ModelMap model) {
		model.put("employee", user);
		return "register" ;
	}
	
	/*@RequestMapping("/login/{user}")
	public String login(
			@PathVariable(name="user") String username, 
			@RequestParam(required=false, defaultValue="123") String password, ModelMap model) {
		if("XYZ".equals(username) && "123".equals(password)){
			model.put("user", username);
			return "success";
		}
		model.put("message", "Invalid Credential!!!");
		return "login" ;
	}*/
}
