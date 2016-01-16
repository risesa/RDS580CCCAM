package com.AngelBarreraSanchez.ccam.app;

import java.util.HashSet;
import java.util.Set;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.fileGenerator.CCCAMFileGenerator;
import com.AngelBarreraSanchez.ccam.fileGenerator.impl.RDS580CCCAMFileGenerator;
import com.AngelBarreraSanchez.ccam.scrapper.FreeClinesScrapper;
import com.AngelBarreraSanchez.ccam.scrapper.impl.AllCccam;
import com.AngelBarreraSanchez.ccam.scrapper.impl.BambooCCcam;
import com.AngelBarreraSanchez.ccam.scrapper.impl.CccamWorld;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Cccamgenerator;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Cgenerator;
import com.AngelBarreraSanchez.ccam.scrapper.impl.FC003;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Helala0;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Maniaforu;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Mycccam24;
import com.AngelBarreraSanchez.ccam.scrapper.impl.New0;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Sat2arab;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Shashatv;
import com.AngelBarreraSanchez.ccam.scrapper.impl.Zetita;

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
		
		//new0 and helala0 sometimes fails... TEST IT PLEASE
		FreeClinesScrapper new0 = new New0(DEFAULT_HOPES);
		clines.addAll(new0.getLines());
		FreeClinesScrapper helala0 = new Helala0(DEFAULT_HOPES);
		clines.addAll(helala0.getLines());
		
		//SEEMS NOT TO WORK. TEST IT PLEASE
		FreeClinesScrapper fc003 = new FC003(DEFAULT_HOPES);
		clines.addAll(fc003.getLines());
		
		FreeClinesScrapper cccamgenerator = new Cccamgenerator(DEFAULT_HOPES);
		clines.addAll(cccamgenerator.getLines());
		
		FreeClinesScrapper zetita = new Zetita(DEFAULT_HOPES);
		clines.addAll(zetita.getLines());
		
		FreeClinesScrapper mycccam24 = new Mycccam24(DEFAULT_HOPES);
		clines.addAll(mycccam24.getLines());
		
		//INI - SEEMS TO DONT WORK
		FreeClinesScrapper shashatv = new Shashatv(DEFAULT_HOPES);
		clines.addAll(shashatv.getLines());
		
		FreeClinesScrapper cccamWorld = new CccamWorld(DEFAULT_HOPES);
		clines.addAll(cccamWorld.getLines());
		
		FreeClinesScrapper cgenerator = new Cgenerator(DEFAULT_HOPES);
		clines.addAll(cgenerator.getLines());
		//END - SEEMS TO DONT WORK
		
		FreeClinesScrapper bambooCCcam = new BambooCCcam(DEFAULT_HOPES);
		clines.addAll(bambooCCcam.getLines());
		
		FreeClinesScrapper sat2arab = new Sat2arab(DEFAULT_HOPES);
		clines.addAll(sat2arab.getLines());
		
		CCCAMFileGenerator fileGen = new RDS580CCCAMFileGenerator();
		fileGen.generateFile(clines, args[0]);
		System.exit(0);
	}
}