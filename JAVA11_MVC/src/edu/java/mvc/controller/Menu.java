package edu.java.mvc.controller;



public enum Menu {

QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;

	
	public static Menu getValue(int n) { 
		Menu[] menu = values();   
		
		if (n >= 0 && n < menu.length) {
			return menu[n];  
		}else {
			return menu[menu.length-1];
		}
	}
}
