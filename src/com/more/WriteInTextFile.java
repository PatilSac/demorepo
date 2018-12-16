package com.more;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInTextFile {

	public static void main(String[] args) {
		// Open File or Create File at project level
		File file = new File(".//TextFile.txt");
		// to write something in file create object of FileOutputStream
		FileOutputStream output;
		FileWriter data;
		try {
			//For writing on file
			output = new FileOutputStream(file);
			
			//Create object of File writer
			data = new FileWriter(file);

			//Writting in text file
			data.write("Harsh Vegada \nAtmiya \nRajkot");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
