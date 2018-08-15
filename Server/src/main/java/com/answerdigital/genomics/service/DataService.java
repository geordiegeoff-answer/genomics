package com.answerdigital.genomics.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.answerdigital.genomics.dto.GeolocationData;
import com.answerdigital.genomics.dto.GeolocationRoutingData;
import com.answerdigital.genomics.dto.SearchDTO;
import com.answerdigital.genomics.repository.GeolocationRepository;
import com.answerdigital.genomics.repository.RoutingRepository;
import com.answerdigital.genomics.service.provider.DataProvider;

@Service
public class DataService {
	
	@Autowired
	private Collection<DataProvider> dataProviders;

	@Autowired
	private GeolocationRepository repository;
	
	@Autowired
	private RoutingRepository routingRepository;
	
	public List<GeolocationData> getLabs() {
		return repository.findLabs();
	}
	
	public List<GeolocationRoutingData> search(SearchDTO searchDTO) {
		return repository.search(searchDTO.getSubArea(), searchDTO.getLabOds(), 
				searchDTO.getTestType(), searchDTO.getTrustName());
	}
	
	public Collection<String> getMatchingTrustNames(String partialName) {
		return routingRepository.findMatchingTrustNames(partialName);
	}
	
	public Map<String, Collection<String>> getProvidedData() {
		Map<String, Collection<String>> providedData = new HashMap<>();
		
		dataProviders.stream().forEach(dataProvider -> {
			providedData.put(dataProvider.getName(), dataProvider.getData());
		});
		
		return providedData;
	}
}
