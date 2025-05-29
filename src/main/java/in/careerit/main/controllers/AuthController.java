package in.careerit.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import in.careerit.main.entities.Users;
import in.careerit.main.repositories.UserRepository;

@Controller
@SessionAttributes("loggedInUser")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}	
	
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") Users user,Model model) {
		Users dbuser=userRepository.findByEmail(user.getEmail()).orElse(null);
		if(dbuser != null && dbuser.getPassword().equals(user.getPassword())) {
			model.addAttribute("loggedInUser", dbuser);
			return "redirect:/index";
		}else {
			model.addAttribute("error", "Invalid credentials");
			return "login";
		}
	}
	
	

	
	@PostMapping("/register")
	public String register(@ModelAttribute("user")Users user,Model model) {
		userRepository.save(user);
		model.addAttribute("message", "registration done successfully, please login.");
		return "login";
	}

}
