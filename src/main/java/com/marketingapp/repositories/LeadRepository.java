package com.marketingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
