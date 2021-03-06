package com.AngelBarreraSanchez.ccam.scrapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.scrapper.FreeClinesScrapper;

/**
 * Implementation of FreeClinesScrapper
 * Get a Cline from http://www.allcccam.com/serv1.php
 * @author Angel Barrera Sanchez
 */
public class AllCccam implements FreeClinesScrapper {
	
	private String BASE_URL = "http://www.allcccam.com/serv1.php";
	private String default_hops;

	private AllCccam() {
	}

	/**
	 * @param default_hops
	 */
	public AllCccam(String default_hops) {
		this.default_hops = default_hops;
	}
	
	/**
	 * Implementation method
	 */
	public List<CCCAMEntity> getLines() {
		List<CCCAMEntity> clines = new ArrayList<CCCAMEntity>();
		try {
			Response res = Jsoup.connect(BASE_URL)
				.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0")
				.referrer("http://www.eafyfsuh.net/CxaIF")
				.cookie("PHPSESSID", "o98hdpkasu02tr03a0lsq48qn1")
				.cookie("TawkConnectionTime", "0")
				.cookie("__tawkuuid", "e||allcccam.com||dX5vawb1XExR4Beu3Ed1gsKsP9IjFQJVdsu5wLqVBYKB3XcqA8BMpsyVz4ssCpSr||2")
				.cookie("Tawk_55ce514ebad2fd7a51426ae5", "vs15.tawk.to:443||0\"")
				.method(Method.GET)
				.execute();	
			final String linesweb = res.body();
			String lineSearch1 = "<FONT COLOR=\"#00FF0D\"> C: ";
			String lineSearch2 = "</FONT>";
			String line = linesweb.substring(linesweb.indexOf(lineSearch1) +  lineSearch1.length(), linesweb.indexOf(lineSearch2,linesweb.indexOf(lineSearch1) +  lineSearch1.length()));
			line = line.trim();
			final String[] tokens = line.split(" ");
			final String host = tokens[0].trim();
			final String port = tokens[1].trim();
			final String user = tokens[2].trim();
			final String pass = tokens[3].trim();
			clines.add(new CCCAMEntity(host, port, user, pass, default_hops));
		} catch (Exception e) {
			System.out.println("Error en " + BASE_URL);
			System.out.println("Error: " + e.getMessage());
		}
		return clines;
	}
}