package edu.java.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		//		구구단 2단은 2x2 까지  3단으 3x3까지
		//2x 1
		//2x2
		//
		//3x1
		//3x2
		//3x3


		for (int i = 2; i <10; i++ ) {
			for (int j=1; j<= i; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j);

			}
		}

		for (int i = 2; i <10; i++ ) {
			for (int j=1; j<10; j++) {
				if (i>=j) {
					System.out.printf("%d x %d = %d\t", i, j, i*j);
					System.out.println();
				}
			}
		}
		for (int i = 2; i <10; i++ ) {
			for (int j=1; j<10; j++) {
				System.out.printf("%d x %d = %d\n", i, j, i*j); // 찍고 같아질 때 빠져나와 가까운 for문으로 감
				if (i==j) {  // 같지 않으면 break를 만나지 않는다.  break를 만나면 가까운 for를 빠져나간다/ 
					break;  ///멈추지 않을거면 올라가서 반복!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				} //  end if
			}	// end for(j)
		} // end for(i)

		for (int a = 2; a <10; a++ ) {
			for (int b=1; b<10; b++) {
				if (a>=b) {
					System.out.printf("%d x %d = %d\n", a, b, a*b); // break는 가장 가까운 for문을 빠져나간다
					break ; // 한번만 실행하고 전체 빠져나옴.
				}
			}

		}
		int x =2;   //break 안 쓸거면 y를 x를 이용해 조건문 바꿔주면 된다
		while(x<10) {
			System.out.println("======="+ x+"단" +" ========");

			int y = 1;
			while (y<10) {
				System.out.printf("%d X %d = %d\n", x,  y,  x * y);
				if (x ==y) { //
					break;
				}
				y++;			
			}	
			x++;
		}

		int a = 1;
		while (a<10) {
			System.out.println("--------"+a +"단--------");

			int b = 1;
			while(b <=a) {
				System.out.printf("%d x%d = %d\n", a, b, a*b);
				b++;
			}

			a++;	
		}

	}
}
//			if (a == b) {   for문이 중요! if 무시
//						System.out.print();
//						break;

