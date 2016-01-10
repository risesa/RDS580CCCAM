package com.AngelBarreraSanchez.ccam.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Utility Class. Dates Utils
 * @author Angel Barrera Sanchez
 */
public class DateUtils {
	
	/**
	 * Gets actual date in the format passed by params
	 * @param pattern format
	 * @return the date formatted
	 */
	public static String getFormattedActualDate(final String pattern) {
		return DateTimeFormat.forPattern(pattern).print(new DateTime());
	}
}