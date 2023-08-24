package edu.java.contact02;




public enum Menu1 {
	OFF, INSERT, SELECTAll, SELECTCONTACT, UPDATE, DELETE, UNKNOWN;

	public static Menu1 getValue(int n) {
		Menu1[] mu = Menu1.values();

		if(0 <= n && n<mu.length) {
			return	mu[n]; 
		} else {
			return mu[mu.length - 1]; 
		}
	}
}



