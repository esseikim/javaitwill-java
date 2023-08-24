package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07_ {
    // JTable에서 사용할 컬럼 이름들
    private static final String[] COLUMN_NAMES = {"국어", "영어", "수학", "총점", "평균"};

    private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체
    private JFrame frame;
    private JLabel lblKorean;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JLabel lblEnglish;
    private JLabel lblMath;
    private JButton btnInsert;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07_ window = new AppMain07_();
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
    public AppMain07_(){
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 514, 544);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblKorean = new JLabel("국어");
        lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblKorean.setBounds(12, 10, 88, 61);
        frame.getContentPane().add(lblKorean);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textKorean.setBounds(112, 10, 374, 61);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        lblEnglish = new JLabel("영어");
        lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblEnglish.setBounds(12, 81, 88, 61);
        frame.getContentPane().add(lblEnglish);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textEnglish.setColumns(10);
        textEnglish.setBounds(112, 81, 374, 61);
        frame.getContentPane().add(textEnglish);
        
        lblMath = new JLabel("수학");
        lblMath.setFont(new Font("D2Coding", Font.PLAIN, 28));
        lblMath.setBounds(12, 152, 88, 61);
        frame.getContentPane().add(lblMath);
        
        textMath = new JTextField();
        textMath.setFont(new Font("D2Coding", Font.PLAIN, 28));
        textMath.setColumns(10);
        textMath.setBounds(112, 152, 374, 61);
        frame.getContentPane().add(textMath);
        
        btnInsert = new JButton("입력");
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertScoreToTable();
            }
        });
        btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnInsert.setBounds(12, 223, 188, 61);
        frame.getContentPane().add(btnInsert);
        
        btnDelete = new JButton("삭제"); 
        btnDelete.addActionListener(new ActionListener() { 
        	// window builder가 버튼 찾아주고, 버튼에 ActionListener 등록. 전부 다 익명클래스 사용. 메서드 argument로 클래스 타입 
        	// <- 전달자리에서 바로 생성자 호출. 생성자가 인터페이스의 생성자. 인터페이스의 객체 생성 불가. 객체생성 하도록 추상메서드 구현(override)
            @Override
            public void actionPerformed(ActionEvent e) {  
                deleteRowFromTable();  // event를 사용할 필요 없고, 어떤 값을 리턴하지 않는다. 
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 28));
        btnDelete.setBounds(212, 223, 188, 61);
        frame.getContentPane().add(btnDelete);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 294, 474, 201);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        Object[][] data = {}; // 테이블에 사용할 데이터
        model = new DefaultTableModel(data, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    private void deleteRowFromTable() { // 테이블에서 row 삭제. 여기서만 쓸 것. private
        // 1. 테이블에서 삭제하기 위해 선택된 행의 인덱스를 찾음.
        int index = table.getSelectedRow(); // 유저가 클릭한 행. 테이블에서 행의 인덱스를 찾는 메서드: table에 있음. 정보를 가져옴 get. 선택된 행 selected - 행의 인덱스를 리턴(int)
        if (index == -1) { // 행이 아무것도 선택되지 않은 경우.  이 메서드: 선택된 행들이 많으면 그 행들 중 첫번째. 하나만 선택 -> 하나의 row를 줌. 
            JOptionPane.showMessageDialog(  // 궁금해하는 사용자를 위해. 아무것도 선택 x -> 아무것도 하지 않고 메서드를 끝내버림. 아무일도 안 일어남. 사용자에게 안내해주는 게 좋음.
                // JOptionPane 클래스의 static 메서드
            		frame, 
                    "테이블에서 삭제할 행을 먼저 선택하세요...", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);  // int MessageType. 아이콘이 경고. 
            
            return; // 메서드 종료. 아무일도 하면 안됨. 
        }
        
        // 선택된 행이 있을 경우, 2. 해당 인덱스의 행을 테이블 모델에서 삭제.
        // 실제 삭제하는 것 : confirm 
        int confirm = JOptionPane.showConfirmDialog(   // 사용자에게 확인하기 위한 다이얼로그 confirm dialog: 전부 다 리턴 값 int 
                frame, // parent -> JFrame 넘겨주면 됨. 
                index + " 인덱스 행을 정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);  //  int optionType 버튼 종류, 개수. 타입의 숫자를 외우고 다닐 수 없음. 선언되어져 있는 상수를 찾아야 함(전부 다 상수로 정의되어 있음). JOptionpane 안의 staticfinal로 선언되어져 있는 옵션 종류를 찾으면 됨. 숫자를 쓰는 것과 동일함.   
        
        if (confirm == JOptionPane.YES_OPTION) {  // 무조건 삭제 x. 리턴값을 보고서 yes를 했을 때만 삭제. yes, no가 몇번인지 기억 못함. 
            model.removeRow(index); // int 타입으로 row의 인덱스로 주면 됨. 리턴타입: void -> 리턴타입을 저장하거나, 사용할 일 없음.
       // no를 선택하면 아무 일도 안 일어남. 
        }
    }

    private void insertScoreToTable() {
        // 1. JTextField에서 3과목의 점수를 읽음.
        int korean = 0;  // 지역변수(사용범위: 블록 안쪽 -> 바깥에서 그 변수들을 try가 끝난 다음 사용 불가. try + error가 없어 정상적으로 밑으로 내려왔을 때도 사용) -> 변수선언을 try문 바깥에서만 하면 됨. 지역변수로 선언했으면 값이 있어야 함! 가장 기본적인 값 0으로 전부 초기화
        int english = 0;
        int math = 0;
        try {  // textKorean.getText()의 결과: " " -> 비어있는 문자열을 숫자로 바꿀 수 없다. 입력된 문자열이 없을 때의 리턴값: null이 아닌 빈 문자열. 빈문자열은 Integer로 변환할 수 없다. 빈 문자열도 NumberFormatException
            korean = Integer.parseInt(textKorean.getText());    // 중복해서 변수선언 못함. 
            english = Integer.parseInt(textEnglish.getText());  // 1. JTextField에서 값을 읽어와 정수로 변환
            math = Integer.parseInt(textMath.getText());
        } catch (NumberFormatException e) 
        { // print 하지 말고. 콘솔 창에 뿌려주는 건 GUI 프로그램에서는 의미없음. 사용자에게 메세지 뿌려주기. JOptionPane.showMessageDialog
            JOptionPane.showMessageDialog(
                    frame, // 부모 컴퍼넌트. MessageDialog가 실행될(뜰) 그 부모: 화면의 있는 JFrame. JFrame을 담고있는 변수: frame 
                    "국어, 영어, 수학 점수는 반드시 정수로 입력: " + e.getMessage(), // 화면에 보여질 내용. 셋 중 어디서 발생했을 지 모름.   "국어, 영어, 수학 점수는 반드시 정수로 입력: ". 에러메시지 활용 가능(어디가 잘못됐는지 알 수 있음). 
                    "입력 에러",  // String title
                    JOptionPane.ERROR_MESSAGE); // 메세지 타입까지 있는 게 좋음.   
            // 이거는 일부러 남겠다. 에러메시지 보고 여기만 수정.  나머지는 제대로 입력한거니깐 남겨두라고 개발자 마음.
            
            return; // 에러 발생 시 내려가면 안 되고, 메서드 종료시킴. 종료된다고 프로그램 죽는 게 아님.  
        }
        
        // 2. 에러 없으면 밑으로 내려와서 Score 타입 객체 생성. 만들고 
        Score score = new Score(korean, english, math);
        
        // 3. JTable에 행(row)을 추가. row 만들고 
        Object[] row = {  // 행에 채워줄 값을 순서대로 써주면 됨. 하나의 행을 만들기 위한 1차원 배열 완성. 
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.getTotal(),
                score.getMean(),
        };
        model.addRow(row); // -> 모델에 행을 추가. 입력할 때마다 출력이 됨. // 사용자에게 보여주는 것.
        
        // 모든 JTextField의 입력 내용을 지움. 정상적 입력이 끝났을 땐 지워줌. row를 삽입한 다음에! 
        clearAllTextFields();  
    }
    
    private void clearAllTextFields() {  // 아규먼트 필요없음. JTextField 3개. 비어있는 문자열을 넣어주면 됨. 
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
    // 처음부터 에러처리 신경써서 코딩x. 정상적 기능을 어떤 순서로 할 것인지 정리. 과목을 읽는다. 읽는 코드 만들고. score, row, table 모델에 추가. 기능 제대로 동작하는지 test 먼저
    // 그런 후에 에러처리.  주된 기능을 만들어야할 것들을 놓침. 뼈대 먼저. 숲을 보기 -> 살 붙여 나가기
}