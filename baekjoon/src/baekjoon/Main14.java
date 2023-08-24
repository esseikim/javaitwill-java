package baekjoon;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()); // br을 사용해서 한줄로 입력받은 값을 저장

		for (int i = 0; i < x ; i++){

			for(int j = 0; j < x ; j++ ) {
				System.out.print(" "); 
			}
			for (int z = 0; z < x ; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


//첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
//
//하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
