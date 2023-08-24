package edu.java.inheritance01;

// 스마트TV는 TV이다. 스마트 TV는 기본TV를 확장한다. 
public class SmartTv extends BasicTv { // 3인칭주어 -> 동사원형 + s 
	private String ip;
	
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	public void printInfo() {
		super.printInfo();
		System.out.printf("ip = %s%n", this.ip);
	}

}
  