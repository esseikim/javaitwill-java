package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()); 
		int y = Integer.parseInt(br.readLine()); 
		int z = Integer.parseInt(br.readLine()); 
		
		(x+y)%z== ((x%z) + (y%z))%z
		
		(x×y)%z== ((x%z) × (y%z))%C
	}

}
//(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
//
//(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
//
//세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
//1
//1
//0
//0