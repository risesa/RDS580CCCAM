package com.AngelBarreraSanchez.ccam.scrapper.impl;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.scrapper.FreeClinesScrapper;

/**
 * Implementation of FreeClinesScrapper
 * Get a Cline from http://free-cccam.tk/FC-003.43e/gen/index.php
 * @author Angel Barrera Sanchez
 */
public class Mycccam24 implements FreeClinesScrapper {
	private String BASE_URL = "http://www.mycccam24.com/5sv2016.php";
	private String default_hops;
	
	private Mycccam24(){}
	
	/**
	 * @param default_hops
	 */
	public Mycccam24(String default_hops) {
		this.default_hops = default_hops;
	}
	
	public static void main(String[] args) {
		Mycccam24 c = new Mycccam24();
		c.getLines();
	}
	
	/**
	 * Implementation method
	 */
	public Set<CCCAMEntity> getLines() {
		Set<CCCAMEntity> clines = new HashSet<CCCAMEntity>();
		try {
			Response res = Jsoup.connect(BASE_URL).followRedirects(true)
				.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0")
				.referrer("http://www.sasontnwc.net/aMhQ")
				.cookie("PHPSESSID", "m512ik0j388l3pdmfeasjgu3e2")
				.method(Method.GET)
				.execute();	
			final String linesweb = res.body();
			System.out.println();
			String lineSearch1 = "Your Free CCcam line is :<br> <FONT COLOR=\"#75D246\"> C: ";
			String lineSearch2 = "</FONT><br> <p> and it will  expire";
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