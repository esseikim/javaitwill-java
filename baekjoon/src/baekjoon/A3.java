package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()); // 5
		
		for(int i = 0; i < x; i++) { //5번 반복하는 for문
			StringTokenizer str = new StringTokenizer(br.readLine()); //5번 입력받음(readLine() = 한줄입력)
			int a = Integer.parseInt(str.nextToken()); // 5번 입력받는 것 중에서 각 입력 줄의 첫번째 값을 a로 두겠다.
			//nextToken() 한 줄 입력받은 것들을 공백을 기준으로 토큰화하여 순서대로 하나씩 가져오겠다.
//			int[] iArr = new int[a]; //배열의 길이가 a
//			for (int j = 0; j < iArr.length; j++) { // a만큼 반복하는 for문
//				iArr[j] = Integer.parseInt(str.nextToken());
			int sum = 0;
			for (int j = 0; j < a; j++) {
				sum += Integer.parseInt(str.nextToken());
			}
			
//			String s = br.readLine();
//			String[] arr = s.split(" ");
//			System.out.println(Arrays.toString(arr));
		}
	}

}
