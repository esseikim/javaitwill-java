package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int[] arr = new int[input];

		for(int i = 0; i<input; i++) {
			
		}

		int max =0;
		for(int i = 0; i<input; i++){

			for(int j = i+1; j < input ; j++) {

				for(int k= j+1 ;  k< input ; k++) {

					int x = arr[i] + arr[j] + arr[k];   

					if(m>=x && x > max) {
						max = x;
					}
				}
			}
		}
		System.out.println(max);
	}
}
