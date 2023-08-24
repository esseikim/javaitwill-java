package edu.java.post.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {

	public interface Entity {
		String TBL_NAME = "POSTS";
		String COL_COMMENT = "COMMENTS";
		String COL_LOCATION = "LOCATION";
		String COL_POSTDATE = "POSTDATE";
		String COL_IMAGENAME = "IMAGENAME";
	}

	// field
	private LocalDateTime dateTime;
	private String comment; // 코멘트 내용
	private String location;
	private String imageName;

//    String imagePath = "C:\\Images\\image1.png";
//    String comment = "오늘은 맑은 날씨였다.";;
//    String location = "서울";

	// constructor
	public Post(LocalDateTime dateTime, String comment, String location, String imageName) {
		this.dateTime = dateTime;
		this.comment = comment;
		this.location = location;
		this.imageName = imageName;
	}

	// getters && setters
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImagePaht(String imageName) {
		this.imageName = imageName;
	}

	/**
	 * 해당하는 연도의 일 수를 반환
	 * 
	 * @param year
	 * @return
	 */
//    public int getDaysInYear(int year) {
//        return Year.of(year).length();
//    }
//    
//    @Override
//	public String toString() {
//		return String.format("Blog(id =%d, title =%s, content = %s, author = %s, createdTime = %s, modifiedTime = %s%n)",
//				dateTime, comment, location);
//
//    
//    @Override
//    public String toString() {
//        String formattedTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        return "[" + formattedTime + "]\n" + comment + "\n\n";
//    }

}