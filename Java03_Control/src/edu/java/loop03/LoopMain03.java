package edu.java.loop03;

public class LoopMain03 {

	public static void main(String[] args) {
		/* print f: format 형식을 정해놓음. 탬플릿
		 * /n :new line. 줄바꿈해라.   2 x ㅁ = ㅁ  <- ㅁ:정수, 줄바꿈 
		 *
		 * 문제1. 아래와 같은 형식으로 구구단 2단을 출력하세요.
            2 x 1 = 2
            2 x 2 = 4
            2 x 3 = 6
            ...
            2 x 8 = 16
            2 x 9 = 18
		 */

		for (int n=1 ; n<10;n++) {
			//System.out.println("2 x"+n+"="+2 *n );
			System.out.printf("2 x %d = %d\n", n, 2*n); 
			// 처음 무조건 문자열 포맷 넣어야 함. 이 자리가 비어있다. 이 자리에는 정수가 들어갈 거다.
			//  System.out.printf(문자열 템플릿/ 포맷. 템플릿을 채울 값들);
			// %d : 정수, %f : 실수, %s : 문자열
			// \n: 줄바꿈(new line), \t: 탭(tab)
		}

		for (int i=1; i <10;i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i+"x"+j+"="+i*j);  
			}
		}
		// "|t" : tab 키 만큼 공백을 넣어줌. 
		/* 문제2. 아래와 같이 출력하세요.
            1     2     3     4     5     6     7     8     9     10
            11    12    13    14    15    16    17    18    19    20
            21    22    23    24    25    26    27    28    29    30
            31    32    33    34    35    36    37    38    39    40
            41    42    43    44    45    46    47    48    49    50
            51    52    53    54    55    56    57    58    59    60
            61    62    63    64    65    66    67    68    69    70
            71    72    73    74    75    76    77    78    79    80
            81    82    83    84    85    86    87    88    89    90
            91    92    93    94    95    96    97    98    99    100
		 */

		for (int n= 1; n <=100; n++) {
			System.out.print(n+"\t");
			if(n%10==0) {
				System.out.println();

			}
		}

		/*
		for (int i= 1; i<10; i++) {
			System.out.println();	
			for(int j =0; j<10; j++) {
				System.out.print(i);
				System.out.print(j + "\t");
			}
		}		
		for (int i = 1; i<10; i++) {
			System.out.println();	
			for(int j = 1; j <9; j++)
				System.out.print(i+j+"/t");
		}

		System.out.println(i+"\t");
		System.out.println(j+"\t");
		System.out.print(i+j+"\t");
		 */




	}

}


