package com.answerdigital.genomics.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringUtils {

	public static String splitCamelCase(String string) {
		return string.replaceAll(String.format("%s|%s|%s",
	         "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])"), " ")
				.replaceAll(" _ ", "_");
	}
	
	public static Collection<String> splitCamelCases(Collection<String> collection) {
		List<String> splitCamelCases = new ArrayList<>();
		
		collection.stream().forEach(string -> {
			splitCamelCases.add(splitCamelCase(string));
		});
		
		return splitCamelCases;
	}
}
