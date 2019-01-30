package doctorsoffice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriting {
	private boolean appendFile = false; // boolean to make this shit easier.
	private String path;
	
	public FileWriting(String path) {
		this.path = path;
	}
	
	public FileWriting(String path, boolean appendFile) {
		this.path = path;
		this.appendFile = appendFile;
		
	}
	
	public void writeToFile(String textLine) {
		System.out.println("Wrote to file CONFIRMED.");
	
	
		try {
				FileWriter  write = new FileWriter(path, appendFile); 
				PrintWriter print = new PrintWriter(write);
				
				print.printf(textLine);
				print.close();
	
		}

			catch(IOException e) {
				e.printStackTrace();
			}	
				
	}

	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

}
