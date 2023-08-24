package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Set;

public class B {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		String[] str = new String[x];

		for(int i =0; i < x; i++ ) { 
			str[i] = br.readLine();
		}

		TreeMap<String, Integer> sell = new TreeMap<>();
		for(String s : str) {
			int count = 0;
			if(sell.get(s) == null) {
				sell.put(s, 1);
			}else {
				sell.put(s, count+1);
			}
		}
        
		Set<String> key = sell.keySet();
		int max = 0;
		String bestSeller = "";
		
		for (String x1 : key) {
			if (sell.get(x1) > max) {
				max = sell.get(x1);
				bestSeller = x1;
			} 
		}
		System.out.println(bestSeller);
	}
}