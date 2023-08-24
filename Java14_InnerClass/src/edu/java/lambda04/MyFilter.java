package edu.java.lambda04;
@FunctionalInterface
public interface MyFilter {  // public static final
 
	boolean check(Object x);  // 아무거나 전달받아서 boolean을 리턴받는 함수.
 }
