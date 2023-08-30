package pt.bitclinic.javasbmvc01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import pt.bitclinic.javasbmvc01.entities.Customer;

@Controller
public class CustomerController {
	
	@GetMapping("/")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {		
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			
			return "customer-confirmation";			
		}
			
			
		
	}
		
}
