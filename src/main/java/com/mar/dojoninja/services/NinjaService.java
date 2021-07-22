package com.mar.dojoninja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mar.dojoninja.models.Ninja;
import com.mar.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public List<Ninja> allNinja() {
		return ninjaRepository.findAll();
	}

	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}

}
