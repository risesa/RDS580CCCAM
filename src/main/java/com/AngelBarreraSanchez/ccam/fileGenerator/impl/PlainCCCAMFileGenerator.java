package com.AngelBarreraSanchez.ccam.fileGenerator.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.fileGenerator.CCCAMFileGenerator;

/**
 * FileGenerator Implementation
 * @author Angel Barrera Sanchez
 */
public class PlainCCCAMFileGenerator implements CCCAMFileGenerator {
	
	/** 
	 * Generates a file with the clines in the path passed by params in the plain cccam format
	 * @param clines 
	 * @param outputPath
	 */ 
	public void generateFile(final List<CCCAMEntity> clines, String path) {
		try {
			FileWriter fw = new FileWriter(path);
			for(CCCAMEntity cline : clines){
				fw.write("C: ");
				fw.write(cline.getHost());
				fw.write(" ");
				fw.write(cline.getPort());
				fw.write(" ");
				fw.write(cline.getUser());
				fw.write(" ");
				fw.write(cline.getPass());
				fw.write(System.lineSeparator());
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}