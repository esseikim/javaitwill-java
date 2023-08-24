package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A9 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		//	StringTokenizer st = new StringTokenizer(br.readLine()); 두번 입력 받음. 

		TreeMap<String, String> check = new TreeMap<>();


		for(int i = 0; i < x ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());  // 어차피 한줄
			check.put(st.nextToken(), st.nextToken()); 
		}

		Set<String> s = check.descendingKeySet();
		for (String i : s) {
			if(check.containsValue("enter")) {
				System.out.println();
			}
		}
	}
}
//4
//Baha enter
//Askar enter
//Baha leave
//Artem enter
//Askar
//Artem