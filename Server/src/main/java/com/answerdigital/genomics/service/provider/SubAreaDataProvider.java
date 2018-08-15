package com.answerdigital.genomics.service.provider;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.answerdigital.genomics.repository.RoutingRepository;
import com.answerdigital.genomics.util.StringUtils;

@Component
public class SubAreaDataProvider implements DataProvider {

	@Autowired
	private RoutingRepository repository;
	
	@Override
	public Collection<String> getData() {
		return StringUtils.splitCamelCases(repository.findDistinctSubAreaCodes());
	}

	@Override
	public String getName() {
		return "subAreaList";
	}
	
	public Collection<String> getMatchingTrustNames(String partialName) {
		return repository.findMatchingTrustNames(partialName);
	}

}
