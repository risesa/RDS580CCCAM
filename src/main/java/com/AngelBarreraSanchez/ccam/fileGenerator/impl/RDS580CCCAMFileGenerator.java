package com.AngelBarreraSanchez.ccam.fileGenerator.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.fileGenerator.CCCAMFileGenerator;
import com.AngelBarreraSanchez.ccam.util.DateUtils;

/**
 * FileGenerator Implementation
 * @author Angel Barrera Sanchez
 */
public class RDS580CCCAMFileGenerator implements CCCAMFileGenerator {
	
	/** 
	 * Generates a file with the clines in the path passed by params in the Fonestar RDS580 format
	 * @param clines 
	 * @param outputPath
	 */ 
	public void generateFile(final Set<CCCAMEntity> clines, String path) {
		String fecha = DateUtils.getFormattedActualDate("ddMMyyyy");
		try {
			FileWriter fw = new FileWriter(path);
			fw.write("<NETDBS_TXT_VER_1>");
			fw.write(System.lineSeparator());
			fw.write(System.lineSeparator());
			fw.write("####### Plantilla CCCcam "+fecha+" #######");
			fw.write(System.lineSeparator());
			fw.write("#.................Domain/IP................Port....Username... Password....Hops");
			fw.write(System.lineSeparator());
			for(CCCAMEntity cline : clines){
				fw.write("CCCAM: { ");
				fw.write(cline.getHost());
				fw.write(" } { ");
				fw.write(cline.getPort());
				fw.write(" } { ");
				fw.write(cline.getUser());
				fw.write(" } { ");
				fw.write(cline.getPass());
				fw.write(" } { ");
				fw.write(cline.getHops());
				fw.write(" }");
				fw.write(System.lineSeparator());
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}