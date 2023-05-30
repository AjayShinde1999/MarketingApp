package com.marketingapp.service;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead);

	public List<Lead> findAllLead();

	public void deleteLeadById(long id);

	public Lead findLeadById(long id);


}
