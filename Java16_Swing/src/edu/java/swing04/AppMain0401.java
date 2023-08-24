package edu.java.swing04;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;


//label = new JLabel("이미지를 보려면 아래 버튼을 누르세요.");
	//button = new JButton("이미지 레이블");
	//ImageIcon icon = new ImageIcon("dog.png")

public class AppMain0401 {
	JFrame frame;
	private JLabel images; 
	private ArrayList<String>  imageFileList;
	private int curIndex;
	
	public AppMain0401() {

	}
	public void makeDirectory() {
		File f = new File();
	}
	
	private void showPrevImage() {
		for(String s :imageFileList) {
			s.setIcon(new ImageIcon()); 
			
		}
	}
	
	private ArrayList<String> getImageFileList(String path) {
	      imageFileList = new ArrayList<>(); //ArrayList 객체 생성

	      File imagesDir = new File(path); //"images"폴더를 관리할 File 객체 생성

	      File[] files = imagesDir.listFiles(); //폴더가 가지고 있는 파일들을 File 타입의 배열로 리턴

	      for (File file : files) {
	         if (file.isFile()) { //파일이 존재할 경우
	            imageFileList.add(file.getName()); //ArrayList에 파일 이름을 저장
	         }
	      }

	      return imageFileList; //ArrayList 리턴
	   }
	
	
	public static void main(String[] args) {
		
		

	}
}
