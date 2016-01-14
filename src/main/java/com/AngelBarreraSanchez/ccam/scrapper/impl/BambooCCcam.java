package com.AngelBarreraSanchez.ccam.scrapper.impl;


import java.util.HashSet;
import java.util.Set;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.helper.StringUtil;
import org.jsoup.Jsoup;

import com.AngelBarreraSanchez.ccam.CCCAMEntity;
import com.AngelBarreraSanchez.ccam.scrapper.FreeClinesScrapper;

/**
 * Implementation of FreeClinesScrapper
 * Get a Cline from http://151.80.128.35/verif.php
 * @author Angel Barrera Sanchez
 */
public class BambooCCcam implements FreeClinesScrapper {
	private String BASE_URL = "http://151.80.128.35/verif.php";
	private String default_hops;
	
	private BambooCCcam(){}
	
	/**
	 * @param default_hops
	 */
	public BambooCCcam(String default_hops) {
		this.default_hops = default_hops;
	}
	
	public static void main(String[] args) {
		BambooCCcam b = new BambooCCcam();
		b.getLines();
	}
	
	/**
	 * Implementation method
	 */
	public Set<CCCAMEntity> getLines() {
		Set<CCCAMEntity> clines = new HashSet<CCCAMEntity>();
		try {
			
			Response res = Jsoup.connect("http://151.80.128.35/js/contact_me.js")
				.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0")
				.referrer(BASE_URL)
				.method(Method.GET)
				.ignoreContentType(true)
				.execute();	
				
			final String linesweb = res.body();
			final String lineSearch1 = "C: ";
			final String lineSearch2 = " \" + firstName";
			String line = linesweb.substring(linesweb.indexOf(lineSearch1) +  lineSearch1.length(), linesweb.indexOf(lineSearch2,linesweb.indexOf(lineSearch1) +  lineSearch1.length()));
			line = line.trim();
			final String[] tokens = line.split(" ");
			final String host = tokens[0].trim();
			final String port = tokens[1].trim();
			
			
			String username = System.currentTimeMillis()+"";
			//LAST 6 numbers, pseudo random
			username = username.substring(username.length()-6);
			final String pass = "RDS580";
			
			res = Jsoup.connect(BASE_URL)
				.data("user", username)
				.data("pass",pass)
				.data("name", "")
				.data("email","")
				.data("phone","")
				.data("message", "")
				.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0")
				.referrer(BASE_URL)
				.method(Method.POST)
				.execute();	
			
			//IN JS SAYS THAT IF IT WORKS, IT MOUNT A CLINE WITH THE HOST AND PORT FROM JSON AND USER
			//AND PASS OF USER INPUT
			if(res.statusCode()==200){
				clines.add(new CCCAMEntity(host, port, username, pass, default_hops));
			}
		} catch (Exception e) {
			System.out.println("Error en " + BASE_URL);
			System.out.println("Error: " + e.getMessage());
		}
		return clines;
	}
}
