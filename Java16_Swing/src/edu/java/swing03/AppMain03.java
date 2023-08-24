package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JTextArea textResult;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(300, 200, 500, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel label1 = new JLabel("Number1");
        label1.setFont(new Font("D2Coding", Font.PLAIN, 32));
        label1.setBounds(12, 10, 120, 64);
        frame.getContentPane().add(label1);
        
        JLabel label2 = new JLabel("Number2");
        label2.setFont(new Font("D2Coding", Font.PLAIN, 32));
        label2.setBounds(12, 84, 120, 64);
        frame.getContentPane().add(label2);
        
        textNumber1 = new JTextField();
        textNumber1.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textNumber1.setBounds(144, 10, 320, 64);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        textNumber2 = new JTextField();
        textNumber2.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textNumber2.setColumns(10);
        textNumber2.setBounds(144, 84, 320, 64);
        frame.getContentPane().add(textNumber2);
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override  // GUI component 정보를 리턴. 주소값으로 같은지 다른지 비교.  e:  +, -, *, /의 정보를 가짐
            public void actionPerformed(ActionEvent e) { 
            	System.out.println(e.getSource() == btnPlus); 
            	handleButtonClick(e);
            }
        });
        btnPlus.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnPlus.setBounds(12, 158, 64, 64);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnMinus.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnMinus.setBounds(88, 158, 64, 64);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnMultiply.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnMultiply.setBounds(164, 158, 64, 64);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnDivide.setFont(new Font("D2Coding", Font.PLAIN, 32));
        btnDivide.setBounds(240, 158, 64, 64);
        frame.getContentPane().add(btnDivide);
        
        textResult = new JTextArea();
        textResult.setFont(new Font("D2Coding", Font.PLAIN, 32));
        textResult.setBounds(12, 236, 452, 195);
        frame.getContentPane().add(textResult);
    }
	
    private void handleButtonClick(ActionEvent event) {
//        System.out.println(event.getSource());
        //-> argument로 전달된 ActionEvent 객체에서 이벤트가 발생한 GUI 컴포넌트 정보를 알 수 있다.
        
        // JTextField에 입력된 문자열을 읽어서 double 타입으로 변환.
        double number1 = 0;
        double number2 = 0;
        try { // getText(): String 리턴. textFiled에 입력된 문자열. 
            number1 = Double.parseDouble(textNumber1.getText()); // 읽어서 double 타입으로 변환한다. 
            number2 = Double.parseDouble(textNumber2.getText());
            
        } catch (NumberFormatException e) { //<- NumberFormatException발생 가능,  try-catch 
            textResult.setText("number1,2는 숫자로 입력하세요...");
            return; // 3. 익셉션 발생의 경우 더 진행하지 않고 메서드 종료. catch 아래의 코드 실행x 
        }
        
        // 4. 오류 발생 안 했으면 진행.
        double result = 0; 
        // 뭐가 나올 지 모르니깐. 사칙 연산 결과를 저장할 변수
        String op = ""; 
        // op(operator): 사칙 연산 연산자 문자열을 저장할 변수(+, -, x, /), 결과식에 문자열 만들기 위함 
        
        Object source = event.getSource(); // 이벤트가 발생한 컴포넌트
        if (source == btnPlus) {
            result = number1 + number2;
            op = "+";
        } else if (source == btnMinus) {
            result = number1 - number2;
            op = "-";
        } else if (source == btnMultiply) {
            result = number1 * number2;
            op = "x";
        } else if (source == btnDivide) {
            result = number1 / number2;
            op = "/";
        }
        
        String msg = String.format("%f %s %f = %f", number1, op, number2, result);
        textResult.setText(msg);
    	/* 필드로 전부 올려버림. 이름을 알아야함. 
    	* ActionEvent e 를 활용하는 방법! 버튼 하나하나를 따로따로 메서드로 만들어도 되지만, 
    	* 두개만 읽고 +,-,*,/ 결과 출력. 비슷한 코드를 한 군데에 몰아버림
    	*
    	* event.getSource(); 
    	* 소스: 이벤트는 모든 component에서 발생 가능. JTextField에서도, JLabel에서도, JButton에서도
    	* 클릭하는 component에 따라 발생하는 이벤트 소스가 다름. 오브젝트 제일 상위타입으로.
    	* 이벤트 소스가 button인 경우에만 처리될 코드를 작성하려면 actionPerformed() 메소드에서 getSource() 메서드를 사용 -> 이벤트 소스 확인 가능
    	* 
    	* - ActionEvent 클래스: 사용자가 GUI 컴포넌트를 조작할 때 발생하는 이벤트
    	* 
    	* - ActionListener: ActionEvent를 처리하는 인터페이스, 구현한 객체를 EventListener로 등록하면, 
    	*                          해당 객체에서 정의한 동작이 ActionEvent가 발생할 때 실행됩니다.
    	*                           - addActionListener(): EventListener를 등록하는 메서드
    	*                           
    	*-  actionPerformed(): ActionListener 인터페이스에 정의된 추상메서드(1개- FunctionalInterface), 
    	*                              ActionEvent가 발생했을 때 실행되는 코드를 작성하는 메소드
    	*                              이벤트의 소스를 확인하고, 해당 소스에 대한 동작을 구현
    	* 
    	* 버튼 만들 때 메서드를 외부클래스에 만듦. 외부클래스에 있는 것은 모든 내부클래스에서 사용 가능 -> 쉽게 접근, 코드 깔끔.  
    	* handleButtonClick(e); 메서드 하나로 argument로 전달된 ActionEvent 객체로부터 이벤트가 발생한 GUI(Swing) 컴포넌트 정보를 알 수 있다. 
    	* 
    	* getText(), setText() 메서드: Swing 라이브러리에서 제공하는 컴포넌트에서 사용되는 메소드
    	* - getText(): 텍스트를 가져오는 데 사용. 해당 컴포넌트에 입력된 텍스트를 문자열로 반환
    	* - setText(): 텍스트를 설정하는 데 사용. 해당 컴포넌트에 텍스트를 설정. argument로 문자열만 가능
    	*  println: override 되어 있는 게 많음. 문자열 int 여러가지의 argument를 가짐. 오버로드 되어있음. 
    	*  but 얘는 얘 하나 뿐임. 결과 값이 String일 수 밖에. 
    	*  변수 result: double타입 -> 숫자를 문자열로 바꾸는 방법이 제일 쉬움 + ""
    	*/
//    	private void handleButtonClickDivide() {
//          Double divide = Double.parseDouble(textFieldNum1.getText()) / Double.parseDouble(textFieldNum2.getText());
//          textArea.setText(divide.toString());
    }
}
