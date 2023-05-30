package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.Dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;

	// http://localhost:8080/createLead
	@RequestMapping("/createLead")
	public String viewCreateLead() {
		return "create_registration";
	}

	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead) {
		leadService.saveLead(lead);
		return "create_registration";
	}

//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") long mobile) {
//		Lead l = new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		return "create_registration";
//	}
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadDto leadDto, ModelMap modelMap) {
//		Lead l = new Lead();
//		l.setFirstName(leadDto.getFirstName());
//		l.setLastName(leadDto.getLastName());
//		l.setEmail(leadDto.getEmail());
//		l.setMobile(leadDto.getMobile());
//		leadService.saveLead(l);
//
//		modelMap.addAttribute("msg", "Saved Successfully");
//
//		return "create_registration";
//	}

	@RequestMapping("/listLead")
	public String getAllLead(Model model) {
		List<Lead> leads = leadService.findAllLead();
		model.addAttribute("leads", leads);
		return "list_lead";
	}

	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, Model model) {
		leadService.deleteLeadById(id);
		List<Lead> leads = leadService.findAllLead();
		model.addAttribute("leads", leads);
		return "list_lead";

	}

	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";

	}

	@RequestMapping("/updateLead")
	public String updateOneLead(@ModelAttribute("lead") Lead lead,Model model) {
		leadService.saveLead(lead);
		
		List<Lead> leads = leadService.findAllLead();
		model.addAttribute("leads", leads);
		return "list_lead";
	}

}
