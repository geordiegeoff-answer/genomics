package com.answerdigital.genomics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.answerdigital.genomics.dto.GeolocationData;
import com.answerdigital.genomics.dto.GeolocationRoutingData;
import com.answerdigital.genomics.dto.SearchDTO;
import com.answerdigital.genomics.service.DataService;

@Controller
@RequestMapping("/geolocation")
public class GeolocationDataController {

	@Autowired
	private DataService dataService;
	
	@GetMapping(path="/labs")
	@ResponseBody
	public List<GeolocationData> getLabs() throws Exception {
		return dataService.getLabs();
	}
	
	@PostMapping(path="/search")
	@ResponseBody
	public List<GeolocationRoutingData> search(@RequestBody() SearchDTO trustName) throws Exception {
		return dataService.search(trustName);
	}
}
