package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A10 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = Integer.parseInt(br.readLine());

		for(int i = 0; i < cnt ; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		sb.append(x + y + "\n");
		}
		System.out.print(sb);
		
//		if ( m >= 45) {
//			m = m - 45;
//			if(h != 0) {
//		    h = h;
//			}else {
//			h = 23;
//			}
//		// 01 :46   01 01      
////		if (h != 0) {
////		h = h -1; 
////		m = m + 15;
////		} else {
////			h = 23;
////			m = m + 15;
//		} else {
//			m = m + 15;
//			if(h != 0) {
//			    h = h-1;
//				}else {
//				h = 23;
//				}
//		}
//		
//		
//		System.out.println(h + " " + m);
//		// 11 : 55 
//		// h m    x
//		//10 10
//		// 9 25               m 10 -> 25   10 + 45    =>    h -1  m  + 15  
//		// if (y - m) ?         0 30     23 45                    if h = 0, h= 23,  m + 15   
//		// 0 0 분 23시 15분     55 -> 70   - 45     m> 45    m -45        
//		
//		//23 40  22 55         01: 46 
//		
	}

}
