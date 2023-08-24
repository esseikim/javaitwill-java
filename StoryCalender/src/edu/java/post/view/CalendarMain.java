/* 발표자료, 프로젝트 파일 집파일, 이클립스 없이 단독으로 프로그램....exe파일로 변환. windows의 실행파일 exe로 
 *  변환해주어야 할, launch4j
 *  실행 가능한 jar 파일로 내보내기 기능 이용. -> .jar로 만들어줌. 4j에게 넘겨주면 exe 파일을 만들어줌. 
 */
/*
 * StoryCalenderFinal 클래스의 인스턴스화 과정에서 생성되는 모든 Swing 컴포넌트를 뷰로 추출합니다.
뷰를 구성하는 모든 Swing 컴포넌트의 이벤트 리스너를 View 클래스 내부에 구현합니다.
뷰에 관한 모든 로직을 View 클래스 내부에 구현합니다.

 */
package edu.java.post.view;

import java.awt.AlphaComposite;
// TitledBorder: 테두리(border)에 타이틀(title)과 같은 추가 정보를 표시하는 Swing의 클래스
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import edu.java.post.controller.PostDaoImpl;
import edu.java.post.model.Post;
//public static List<String> imageFileList; 
//	public static List<Post> imageFileList = dao.read();
//메서드가 호출될 때마다 새로운 리스트가 생성되므로 리스트에 추가되는 버튼들이 유지
// 다음 달의 버튼이 생성될 때에도 buttonList 리스트에 추가하여, 그 전의 달에서 돈 for문의 인덱스 +1이 되도록 구현
// 해당 코드에서 버튼에 인덱스를 부여하는 부분이 없으므로, 버튼의 인덱스를 부여하려면 추가적인 작업이 필요..
// 생성된 버튼을 리스트에 담아두는 코드를 추가
// 버튼의 인덱스는 생성된 순서대로 부여되므로, 생성된 버튼을 리스트에 담아두고, 필요한 경우에 리스트에서 인덱스를 가져와서 사용할 수 있음.

public class CalendarMain extends JFrame {
	private static JFrame frame;
	private static final String[] DAYS_OF_WEEK = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	private final JPanel[] monthPanels;
	private final JScrollPane scrollPane;
	private final JPanel mainPanel;
	private int clickedIndex;
	public static List<JButton> buttonList = new ArrayList<>(); // 버튼들을 저장할 리스트 생성
	private PostDaoImpl dao = PostDaoImpl.getInstance();

	public static void notifyInfo() {
		JOptionPane.showMessageDialog(frame, "Upload 완료");
	}

	public CalendarMain() {
		frame = this;
		getContentPane().setBackground(Color.WHITE);
		// monthPanels: 각 월의 패널을 저장
		monthPanels = new JPanel[12];

		// for 루프를 사용하여 1월부터 12월까지 각 월의 패널을 생성하고 배열에 저장
		for (int i = 0; i < 12; i++) {
			monthPanels[i] = createMonthPanel(i + 1);
		}

		// 12개의 월 패널을 담을 수 있도록 그리드 레이아웃을 사용하여 생성
		mainPanel = new JPanel(new GridLayout(12, 1, 0, 30));
		mainPanel.setBackground(Color.BLACK);
		// monthPanels" 배열에서 각 월 패널을 "mainPanel"에 추가
		mainPanel.setBorder(new EmptyBorder(10, 130, 10, 10));
		for (int i = 0; i < 12; i++) {
			mainPanel.add(monthPanels[i]);
		}

		// "mainPanel"을 스크롤
		scrollPane = new JScrollPane(mainPanel);
		// 수평 스크롤 막대가 필요하지 않으므로
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		getContentPane().add(scrollPane);

		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(Color.WHITE);
		scrollPane.setRowHeaderView(optionPanel);

		JButton btnUpload = new JButton("Upload Photo");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhotoUploader.showPhotoUploader(CalendarMain.this);
			}
		});
		optionPanel.add(btnUpload);

		setTitle("Diary Year View");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * 매개 변수로 받은 월을 기준으로 "YearMonth" 객체를 만들고 해당 월의 "JPanel"을 만듦
	 * 
	 * @param int
	 * @return JPanel
	 */
	private JPanel createMonthPanel(int month) {
		// YearMonth.now()로 현재 시스템 날짜를 가져오고 withMonth(month)로 해당 월(month)을 설정한 YearMonth
		// 객체를 생성
		// yearMonth 객체를 통해 년도와 월 정보를 가져와 사용. 현재 날짜를 기준으로 선택 가능한 년/월/일을 동적으로 구성.
		YearMonth yearMonth = YearMonth.now().withMonth(month);

		// "JPanel"은 그리드 레이아웃을 사용하고, 첫 번째 행에는 "DAYS_OF_WEEK" 배열의 요일 이름을 나타내는 "JLabel"을
		// 추가
		JPanel monthPanel = new JPanel(new GridLayout(0, 7, 5, 5));
		// yearMonth.format(DateTimeFormatter.ofPattern("MM yyyy"))를 타이틀로 사용하여
		// TitledBorder 객체 생성
		TitledBorder border = new TitledBorder(yearMonth.format(DateTimeFormatter.ofPattern("MM yyyy")));
		border.setTitleFont(new Font("SansSerif", Font.BOLD, 16));
		border.setTitleColor(Color.WHITE);
		border.setTitleJustification(TitledBorder.CENTER);
		border.setBorder(new LineBorder(Color.WHITE, 3));
		monthPanel.setBackground(Color.BLACK);
		monthPanel.setBorder(border);

		for (String dayOfWeek : DAYS_OF_WEEK) {
			JLabel label = new JLabel(dayOfWeek, SwingConstants.CENTER);
			label.setBorder(new LineBorder(Color.WHITE));
			label.setForeground(Color.WHITE);
			monthPanel.add(label);
		}

		// 해당 월의 첫 번째 날짜인 LocalDate 객체를 반환, 2022-04-01
		LocalDate firstOfMonth = yearMonth.atDay(1);
		LocalDate lastOfMonth = yearMonth.atEndOfMonth(); // 2022-04-30

		int firstWeekday = firstOfMonth.getDayOfWeek().getValue();
		int lastWeekday = lastOfMonth.getDayOfWeek().getValue();
		int numEmptyDaysAtStart = firstWeekday == 7 ? 0 : firstWeekday; // 일요일
		int numEmptyDaysAtEnd = lastWeekday == 7 ? 6 : 6 - lastWeekday;

		for (int i = 1; i <= numEmptyDaysAtStart; i++) {
			JLabel j = new JLabel("");
			j.setBackground(Color.BLACK);
			j.setOpaque(true);
			monthPanel.add(j);
		}

		for (LocalDate date = firstOfMonth; date.isBefore(lastOfMonth.plusDays(1)); date = date.plusDays(1)) {
			// 버튼을 생성할 때마다, 버튼의 라벨에는 date 변수가 가지고 있는 일(day) 정보가 들어가도록 설정
			JButton button = new JButton(Integer.toString(date.getDayOfMonth()));
			System.out.println(date.getDayOfMonth());
			// LocalDate 객체가 나타내는 날짜의 일(day)의 요일을 반환
			button.setBackground(Color.BLACK);
			button.setBorderPainted(false); // 버튼 바깥쪽 그리드 제거
			button.setForeground(Color.WHITE);
			button.setOpaque(true); // 버튼의 투명도

			// 해당 컴포넌트의 선호 크기(preferred size)를 설정, 모든 JButton 객체의 크기가 (50, 50) 픽셀로 설정
			button.setPreferredSize(new Dimension(50, 50));
			// button.setSize(new Dimension(50, 50));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton clickedButton = (JButton) e.getSource();
					int clickedIndex = Integer.parseInt(clickedButton.getText());
					System.out.println(clickedIndex);
					LocalDate selectedDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), clickedIndex);
					// 생성된 YearMonth 객체와 사용자가 선택한 일자를 조합하여 LocalDateTime 객체를 생성
					System.out.println(selectedDate);
					// 선택한 날짜로 컨텐츠 생성

					PhotoViewer.showPhotoViewer(selectedDate, CalendarMain.this, monthPanel, clickedButton,
							clickedIndex, yearMonth);
					// if (imageFileList == null) {
					// JOptionPane.showMessageDialog(StoryCalendar.this, "저장된 사진이 없습니다");
					// } else {
					// PhotoViewer.showPhotoViewer(selectedDate, StoryCalendar.this, monthPanel,
					// clickedButton, clickedIndex, yearMonth);
					// }

					// 클릭된 버튼, 썸네일이미지 경로, 선택 총일자문자열, 해당판넬,// 인덱스..
					// 해당판넬(넘겨줘야, ), 클릭된 버튼. 총일자 문자열 selectedDate
					// clickedButton.setOpaque(false);

					// setThumbnail(clickedButton, PhotoViewer.PATH + selectedDate+ "_1.JPG" +
					// selectedDate.toString(), monthPanel, clickedIndex );
					// System.out.println(PhotoViewer.PATH + selectedDate+ "_1.JPG");

					// ImageIcon icon = new ImageIcon(PhotoViewer.PATH + selectedDate+ "_1.JPG");
					// Image image = icon.getImage().getScaledInstance(clickedButton.getWidth(),
					// clickedButton.getHeight(), Image.SCALE_SMOOTH);
					// ImageIcon thumbnail = new ImageIcon(image);
					// button.setIcon(thumbnail);

				}
			});

			buttonList.add(button);
			monthPanel.add(button);
		}

		for (int i = 1; i <= numEmptyDaysAtEnd; i++) {
			JLabel j = new JLabel("");
			j.setBackground(Color.BLACK);
			j.setOpaque(true);
			monthPanel.add(j);
		}

		return monthPanel;
	}

	public void setThumbnail(JButton button, String path, JPanel monthPanel, int clickedIndex, YearMonth yearMonth,
			LocalDate selectedDate, List<String> imageFileList, List<Post> PostList) {

		// 패널에서 선택한 버튼을 제거.
		monthPanel.remove(button);

		// 새로운 버튼을 생성.
		ImageIcon img = new ImageIcon(path);
		Image resizedImg = img.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		img = new ImageIcon(resizedImg);

		// 이미지 둥글게 처리.
		Image roundedImg = createCircularImage(resizedImg);

		button = new JButton(new ImageIcon(roundedImg));
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setText(clickedIndex + "");
		button.setForeground(Color.WHITE);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhotoViewer.showPhotoViewer(selectedDate, CalendarMain.this, monthPanel, clickedIndex, yearMonth,
						imageFileList, PostList);
			}
		});

		// 해당 월의 첫째 날을 계산
		LocalDate firstOfMonth = yearMonth.atDay(1);
		int firstWeekday = firstOfMonth.getDayOfWeek().getValue();
		int numEmptyDaysAtStart = firstWeekday == 7 ? 0 : firstWeekday; // 일요일

		int index = 7 + numEmptyDaysAtStart + clickedIndex - 1;
		System.out.println("index" + index);
		// 새로운 버튼을 부모 패널에 추가.
		monthPanel.add(button, index);
		monthPanel.revalidate();
		monthPanel.repaint();

		// // <- 썸네일 이미지 원형 버튼 적용 이전
		// button = new JButton(img);
		// button.setBorderPainted(false);
		// button.setOpaque(false);
		// button.setHorizontalTextPosition(JButton.CENTER);
		//// button.setVerticalTextPosition(JButton.CENTER);
		// button.setText(clickedIndex + "");
		// button.setForeground(Color.WHITE);

		// // buttonList.set(clickedIndex, button); // for문 돌때마다 index 변경 <- 불필요..
		//
		// // 해당 월의 첫째 날을 계산
		// LocalDate firstOfMonth = yearMonth.atDay(1);
		// int firstWeekday = firstOfMonth.getDayOfWeek().getValue();
		// int numEmptyDaysAtStart = firstWeekday == 7 ? 0 : firstWeekday; // 일요일
		//
		// int index = 7 + numEmptyDaysAtStart + clickedIndex -1 ;
		// System.out.println("index" + index);
		// // 새로운 버튼을 부모 패널에 추가.
		// monthPanel.add(button, index);
		// monthPanel.revalidate();
		// monthPanel.repaint();

	}

	public BufferedImage createCircularImage(Image image) {
		int width = image.getWidth(null);
		int height = image.getHeight(null);

		// 원형 마스크 생성
		BufferedImage mask = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = mask.createGraphics();
		g2d.fillOval(0, 0, width, height);
		g2d.dispose();

		// 이미지와 마스크 합성
		BufferedImage maskedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g2d = maskedImage.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
		g2d.drawImage(mask, 0, 0, null);
		g2d.dispose();

		return maskedImage;
	}

	public static void main(String[] args) {
		new CalendarMain();
	}
}