package edu.java.post.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.post.controller.PostDaoImpl;
import edu.java.post.model.Post;

public class PhotoUploader extends JFrame {

	private final PostDaoImpl dao = PostDaoImpl.getInstance();
	private JPanel contentPane;
	private CalendarMain app;
	private JTextField textFileName;
	private JTextField textlLocation;
	private JTextField textComment;

	/**
	 * Launch the application.
	 */
	public static void showPhotoUploader(CalendarMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhotoUploader frame = new PhotoUploader(app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PhotoUploader(CalendarMain app) { // 생성자 void 금지… 메서드랑 헷갈리지 않기.
		// this.parent = mainPanel;
		this.app = app;
		initialize();
	}

	private void initialize() {
		setTitle("사진 저장");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;

		if (app != null) {
			x = app.getX();
			y = app.getY();
		}
		setBounds(x, y, 470, 307);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textFileName = new JTextField();
		textFileName.setBounds(24, 44, 388, 36);
		panel.add(textFileName);
		textFileName.setColumns(10);

		JLabel lblFname = new JLabel("파일명 포맷을 입력하세요. 예) yyyy-MM-dd_number");
		lblFname.setBackground(new Color(0, 0, 0));
		lblFname.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblFname.setForeground(new Color(255, 0, 0));
		lblFname.setBounds(24, 10, 400, 33);
		panel.add(lblFname);

		JLabel lblLoc = new JLabel("- Location :");
		lblLoc.setForeground(new Color(255, 255, 255));
		lblLoc.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblLoc.setBounds(24, 94, 108, 33);
		panel.add(lblLoc);

		JLabel lblCom = new JLabel(" - Comment :");
		lblCom.setForeground(new Color(255, 255, 255));
		lblCom.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblCom.setBounds(12, 153, 161, 33);
		panel.add(lblCom);

		textlLocation = new JTextField();
		textlLocation.setColumns(10);
		textlLocation.setBounds(148, 97, 264, 33);
		panel.add(textlLocation);

		textComment = new JTextField();
		textComment.setColumns(10);
		textComment.setBounds(148, 153, 264, 33);
		panel.add(textComment);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add Image");
		btnAdd.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		btnAdd.setForeground(new Color(163, 92, 159));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePost();
			}
		});
		btnAdd.setBackground(new Color(255, 255, 255));
		panel_1.add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(163, 92, 159));
		btnCancel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		btnCancel.setBackground(Color.WHITE);
		panel_1.add(btnCancel);

	}

	private void UpdatePost() {
		String location = textlLocation.getText();
		String comment = textComment.getText();
		String imagePath = textFileName.getText();
		LocalDateTime dateTime = LocalDateTime.now();

		Post post = new Post(dateTime, comment, location, imagePath);

		dao.create(post);

		app.notifyInfo();

		dispose();
	}
}
