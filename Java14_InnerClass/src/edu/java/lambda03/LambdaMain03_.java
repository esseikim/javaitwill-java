package edu.java.lambda03;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
/* 쌤 코드
 * argument로 employees의 원소를 넘겨줌 
 * forEach의 역할: employees를 각각 프린트 문에 넘겨줌
 * equals(): 완전히 같은지, contains(): 포함되는지
 */
public class LambdaMain03_ {

	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList(
				new Employee(100, "이찬희", "개발1팀", "대리", 400.0),
				new Employee(101, "지대한", "개발2팀", "사원", 350.0),
				new Employee(200, "김다훈", "개발2팀", "과장", 380.0),
				new Employee(201, "유다한", "개발1팀", "부장", 500.0),
				new Employee(300, "강효남", "인사팀", "사원", 300.0),
				new Employee(301, "위태욱", "인사팀", "과장", 1000.0)
				);

		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
		System.out.println("----- Ex1.");
		//   ( 1.)  향상된 for문 이용
		//        for (Employee e : employees) {
		//            System.out.println(e);
		//        }
		//   ( 2.) employees.forEach(x -> System.out.println(x));
		// argument로 employees의 원소를 print문에 하나씩 넘겨줌.  forEach: for 문의 역할

		employees.forEach(System.out::println);
		/*  ( 3.) 메서드 참조 문법.
		 * numbers.forEach( x -> System.out.print( x + " ")); // Integer를 아규먼트로 갖는 어떤 함수를 만들어라. Consumer<? super Integer> action
		 * 하나씩 넘어온 argument를 println의 argument로 직접 전달하겠다. System.out.println(x)
		 * 콜론 두개 :: 가지고 있다를 뜻함. 변경없이 그대로 전달하는 경우. 
		 * 필터링된 결과를 println의 결과로 보내버려라! println의 argument로 그대로 보내버리겠다.   
		 */   


		// 2. 개발1,2팀에서 일하는 직원들의 급여의 합계를 출력.
		System.out.println("----- Ex2.");  
		/* x가 map? 하나씩 뽑아오니깐 Employee 타입의 리스트 원소 아닌가요? 뭐든 argument는 1개만 있으면 됨. 
		 * map(): 스트림에서 요소를 변환하는 중간 연산 중 하나.
		 * 스트림의 각 요소에 대해 지정된 함수를 적용하고, 새로운 요소로 매핑. 그리고 이에 따라 새로운 스트림을 생성.
		 * 	.mapToDouble(e -> e.getSalary()) 
				Employee를 아규먼트로 갖는 어떤 함수를 만들어라. 리턴타입: DoubleStream
		 * 
		 * map 메서드의 argument :
		 * 파라미터가 1개이고, 리턴 값이 있는(void가 아닌) FunctionalInterface 객체. 
		 * 무조건 리턴값만 있으면 됨. 리턴값이 어떤 타입인지는 상관x 
		 * FunctionalInterface 객체를 전달. == 인터페이스의 추상메서드(1개 뿐)를 구현하는 익명 클래스의 객체를 생성
		 * 
		 */        
		double result = employees.stream()
				.filter(x -> x.getDept().contains("개발")) 
				//  contains() 활용 - 문자열 "개발"을 포함하는 경우, equals() 사용보다 코드 간결
				.mapToDouble(x -> x.getSalary()) // 리턴타입: DoubleStream 
				.sum();
		System.out.println("개발팀 급여 합계 = " + result);



		double sum = 0;
		int count = 0;
		for (Employee e : employees) {  
			if (e.getDept().contains("개발")) {
				sum += e.getSalary();
				count++;
			}
		}
		System.out.println("개발팀 급여 합계 = " + sum);


		// 3. 개발1,2팀에서 일하는 직원들의 급여의 평균을 출력.
		System.out.println("----- Ex3.");
		System.out.println("개발팀 급여 평균 = " + (sum / count));



		result = employees.stream()
				.filter(e -> e.getDept().contains("개발"))
				.mapToDouble(e -> e.getSalary()) 
				// Employee를 아규먼트로 갖는 어떤 함수를 만들어라. 리턴타입: DoubleStream
				.average()
				.orElseThrow();
		System.out.println("개발팀 급여 평균 = " + result);

		// 4. 직급이 사원인 직원들의 급여의 합계를 출력.
		System.out.println("----- Ex4.");
		result = employees.stream()
				.filter(e -> e.getEmpTitle().equals("사원"))
				.mapToDouble(e -> e.getSalary())
				.sum();
		System.out.println("사원 급여 합계 = " + result);

		// 5. 직급이 사원인 직원들의 급여의 평균을 출력.
		System.out.println("----- Ex5.");
		result = employees.stream()
				.filter(e -> e.getEmpTitle().equals("사원"))  // 직원에서 Salary만 뽑음.
				.mapToDouble(e -> e.getSalary())  // 직원을 월급으로 매핑시킴. 직원을 double 타입으로 매핑시키겠다. .mapToDouble() 
				.average()
				.orElseThrow();
		System.out.println("사원 급여 평균 = " + result);

		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
		System.out.println("----- Ex6.");
		employees.stream()
		.filter(e -> e.getSalary() >= 400)
		.forEach(System.out::println); // x -> System.out.println(x)

		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력.
		System.out.println("----- Ex7.");
		result = employees.stream()
				.filter(e -> e.getDept().equals("개발1팀")) // 해당 문자열 들어가있는 지 필터링. 위에서와는 다르게 콕 집어줬음.
				.mapToDouble(e -> e.getSalary() * 1.1)
				/* 
				 *  mapToDouble() : double 타입으로 mapping -> 리턴값을 double타입으로 맞춰줘야 함. 그게 * 1.1 곱한 거(return). ㄴㄴ salary 그자체.                
				 *  sum()과는 다름. sum() 메서드를 호출 시 바로 double 리턴.
				 *  but average는 바로 평균 계산 못하고 선택적인 더블 타입임. 
				 *  조건을 만족하지 못하면 계산해줄 게 없음. sum()의 경우 만족하는 조건이 없으면 sum은 0임 .
				 *  평균은 0으로 나누기하면 안 됨.(NumberFormatException 발생) 
				 *  -> OptionalDouble average : 선택적인 더블이다. 
				 *  원소가 1개 이상 있으면 정상적으로 평균을 계산해서 리턴. 
				 *  그렇지 않으면 뭔가 객체가 있다~ 하면서 객체를 리턴. 
				 *  즉,  .average(): 계산할 수 있으면 계산하고 
				 *  orElseThrow() : exception 던져버려라!
				 */ 
				.average()
				.orElseThrow();
		System.out.println("개발1팀 인상 급여 평균 = " + result);

		
		// 8. 직원 리스트에서 "사원"은 몇 명?
		System.out.println("—— Ex8.");
		long cnt = employees.stream()
				.filter(e -> e.getEmpTitle().equals("사원"))
				.count(); // 그 결과만 카운트 해주면 됨. 리턴 - long 타입 -> 변수를 long 타입으로. 
		System.out.println("사원 직급 수 = " + cnt);

	}

}