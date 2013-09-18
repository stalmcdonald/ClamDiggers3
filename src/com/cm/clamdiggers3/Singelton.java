package com.cm.clamdiggers3;

public class Singelton {
	private static Singelton instance = null;
	protected Singelton(){
		
	}
	public static Singelton getInstance(){
		if(instance == null){
			instance = new Singelton();
		}
		return instance;
		
	}

	public static void method1(){
		
	}
	
	public static boolean method2 (String message) {
		return false;
	}
}
