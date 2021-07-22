package com.mar.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mar.dojoninja.models.Dojo;
import com.mar.dojoninja.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}

	public List<Dojo> allDojo() {
		return dojoRepository.findAll();
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
