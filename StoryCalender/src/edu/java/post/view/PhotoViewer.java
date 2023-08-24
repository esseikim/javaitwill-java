package edu.java.post.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.post.controller.PostDaoImpl;
import edu.java.post.model.Post;

public class PhotoViewer extends JFrame {

	private JPanel contentPane;
	private JButton prevBtn;
	private JButton nextBtn;
	private JLabel lblLoc;
	private JLabel lblDateTime;
	private JLabel lblCom;
	private JLabel lblImage;
	private LocalDate selectedDate;
	private List<String> imageFileList; 
	public static final String PATH = "./images/";
	private static int cnt;
	private CalendarMain app;
	private JPanel lblPanel;
	private JPanel monthPanel;
	private JButton clickedButton;
	private int clickedIndex;
	private YearMonth yearMonth;
	private PostDaoImpl dao = PostDaoImpl.getInstance();
	private List<Post> PostList; 

	/**
	 * Launch the application.
	 */
	public static void showPhotoViewer(LocalDate selectedDate, CalendarMain app, JPanel monthPanel, JButton clickedButton, int clickedIndex, YearMonth yearMonth) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhotoViewer frame = new PhotoViewer(selectedDate, app, monthPanel, clickedButton, clickedIndex, yearMonth);
					System.out.println(frame.imageFileList);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


		});
	}

	public static void showPhotoViewer(LocalDate selectedDate, CalendarMain app, JPanel monthPanel,  int clickedIndex, YearMonth yearMonth, List<String> imageFileList, List<Post> PostList) {
		JFrame frame = new JFrame("PhotoViewer");
		int x = 100;
		int y = 100;
		if (app != null) {
			x = app.getX();
			y = app.getY();
		}
		frame.setBounds(x, y, 600, 800);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		JPanel lblPanel = new JPanel();
		lblPanel.setBounds(0, 0, 600, 800);
		lblPanel.setBackground(new Color(0, 0, 0)); // rgb...
		lblPanel.setLayout(null);
		contentPane.add(lblPanel);
//
		JLabel lblLoc = new JLabel("");
		lblLoc.setForeground(Color.WHITE);
		lblLoc.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblLoc.setBounds(418, 287, 176, 39);
		lblLoc.setText(PostList.get(cnt).getLocation());
		lblPanel.add(lblLoc);

		JLabel lblDateTime = new JLabel("");
		lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblDateTime.setBounds(102, 26, 395, 39);
		lblDateTime.setText(PostList.get(cnt).getDateTime().toString());	  
		lblPanel.add(lblDateTime);

		JLabel lblCom = new JLabel("");
		lblCom.setForeground(Color.WHITE);
		lblCom.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCom.setBounds(62, 552, 532, 31);
		lblCom.setText(PostList.get(cnt).getComment());
		lblPanel.add(lblCom);
//

		cnt = 0;
		ImageIcon img = new ImageIcon(PATH + imageFileList.get(cnt));
		Image image = img.getImage();
		Image resizedImg = image.getScaledInstance(lblPanel.getWidth(), lblPanel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImg);
		JLabel lblImage = new JLabel(resizedIcon);
		lblImage.setBounds(0, 0, 600, 800);
		lblPanel.add(lblImage);

		JButton prevBtn = new JButton("<");
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt = cntDown (e,cnt, prevBtn, imageFileList, lblPanel,lblImage, PostList, lblLoc, lblCom, lblDateTime);
			 
			}
		});
		prevBtn.setBounds(38, 20, 86, 45);
		lblPanel.add(prevBtn);
		//						prevBtn.setOpaque(false);
		// prevBtn을 lblImage 위로 올리는 코드 추가 <-  JLabel이 버튼 위에 그려져서 버튼이 보이지 않음. 
		lblPanel.setComponentZOrder(prevBtn, 0);
		prevBtn.setBorderPainted(false);
		prevBtn.setBackground(Color.BLACK);
		prevBtn.setForeground(Color.WHITE);
		prevBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
		prevBtn.setBorderPainted(false);

		
		
		JButton nextBtn = new JButton(">");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cnt = cntUp(e,cnt, nextBtn, imageFileList, lblPanel,lblImage, PostList,  lblLoc, lblCom, lblDateTime);
			}
		});
		nextBtn.setBounds(484, 20, 86, 45);
		lblPanel.add(nextBtn);
		lblPanel.setComponentZOrder(nextBtn, 0);
		nextBtn.setBorderPainted(false);
		nextBtn.setBackground(Color.BLACK);
		nextBtn.setForeground(Color.WHITE);
		nextBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
		nextBtn.setBorderPainted(false);
		frame.setVisible(true);

	}




	private PhotoViewer(LocalDate selectedDate, CalendarMain app, JPanel monthPanel, JButton clickedButton, int clickedIndex, YearMonth yearMonth ){
		this.app = app;
		this.selectedDate = selectedDate;
		this.monthPanel = monthPanel;
		this.clickedButton = clickedButton;
		this.clickedIndex = clickedIndex;
		this.yearMonth = yearMonth;
		this.imageFileList = getImageFileList(PATH);     // "./images/"
		initialize();
	}

	//	public PhotoViewer() {}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setTitle("Photo Viewer");

		int x = 100;
		int y = 100;
		if (app != null) {
			x = app.getX();
			y = app.getY();
		}
		setBounds(x, y, 600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblPanel = new JPanel();
		lblPanel.setBounds(0, 0, 600, 800);
		lblPanel.setBackground(new Color(0, 0, 0)); // rgb...
		contentPane.add(lblPanel);
		lblPanel.setLayout(null);

		prevBtn = new JButton("<");
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt = cntUpdate(e, cnt);
			}
		});
		prevBtn.setBounds(38, 20, 86, 45);
		lblPanel.add(prevBtn);
		//				prevbtn.setOpaque(false);
		prevBtn.setBorderPainted(false);
		prevBtn.setBackground(Color.BLACK);
		prevBtn.setForeground(Color.WHITE);
		prevBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
		prevBtn.setBorderPainted(false);

		nextBtn = new JButton(">");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt = cntUpdate(e, cnt);
			}
		});
		nextBtn.setForeground(Color.WHITE);
		nextBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
		nextBtn.setBorderPainted(false);
		nextBtn.setBackground(Color.BLACK);
		nextBtn.setBounds(484, 20, 86, 45);
		lblPanel.add(nextBtn);

		lblLoc = new JLabel("");
		lblLoc.setForeground(Color.WHITE);
		lblLoc.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblLoc.setBounds(466, 164, 176, 39);
		lblLoc.setText(PostList.get(cnt).getLocation());
		lblPanel.add(lblLoc);

		lblDateTime = new JLabel("");
		lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblDateTime.setBounds(110, 23, 395, 39);
		lblDateTime.setText(PostList.get(cnt).getDateTime().toString());	  
		lblPanel.add(lblDateTime);

		lblCom = new JLabel("");
		lblCom.setForeground(Color.WHITE);
		lblCom.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCom.setBounds(110, 553, 532, 31);
		lblCom.setText(PostList.get(cnt).getComment());
		lblPanel.add(lblCom);



		if (imageFileList.size() != 0 ) {
			showPhotoViewer(selectedDate, imageFileList);
		}

		app.setThumbnail(clickedButton, PATH + selectedDate+ "_1.JPG", monthPanel, clickedIndex, yearMonth, selectedDate, imageFileList, PostList);

		//		} else {
		//			JOptionPane.showMessageDialog(app, "저장된 사진이 없습니다");
		//		}
	}

	public void showPhotoViewer(LocalDate date, List<String> imageFileList) {
		//		this.selectedDate = date;

		ImageIcon img = new ImageIcon(PATH + imageFileList.get(cnt));
		Image image = img.getImage();
		Image resizedImg = image.getScaledInstance(lblPanel.getWidth(), lblPanel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImg);
		lblImage = new JLabel(resizedIcon);
		lblImage.setBounds(0, 0, 600, 800);
		// JLabel: 기본적으로 크기가 지정되어 있지 않아 이미지를 표시 불가능. lblImage의 크기를 지정해 주어야 함. 
		lblPanel.add(lblImage);

		//		app.setThumbnail(clickedButton, PATH + selectedDate+ "_1.JPG", monthPanel, clickedIndex, yearMonth, selectedDate);

		System.out.println("photoviewer = " + clickedIndex);
		System.out.println("photoviewer  " + PATH + selectedDate+ "_1.JPG");

		//		// 새로운 버튼을 클릭한 경우, 해당 일자에 저장된 이미지 파일들을 다시 로딩
		//		if (selectedDate != date) {
		//			selectedDate = date;
		//			this.imageFileList = getImageFileList(PATH + date.toString() + "/");
		//		}
	}


	private List<String> getImageFileList(String path) {
		
		PostList = dao.readByImageName(selectedDate.toString());
		imageFileList = new ArrayList<>(); //ArrayList 객체 생성

		File imagesDir = new File(path); //"images"폴더를 관리할 File 객체 생성

		File[] files = imagesDir.listFiles(); //폴더가 가지고 있는 파일들을 File 타입의 배열로 리턴

		for (File file : files) {
			if (file.isFile()) { //파일이 존재할 경우
				if(file.getName().contains(selectedDate.toString())) {
					System.out.println("바보");
					imageFileList.add(file.getName()); //ArrayList에 파일 이름을 저장
					Collections.sort(imageFileList);
				}
			}
		}
		return imageFileList; //ArrayList 리턴 
	}
	
	

	private int cntUpdate(ActionEvent e, int cnt) {
		Object source = e.getSource();

		if (source == prevBtn) {

			cnt--;
			if (cnt < 0) {
				cnt = imageFileList.size() - 1;
			}
		} else if (source == nextBtn) {
			cnt++;
			if (cnt > imageFileList.size() - 1) {
				cnt = 0;
			}
		}

		// 이미지 업데이트
		ImageIcon img = new ImageIcon(PATH + imageFileList.get(cnt));
		Image resizedImg = img.getImage().getScaledInstance(lblPanel.getWidth(), lblPanel.getHeight(), Image.SCALE_SMOOTH);
		img = new ImageIcon(resizedImg);
		lblImage.setIcon(img);		
		lblLoc.setText(PostList.get(cnt).getLocation());
		lblCom.setText(PostList.get(cnt).getComment());
		lblDateTime.setText(PostList.get(cnt).getDateTime().toString());	  

		
		
		
		
		
		
		return cnt; 
	}

	private static int cntUp(ActionEvent e, int cnt, JButton nextBtn, List<String> imageFileList, JPanel lblPanel, JLabel lblImage, List<Post> PostList, JLabel lblLoc, JLabel lblCom, JLabel lblDateTime ) {
		Object source = e.getSource();

		if (source == nextBtn) {
			cnt++;
			if (cnt > imageFileList.size() - 1) {
				cnt = 0;
			}
		}

		// 이미지 업데이트
		ImageIcon img = new ImageIcon(PATH + imageFileList.get(cnt));
		Image resizedImg = img.getImage().getScaledInstance(lblPanel.getWidth(), lblPanel.getHeight(), Image.SCALE_SMOOTH);
		img = new ImageIcon(resizedImg);
		lblImage.setIcon(img);
		lblLoc.setText(PostList.get(cnt).getLocation());
		lblCom.setText(PostList.get(cnt).getComment());
		lblDateTime.setText(PostList.get(cnt).getDateTime().toString());	  
		
		return cnt; 
	}

	private static int cntDown(ActionEvent e, int cnt, JButton prevBtn, List<String> imageFileList, JPanel lblPanel, JLabel lblImage, List<Post> PostList, JLabel lblLoc, JLabel lblCom, JLabel lblDateTime) {
		Object source = e.getSource();

		if (source == prevBtn) {

			cnt--;
			if (cnt < 0) {
				cnt = imageFileList.size() - 1;
			}
		} 

		// 이미지 업데이트
		ImageIcon img = new ImageIcon(PATH + imageFileList.get(cnt));
		Image resizedImg = img.getImage().getScaledInstance(lblPanel.getWidth(), lblPanel.getHeight(), Image.SCALE_SMOOTH);
		img = new ImageIcon(resizedImg);
		lblImage.setIcon(img);
		lblLoc.setText(PostList.get(cnt).getLocation());
		lblCom.setText(PostList.get(cnt).getComment());
		lblDateTime.setText(PostList.get(cnt).getDateTime().toString());	 
		return cnt; 
	}


}






