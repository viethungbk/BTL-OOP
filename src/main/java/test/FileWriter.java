package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import config.FileConfig;

public class FileWriter extends FileConfig {

	public static void main(String[] args) {
		String filePath = FileConfig.FILE_TIME_DESCRIPTION;
		File file = new File(filePath);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			for (int i = 1; i <= 500; i++) {
				writer.println("Time_Description_" + i);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			writer.close();
		}
		

	}

}
