package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		
//		 int a = Integer.parseInt(br.readLine(  // 두줄
		 
		 String a = br.readLine();
		 
//		 int x = (a.charAt(0) -'0'); // 문자열로 만듦. 
//		 int y = (a.charAt(1) - '0');
		 int x = Integer.parseInt(a.charAt(0) + ""); // 문자열로 만듦. 
		 int y =  Integer.parseInt(a.charAt(1) + "");
		 int sum = x+y;
		 int count = 0;
		 
		 while(true) {
			 int z = x + y;  
			 x = y;  
			 y = z %10; 
			 count ++;
			 if (x+y == sum) {
				 break;
			 }
		 }
		 System.out.println(count);
		 
	}

}
