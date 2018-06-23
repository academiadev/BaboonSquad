package br.com.academiadev.reembolsoazul.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Util {

	public static <T> List<T> toList(Iterable<T> it) {
		List<T> list = new ArrayList<>();
		it.forEach(list::add);
		return list;
	}
	
	public static String dateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(formatter);
	}
	
	public static LocalDate stringToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(dateString, formatter);
	}
}
