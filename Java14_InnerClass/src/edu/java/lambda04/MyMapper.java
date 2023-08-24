package edu.java.lambda04;

@FunctionalInterface
public interface MyMapper { // 무엇인가를 전달받아서 또다른 무엇으로 변환만 해주면 됨. <= Mapper
	Object transform(Object x);
}
