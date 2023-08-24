package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A3_1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] iarr = new int[x];

		for(int i = 0; i < x ; i++) {
			String s = br.readLine();
			String[] str = s.split(" ");  // 자른 String 배열. 
			for(int j = 0; j < str.length ; j++) {
				iarr[j] = Integer.parseInt(str[j]);
				sum += iarr[j];
			}
		}
		System.out.println(sum);
	}

}
//5
//5 50 50 70 80 100
//7 100 95 90 80 70 60 50
//3 70 90 80
//3 70 90 81
//9 100 99 98 97 96 95 94 93 91