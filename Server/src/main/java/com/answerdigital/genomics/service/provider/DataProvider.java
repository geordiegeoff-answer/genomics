package com.answerdigital.genomics.service.provider;

import java.util.Collection;

public interface DataProvider {

	Collection<String> getData();
	
	String getName();
}
