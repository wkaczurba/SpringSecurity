package com.some.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("/sec")
	public String securedWebpage() {
		return "sec";
	}

	@RequestMapping("/insec")
	public String insecuredWebPage() {
		return "insec";
	}
	
	@RequestMapping("/admin")
	// This should be made secure.
	public String adminPage() {
		return "admin";
	}
}
