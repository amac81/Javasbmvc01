package pt.bitclinic.javasbmvc01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import pt.bitclinic.javasbmvc01.entities.Customer;

@Controller
public class CustomerController {

	List<Customer> customers = new ArrayList<>();
	
		
	// Pre-process all web requests coming into our Controller
	// Pre-process every String form data; remove leading and trailing white space
	// if String only has white space... "trim" it to null
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		// removes whitespaces - leading and trailing
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/customers")
	public String showForm(Model theModel) {
		theModel.addAttribute("customers", customers);
		Customer customer = new Customer();
		customer.setFreePasses(null);
		customer.setId(0L);
		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/customers")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		if (!theBindingResult.hasErrors()) {
			theCustomer.setId(0L);
			customers.add(theCustomer);
			return "redirect:/customers";
		}
		else 
		{
			return "customer-form";
		}
				
	}
}
