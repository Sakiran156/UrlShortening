package in.careerit.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.web.servlet.view.RedirectView;

import in.careerit.main.entities.Users;
import in.careerit.main.exception.ShortCodeNotFoundException;
import in.careerit.main.services.UrlShorteningService;

@Controller
public class UrlController {

    
	
	@Autowired
	private UrlShorteningService service;
	
	@GetMapping("/index")
	public String getIndex(Model model, @SessionAttribute(value = "loggedInUser",required=false) Users user) {
		if(user== null) {
			return "redirect:/login";
		}
		model.addAttribute("email", user.getEmail());
		return "index";
	}
	
	@PostMapping("/shorten-form")
	
	public String handleForm(@RequestParam("url") String url,Model model) {
		String shortcode=service.ShorternUrl(url);
		String shortUrl="http://localhost:8080/"+shortcode;
		model.addAttribute("shortUrl",shortUrl);
		return "index";
	}

	

	@GetMapping("/{shortcode}")
	public RedirectView redirectToOriginal(@PathVariable String shortcode) {
		 return service.getOriginalUrl(shortcode).map(RedirectView::new)
				 .orElseThrow(()->new ShortCodeNotFoundException("short code not found"));
	}

}
