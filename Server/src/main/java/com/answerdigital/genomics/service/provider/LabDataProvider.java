package com.answerdigital.genomics.service.provider;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.answerdigital.genomics.repository.LabRepository;

@Component
public class LabDataProvider implements DataProvider {

	@Autowired
	private LabRepository repository;
	
	@Override
	public Collection<String> getData() {
		return repository.findAllOdsCodes();
	}

	@Override
	public String getName() {
		return "labOdsCodeList";
	}
}
