package edu.java.inner03;

import edu.java.inner03.Button.OnClickListener;

public class OpenButtonListener implements OnClickListener {
	// imple 후 OpenButtonListener 에러: 추상메서드를 구현해야함. 
	// 이 클래스 설계 이유: OnClickListener타입이 메인에서 필요했음. 

	@Override
	public void onClick() {
		System.out.println("파일 탐색기 실행…");
	}

}