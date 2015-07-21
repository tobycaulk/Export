package com.opi.export;

import java.util.LinkedHashMap;

import com.badlogic.gdx.files.FileHandle;

public class FileParser {
	
	public static LinkedHashMap<String, String> load(FileHandle path) {
		String fileContents = path.readString().replace("\r\n", "");
		String[] valuePairs = fileContents.split("\\^");
		
		LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
		
		for(String s : valuePairs) {
			String[] pair = s.split("=");
			valueMap.put(pair[0], pair[1]);
		}

		return valueMap;
	}
}
