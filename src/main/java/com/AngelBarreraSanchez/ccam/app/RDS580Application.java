package com.AngelBarreraSanchez.ccam.app;

import java.util.HashSet;
import java.util.Set;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.fileGenerator.CCCAMFileGenerator;
import com.AngelBarreraSanchez.ccam.fileGenerator.impl.RDS580CCCAMFileGenerator;
import com.AngelBarreraSanchez.ccam.scrapper.FreeClinesScrapper;
import com.AngelBarreraSanchez.ccam.scrapper.impl.AllCccam;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Maniaforu;

/**
 * The main class. 
 * @author Angel Barrera Sanchez
 */
public class RDS580Application {
	
	private final static String DEFAULT_HOPES = "1";
	
	/**
	 * Main function of the program
	 * @param args -> args[0] must be the output path
	 */
	public static void main(String[] args) {
		if(args.length!=1){
			System.err.println("Only need 1 parameter. The output path.");
			System.exit(-1);
		}
		Set<CCCAMEntity> clines = new HashSet<>();
		
		
		FreeClinesScrapper maniaforu = new Maniaforu(DEFAULT_HOPES);
		clines.addAll(maniaforu.getLines());
		
		FreeClinesScrapper allCccam = new AllCccam(DEFAULT_HOPES);
		clines.addAll(allCccam.getLines());
		
		
		CCCAMFileGenerator fileGen = new RDS580CCCAMFileGenerator();
		fileGen.generateFile(clines, args[0]);
		System.exit(0);
	}
}