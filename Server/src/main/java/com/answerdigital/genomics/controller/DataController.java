package com.answerdigital.genomics.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answerdigital.genomics.service.DataService;

@Controller
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@GetMapping(path="/all")
	@ResponseBody
	public Map<String, Collection<String>> getAll() throws Exception {
		return dataService.getProvidedData();
	}
	
	@GetMapping(path="/trust/{partialName}")
	@ResponseBody
	public Collection<String> getMatchingTrustNames(
			@PathVariable("partialName") String partialName) throws Exception {
		
		return dataService.getMatchingTrustNames(partialName);
	}
}
