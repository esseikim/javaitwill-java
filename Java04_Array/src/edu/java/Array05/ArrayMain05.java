package edu.java.Array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		// int 10개를 저장할 수 있는 배열 선언

		int[] gendersCodes= new int[10];

		// 배열에 난수 (0, 1) 10개를 저장

		Random ran = new Random();


		for(int i =0; i< gendersCodes.length; i++ ) {
			gendersCodes[i]=ran.nextInt(11);

			if(gendersCodes[i]%2 ==0) {
				gendersCodes[i] =0;
			}else {
				gendersCodes[i] =1;
			}
			System.out.print(gendersCodes[i]);
		}
		   
		System.out.println();


		String[] genders = new String[10];
		for(int i =0; i< genders.length; i++ ) {
			if(gendersCodes[i] ==0) {
				genders[i] ="Male";
			}else {
				genders[i] = "Female";
			}
			System.out.print(genders[i]);
		}

		System.out.println();

		int malecount = 0;
		int femalecount = 0;
		for(int i  =0; i < genders.length; i++) {
			if(genders[i].equals("Male")) {
				malecount++;
			}else {
				femalecount++;
			}
		}
		System.out.println(malecount);
		System.out.println(femalecount);
		// 배열의 내용을 출력
		//	문자열 10개를 저장할 수 있는 배열을 선언
		//	gendersCode의 값이 0이면 문자열 "Male", 1이면 Female을 문자열 배열에 저장
	}

}
