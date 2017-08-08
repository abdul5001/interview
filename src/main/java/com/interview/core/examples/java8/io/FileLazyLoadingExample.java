package com.interview.core.examples.java8.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLazyLoadingExample {

	public static void main(String[] args) {
		
		try {
			Files.list(Paths.get("C:\\AAWorkstation\\Software"))
			.filter(Files::isRegularFile) //ignore directories
			.forEach(System.out::println);
			
			
			//note that if we’re working with a large directory, then using DirectoryStream actually make code faster
			System.err.println("==========================");
			Files.newDirectoryStream(Paths.get("C:\\AAWorkstation\\Software"))
				.forEach(System.out::println);
			
			
			//List only files with Files.newDirectoryStream()
			System.err.println("==========================");
			Files.newDirectoryStream(Paths.get("C:\\AAWorkstation\\Software"), path -> path.toFile().isFile())
				.forEach(System.out::println);
			
			//List all hidden files
			File[] files = new File("C:\\AAWorkstation\\Software").listFiles(file -> file.isHidden());
			//or
			File[] files2 = new File("C:\\AAWorkstation\\Software").listFiles(File :: isHidden);
			
			
			//READ LINES IN A FILE
			//read file into stream, try-with-resources
			System.err.println("==========================");
			try (Stream<String> stream = Files.lines(Paths.get("C:\\AAWorkstation\\Software\\test.txt"))) {
				stream.forEach(System.out::println);
			} catch (IOException e) {
				e.printStackTrace();
			}

						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
