package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main23 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		int holenum = Integer.parseInt(stn.nextToken());
		int result = Integer.parseInt(stn.nextToken());
		int[] arr = new int[holenum];
		int[] holearr = new int[result-holenum];

		stn = new StringTokenizer(br.readLine());
		for(int i = 0; i<holenum; i++) {
			arr[i] = Integer.parseInt(stn.nextToken());
		}
		for(int i = 0; i<result-holenum; i++) {
			holearr[i] = Integer.parseInt(stn.nextToken());
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(holearr));
		
		Arrays.sort(holearr);
		Arrays.asList(holearr); 
		System.out.println(holearr);
		
//		int cnt = 0;
//		for(int i=0; i<holearr.length; i++) {
//			
//			if(holearr.contains) {
//				
//			}
//		}
	}
	
	
	
}
