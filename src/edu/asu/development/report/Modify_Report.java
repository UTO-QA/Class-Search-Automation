package edu.asu.development.report;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Modify_Report {
	public File create_new_file(){
		File file=new File("C:/Users/bharadwaj/git/Class-Search-Automation/target/formatter1.js");
		return file;
	}
	public void modify_new_file() throws IOException{
		File inputFile =new File("C:/Users/bharadwaj/git/Class-Search-Automation/target/formatter.js");
		File tempFile = create_new_file();

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writter = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = "errorNode.text(e);";
		String currentLine;
		while(reader.readLine()!=null){
			currentLine=reader.readLine();
			if(currentLine.equals(lineToRemove)){
				writter.write("errorNode.text(\" \");");
			}
			else{
				writter.write(currentLine);
				writter.write("/n");
    	       
			}
		}
		 writter.close();
		 reader.close();
		 File oldFile = new File("C:/Users/bharadwaj/git/Class-Search-Automation/target/formatter.js");
	      oldFile.delete();

	      // And rename tmp file's name to old file name
	      File newFile = new File("C:/Users/bharadwaj/git/Class-Search-Automation/target/formatter1.js");
	      newFile.renameTo(oldFile);

			}
	
	public  void main(String[]args){
		Modify_Report report=new Modify_Report();
		report.create_new_file();
		try {
			report.modify_new_file();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
