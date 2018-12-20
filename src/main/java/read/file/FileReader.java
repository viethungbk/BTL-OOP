package read.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Đọc file lưu thông tin các thực thể
 * và trả về ArrayList[String] các thực thể và các thông tin liên quan của thực thể.
 */
public class FileReader{
	public ArrayList<String> readData(String filePath) {
		ArrayList<String> data = new ArrayList<String>();
		File file = new File(filePath);
		String line = "";
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				data.add(line);
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
}
