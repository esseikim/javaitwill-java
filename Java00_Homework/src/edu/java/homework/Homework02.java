package edu.java.homework;

public class Homework02 {

	public static void main(String[] args) {

		for (int i=1; i<=100 ; i++) {

			if(i %10==0) { //  같이 묶어버리면 30, 60, 90이 나오지 않음.  for 안에 if문 분리해서 2개 작성해야함
//				if(i%30==0) {
//					System.out.println( "*");
//				}
//				else {
					System.out.println(i);
			

			}else  {
				if(i/10==3 || i/10== 6 || i/10==9 || i%10==3 || i %10==6 ||i % 10==9 ) {
					System.out.print("*\t");
				}else {
					System.out.print(i + "\t");
				}
			}
		}
	} 
}
//30, 60, 90- *     i%30==0  
//1   2   *   4   5   *   7   8   *   10  
//11  12  *   14  15  *   17  18  *   20  
//21  22  *   24  25  *   27  28  *   *    
//*   *   *   *   *   *   *   *   *   40  
//41  42  *   44  45  *   47  48  *   50  
//51  52  *   54  55  *   57  58  *   *   
//*   *   *   *   *   *   *   *   *   70  
//71  72  *   74  75  *   77  78  *   80  
//81  82  *   84  85  *   87  88  *   *   
//*   *   *   *   *   *   *   *   *   100