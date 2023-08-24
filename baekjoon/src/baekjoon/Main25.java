package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main25 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer tkn = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(tkn.nextToken());
      int[] kettles = new int[n];
      int k = Integer.parseInt(tkn.nextToken());
      
      int max = 0;
      
      for (int i = 0; i < kettles.length; i++) {
         kettles[i] = Integer.parseInt(br.readLine());
         if (max < kettles[i]) {
            max = kettles[i];
         }
      }
//      System.out.println(max);
      System.out.println(binarySearch(kettles, max, k));
   }
   
   private static int binarySearch(int[] kettles, int max, int target) {
	   int left = 0;
	   int right = max;

	   while (left <= right) {
	      int mid = (left + right) / 2;
	      
	      if (divide(kettles, mid) > target) {
	         left = mid + 1;
	      } else if (divide(kettles, mid) < target) {
	         right = mid - 1;
	      } else if (divide(kettles, mid) == target) {
	         return mid;
	      }
	   }

	   return -1;
	}

   
   private static int divide(int[] kettles, int mid) {
	   int numberOfPeople = 0;

	   for (int i = 0; i < kettles.length; i++) {
	      numberOfPeople += kettles[i] / mid;
	      if (kettles[i] % mid != 0) {
	         numberOfPeople++;
	      }
	   }
	   return numberOfPeople;
	}

}