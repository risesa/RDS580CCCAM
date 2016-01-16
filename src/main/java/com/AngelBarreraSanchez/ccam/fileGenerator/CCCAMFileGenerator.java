package com.AngelBarreraSanchez.ccam.fileGenerator;


import java.util.List;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;

/**
 * FileGenerator Interface
 * @author Angel Barrera Sanchez
 */
public interface CCCAMFileGenerator {

	/** 
	 * Generates a file with the clines in the path passed by params 
	 * @param clines 
	 * @param outputPath
	 */ 
	void generateFile(final List<CCCAMEntity> clines, final String outputPath);
	
}