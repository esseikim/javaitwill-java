package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main24 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List <Integer> arr = new ArrayList<>();
		String s = br.readLine();
		StringBuilder stringBuilder = new StringBuilder();

		String[] tokens = s.split("");
		for (int i = 0; i < tokens.length; i++) {
			arr.add(Integer.parseInt(tokens[i]));
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		if(arr.contains(0)) {

			for (int i = 0; i < arr.size(); i++){
				stringBuilder.append(arr.get(i));
			}
			
			int result = Integer.parseInt(stringBuilder.toString());
			if(result % 3 == 0) {
				System.out.println(stringBuilder);
			}else{
				System.out.println(-1);
			}
		}else{
			System.out.println(-1);
		}
	}
}
