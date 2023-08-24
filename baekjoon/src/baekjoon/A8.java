package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class A8 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		String[] str = new String[x];

		for(int i =0; i < x; i++ ) { 
			//			 sell.put(br.readLine(), i);
			str[i] = br.readLine();
		}

		HashMap<String, Integer> sell = new HashMap<>();
		for(String s : str) {
			int count = 0;
			if(sell.get(s) == null) {
				sell.put(s, 1);
			}else {
				sell.put(s, count+1);
			}
		}

//		int max = 0;
//		for(int i = 0; i < sell.size(); i++) {
//			if (max < sell.get(str[i])) {
//				max = sell.get(str[i]);
//			}
//		}
		
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



//5
//top
//top
//top
//top
//kimtop
//top