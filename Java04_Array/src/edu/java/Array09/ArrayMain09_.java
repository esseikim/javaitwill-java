package edu.java.Array09;

import java.util.Random;

public class ArrayMain09_ {
   public static void main(String[] args) {
  
      // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
      int[][] array = new int[3][];

      // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
      // 저장하는 난수의 범위는 0 이상 100 이하.
      Random rand= new Random();

      for (int i = 0; i < array.length; i++) {
         array[i] = new int[i + 2];
         for(int j = 0; j < array[i].length; j++) {
            array[i][j] = rand.nextInt(101);
         }
      }
      
     // 2차원 배열의 원소들을 출력.
      for (int[] i : array) {
         for (int j : i) {
            System.out.print(j + " ");
         }
         System.out.println();
      }
     
      
      // 2차원 배열의 모든 원소들의 합을 계산하고 출력.
      int sum = 0;
      int count = 0;
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            sum += array[i][j];
            count++;
         }
      }
      System.out.println("합 : " + sum);

      // 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
      double avg = (double)sum / count;
      System.out.println("평균 : " + avg);
      
        // 최댓값을 찾고 출력.
        // 최솟값을 찾고 출력.

      int max = array[0][0];
      int min = array[0][0];
      
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            if (array[i][j] > max ) {
               max = array[i][j];
            } else if (array[i][j] < min) {
               min = array[i][j];
            }
         }
      }
      
      System.out.println("최댓값  = " + max);
      System.out.println("최솟값 = " + min);
   }
}