// 똑같은 자바파일이더라도 open with windowbuild Editor로 열면 됨. 아래 탭이 보여지게 됨. 
package edu.java.swing04;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class AppMain04 {

	JFrame frame;
	private JLabel images;
	private int index = 0;  // 사진 인덱스

	// 값이 변하지 않음. 상수로 만들어 버림. 다른 애들도 쓸 것. 이미지 파일의 경로만 알고 있으면 됨. 
	private static final String[] IMAGES = {
			"images/car.jpg", "images/equipment.jpg", "images/lighthouse.jpg", "images/reed.jpg" ,"images/sky.jpg"
	};

	// 인덱스를 처리하기 위한 변수. 어떤 클래스의 기본생성자에서 int 타입의 필드를 초기화하지 않으면 기본값 0으로 초기화됨. 생성자에서 특별한 일을 하지 않더라도
	// 현재 화면에 보여지는 이미지 파일의 인덱스
	private int curIndex;


	// - ImageIcon을 매개변수로 받는 생성자가 있는 컴포넌트는 모두 이미지를 불러올 수 있다. 
	// - ImageIcon 객체를 사용하면 이미지를 쉽게 컴포넌트에 붙일 수 있다. 
	// - 자바에서 경로를 표기할 때는 \\ 또는 / 로 표시해야 한다.

	ImageIcon car = new ImageIcon("images/car.jpg");
	ImageIcon equipment = new ImageIcon("images/equipment.jpg");
	ImageIcon lighthouse = new ImageIcon("images/lighthouse.jpg");
	ImageIcon reed = new ImageIcon("images/reed.jpg");
	ImageIcon sky = new ImageIcon("images/sky.jpg");
	//	List<ImageIcon> list = Arrays.asList(car, equipment, lighthouse, reed, sky);
	List<String> list2 = Arrays.asList("images/car.jpg", "images/equipment.jpg", "images/lighthouse.jpg", "images/reed.jpg", "images/sky.jpg");

	//label = new JLabel("이미지를 보려면 아래 버튼을 누르세요.");
	//button = new JButton("이미지 레이블");
	//ImageIcon icon = new ImageIcon("dog.png");

	private int upIndex() {

		if(index == 4) {       // 0 1 2 3 4    
			index =0;
			return index; 
		}else { 
			index ++;
			return index; 
		}
	}

	private int downIndex() {  // 4 3 2 1 0
		if (index == 0) {
			index = 4;
			return index; 
		}else {
			index --;
			return index; 
		}
	}

	public static void main(String[] args) {
		/*
		 * 메인메서드가 실행 -> AppMain04(); 객체를 생성하고, JFrame의 객체가 만들어질테니, 변수가 true로 바뀜. 그 JFrame을 화면에 보여주겠다. 
		 */
		EventQueue.invokeLater(new Runnable() { 
			//new Runnable() : 러너블 객체를 만든다. 메인 이외의 별도의 쓰레드를 만들어두고 EventQueue 담아서, 순서가 되면 쓰레드를 호출하겠다. 
			public void run() {
				try {
					AppMain04 window = new AppMain04();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		// 초기화 코드 너무 긺. 별도의 메서드로 만들어둠. 화면에 보여지는 컴포넌트 객체 생성, 그 컴포넌트를 JFrame에 보여준다. 
		ImageIcon a = new ImageIcon("images/car.jpg");
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); 
		/* 레이블에 글자를 써주기 위한 것 (String), 생성자 중 Icon을 가지는 것을 써주면 됨.
		 * Icon 자체는 인터페이스 -> 익명클래스를 만들어야함. 다 구현하기 힘듦. 
		 * Icon 인터페이스를 구현하고 있는 클래스: ImageIcon 
		 * ImageIcon : 생성자 중 argument로 String을 받는 걸 쓰면 됨. 우리는 이미지 경로를 문자열로 저장하고 있음. 
		 * 경로 배열의 0번째 경로를 넣어주면 됨.(IMAGES[curIndex])  <- new ImageIcon("images/car.jpg")와 동일
		 */


		images = new JLabel(a);
		images.setBounds(74, 36, 319, 337);
		frame.getContentPane().add(images);
		// 레이블이 화면에 붙여넣음. -> 보여지게 됨.


		JButton after = new JButton(">"); 
		/* 컴포넌트마다 해야할 일이 다름 -> EventListener을 등록한다. (해야할 일을 개발자가 만들어준다. 무슨 일을 할 건지). 
		 * Frame을 통해 틀을 원하는대로 컴포넌트 배치를 하고, 실질적 기능은 우리가 만들어주면 됨. 
		 */
		after.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				/* 람다식 :new ~ void 까지 필요 없음. 메서드 1개뿐 FunctionalInterface를 가짐 
				 * -> 메서드 이름으로 구분할 필요없음. argument와 body만 남음. 
				 * argument 자리에 화살표, 중괄호가 있으면 닫아주는 중괄호만 있으면 됨. 
				 * 메서드의 argument와 body만 남겨두고 argument와 body를 ->로 연결. 
				 * 아규먼트에서 아규먼트 타입은 생략해도 됨. 인터페이스를 보면 아규먼트 타입이 나와있음. 
				 * 중괄호 생략 시 ; 생략 가능. actionPerformed((e) -> showNextImage());  
				 */
				int count = upIndex();
				ImageIcon a = new ImageIcon(list2.get(count));
				images.setIcon(a);
			}
		});
		after.setFont(new Font("D2Coding", Font.PLAIN, 32));
		after.setBounds(284, 394, 120, 68);
		frame.getContentPane().add(after);



		JButton before = new JButton("<");
		before.addActionListener(new ActionListener() { 
			/* 버튼에 액션리스너를 등록하겠다. argument로 액션리스너 타입을 추가해야함. 
			 * 액션리스너는 인터페이스 -> 추상메서드를 가짐. 가지고 있는 추상메서드를 오버라이딩 해주면 됨.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {  // actionPerformed() 메서드: 버튼이 클릭 됐을 때 자동호출-> 내용을 채워주면 우리가 작성한 코드가 실행됨.
				// before 버튼이 클릭됐을 때 할 일을 작성. 
				showPrevImage(); // 메서드 생성위치: 클래스 안 -> 내부클래스, 외부클래스 2가지 위치. 

				//				int count = downIndex();
				//				//				images = new JLabel(list2.get(count));   // 라벨을 여러개 생성할 필요 없음.
				//				ImageIcon a = new ImageIcon(list2.get(count));
				//				images.setIcon(a);
				//				//				images.setBounds(74, 36, 319, 337);   // 위와 마찬가지. 공통임.
				//				//				frame.getContentPane().add(images);
			}
		});
		before.setFont(new Font("D2Coding", Font.PLAIN, 32));
		before.setBounds(48, 394, 120, 68);
		frame.getContentPane().add(before);
	}

	private void showPrevImage() {
		curIndex++;
		images.setIcon(new ImageIcon(IMAGES[curIndex])); 
		// OutOfRangeException <- JFrame에서 발생하는 모든 Exception을 잡음. 
		// 무조건적 증가 x
	}
}

