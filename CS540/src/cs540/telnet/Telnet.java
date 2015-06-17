package cs540.telnet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Telnet {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fin = new FileReader("first.txt");
		Scanner src = new Scanner(fin);
		List<String> lines = new ArrayList<String> ();
		
		while(src.hasNextLine()) {
			lines.add(src.nextLine());
		}
		
		for (int i = 0; i < 2 ; i++ ) {
			System.out.println(lines.get(i));
			
		}
	}
}