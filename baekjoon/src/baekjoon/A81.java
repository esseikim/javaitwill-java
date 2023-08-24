package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

public class A81 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, String> sell = new TreeMap<>();
		int count = 0;
		
		for(int i = 0; i < x ; i ++) {
			String s = br.readLine();
			if (sell.containsValue(s)) {
				sell.put(count +1, s);
				System.out.println(sell);
			}else{
				sell.put(1, s);
				System.out.println(sell);
			}
		}
		
		Set<Integer> ts = sell.descendingKeySet();
		for(Integer s : ts) {
			System.out.println(sell.get(s));
			break;
		
		}
	}

}


//5
//top
//top
//top
//top
//kimtop