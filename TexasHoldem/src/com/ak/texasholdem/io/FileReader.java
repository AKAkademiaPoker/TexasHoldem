package com.ak.texasholdem.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {
	
	private String path;

	public FileReader(String path) {
		super();
		this.path = path;
	}
	
	public void printRules() {
		Path path2 = Path.of(path);
		try (Stream<String> lines = Files.lines(path2)){
			lines.forEach(line -> System.out.println(line));
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
