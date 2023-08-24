package edu.java.interface01;
// 상속받은 추상메서드가 있으면 추가하겠다. 기본적으로 체크 되어있음. 
public class MariaDBModule implements DatabaseModule { // 기존 것 오류, 기존 것 없애기로 ! 다르게 구현! 오버라이드~

	@Override
	public int select() {
		System.out.println("MariaDB select()");
		return 0;
	}

	@Override
	public int insert(String strVal, int intVal) {
		System.out.printf("MariaDB insert(%s, %d)%n",strVal, intVal);
		return 0;
	}

}
