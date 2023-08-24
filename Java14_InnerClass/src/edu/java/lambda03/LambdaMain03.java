package edu.java.lambda03;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList( // Employee 타입의 List -> Employee 객체 생성해 나열하면 됨. 
				new Employee(100, "이찬희", "개발1팀", "대리", 400.0),
				new Employee(101, "지대한", "개발2팀", "사원", 350.0),
				new Employee(200, "김다훈", "개발2팀", "과장", 380.0),
				new Employee(201, "유다한", "개발1팀", "부장", 500.0),
				new Employee(300, "강효남", "인사팀", "사원", 300.0),
				new Employee(301, "위태욱", "인사팀", "과장", 1000.0)
				);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		for( Employee e : employees) {
			System.out.println(e);
		}
		
		// 2. 개발 1,2팀에서 일하는 직원들의 급여의 합계를 출력.  
		Double sum = 0.0;
		int count = 0;  // ***창민.
		
		for(Employee e: employees) {
			if(e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀")) {
				sum += e.getSalary();
				count++;
			}
		}
		System.out.println("sum = " + sum);
			
		// 3. 개발 1,2팀에서 일하는 직원들의 급여의 평균을 출력.
		Double avg = sum / count;
		System.out.println("avg = " + avg);
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력
		count = 0;  // **** 주의. 초기화 
		for(Employee e : employees) {
			if(e.getDept().equals("사원")) {
				sum += e.getSalary();
				count++;
			}
		}
		System.out.println("sum = " + sum);
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력
		avg = sum / count; // *** 주의 
		System.out.println("avg = " + avg );
		
		// 	6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력
		List <Employee> result = employees.stream()
				.filter(x -> x.getSalary() >= 400.0)  
				.toList();
		System.out.println(result);
				
		// cf) 1000 100원 인상 1100 1000 + 1000/10 
		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력.
	  OptionalDouble average = employees.stream()   
			  .filter( x -> x.getDept().contains("개발1팀")) 
			  .map( x ->  x.getSalary())  
			  .map( x ->  x + (x * (10 / 100))) 
			  // 내 코드: .map((x ->) x.getSalary() -> x + (x  % 10)))  // 하나씩 밖에 안됨!! ㅜ x 로 받아와야??? 일을 두번한 거라 안되나용? 
			  //  .mapToDouble(e -> e.getSalary() * 1.1) 쌤은 위 두줄을 한줄로 출력함. 
			  .mapToDouble(Double::doubleValue)  // 쌤은 이거 없음
			  .average();

//      .average()       쌤 코드
//      .orElseThrow();
	  
	  System.out.println(average);
			  
	  
		
		// 8. 직원 리스트에서 "사원"은 몇 명?
	  long staff = employees.stream()
	  .filter(x -> x.getEmpTitle().equals("사원"))
	  .count();
	  
	  System.out.println("사원 : " + staff + "명");
	  
		
	}

}
