package com.readFile.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferiseReader = null;
        String path = "C:/Users/zéro/Downloads/testdev-PHP-Java.txt";//A file to read (you can try your file)
        String dataLine;
        boolean eof = false;
        String[] myWords = null;
        
        try {
			bufferiseReader = new BufferedReader(new FileReader(path));
			while (eof != true) {
				dataLine = bufferiseReader.readLine();
				if (dataLine != null) {
					myWords = dataLine.split(" ");
				
				} else {
					eof = true;
				}
				for(String word : myWords){
					System.out.println(word);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
	}

}
