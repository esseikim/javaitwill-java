package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main21 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] a = new int[num];
		
		StringTokenizer stn1 = new StringTokenizer(br.readLine());

		for(int i = 0; i < num; i ++) {
			a[i] = Integer.parseInt(stn1.nextToken());
		}
		
		Arrays.sort(a);
		int sum = 0;
		
 		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				sum +=  a[j];
			}
		}
		System.out.println(sum);
	}
}