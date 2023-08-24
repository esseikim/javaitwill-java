package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st1.nextToken());
		int cnt = Integer.parseInt(st1.nextToken());
		int[] arr = new int[num];
		
		for(int i = 0; i< cnt; i ++) {
			st1 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			int z = Integer.parseInt(st1.nextToken());
			
	
			arr[x-1] = z;
			arr[y-x] = z;
		}
		
		for(int x : arr) {
			System.out.print(x + " ");
		}
	}
}
