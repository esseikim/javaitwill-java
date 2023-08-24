package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main7{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		for (int i = 1; i <= x; i++) {
			for (int j = 0; j< x-1; j--) {
				System.out.print(" ");

			}
			for (int z= i; z < x; z--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}