package edu.java.list01;

import java.util.ArrayList;
import java.util.Iterator;

/*() : if, for, while, 메서드의 생성, 사용
 * {} : 배열을 직접 선언할 때, -> block 생성 (class{}, method{}의 생성 )
 * [] : 인덱스
 * <>: List에서 어떤 타입의 원소를 갖느냐를 나타낼 때
 * 
 * 리스트(인덱스를 가짐)-get메서드 ,    set(인덱스가 없음, get메서드 없음.반복문을 통해서만 확인 가능)
 * Map:    add가 아닌 put, 읽어들임 get, remove
 * 
 *  리스트(list)의 특징: <- collection(추성메서드) 인터페이스를 구현한 추상클래스(전부 구현 x, 일부를 추상메서드로 남겨둠. set도 동일!)
 *  1. 한가지(여러가지 타입 불가<E>) 타입의 값들을 여러개 저장할 수 있는 데이터 구조체. (변수선언, add()로 값 저장-> 갯수 제한 불필요)
 *  2. 값들을 저장하는 순서가 중요 - index를 가지고 있음.
 *  3. 값들을 저장할 때마다 인덱스는 자동으로 증가. - 배열과는 다르게 저장용량이 자동으로 증가.  (index의 값이 Integer의 값을 넘을 수 없기 때문에 제한이 없다! )
 *  4. 중간에 있는 값을 삭제하면 익덱스는 자동으로 재배열됨.
 *  5. 같은 값을 여러번 저장 가능. -> Set과 다른 점. 
 *  
 *  
 *  
 *  ArrayList(list 구현클래스!)의 특징: 서로가 반대다! 
 *  1. 배열(array)을 사용하는 리스트
 *  2. 데이터 저장(add)하거나 삭제(remove)할 때 속도가 느림. - 더 큰 배열 생성, 복사, 삭제도 전부 땡겨와야함. 
 *  3. 데이터를 검색(get)할 때 속도가 빠름. - 인덱스만 알면 됨.(계산해서 가면 됨! 한 칸당 4byte - int의 경우)
 *  
 *  LinkedList(구현클래스)의 특징:
 *  1. linked list 알고리즘을 사용한 리스트. - 서로의 주소값 저장. (자바의 링크드리스트: 양방향)
 *  - 만들고 주소값, 만들고 주소값 - 추가 빠름. 삭제: 지우고 싶으면 주소값 다음 링크꺼의 주소로 바꾸면 됨!
 *  2. 데이터를 저장하고 삭제할 때 속도가 빠름 - 주소값이 연속적으로 있다는 보장이 없음. 계속 메모리의 주소를 찾아가야함. 
 *  3. 데이터를 검색할 때 속도가 느림
 *  
 *  Collection<E>
 *     |_ List<E>
 *           |_ ArrayList<E>, LinkedList<E>(List가 어떤 타입의 원소를 갖는 지 기입해줘야.)
 */
public class ListMain01 {

	public static void main(String[] args) {
		// 문자열을 저장하는 ArrayList 객체를 선언하고 생성. 
		// ArrayList<저장할 원소 타입 : 타입(클래스 이름)> 변수이름 = new ArrayList<>();
		// 생성자 호출에서는 리스트의 원소 타입을 생략해도 됨. 
		ArrayList<String> languages = new ArrayList<>(); 
		/*String을 저장하는 ArrayList , new ArrayList<String>() 생략
		* 이미 선언에서 String만 저장한다 선언. (변수 선언이 되어있을 경우에만 가능) - element
		*/
		
		System.out.println("리스트 크기 : "+ languages.size());   
		// 배열 : length, 길이를 정해두고 하나씩 저장. -> 배열길이 0이면 원소 저장 불가. a[0] =1. 실행 시 오류. 
		// 리스트는 size가 0부터 시작
		System.out.println(languages);
		// 배열: [java.lang.Strin@... , 리스트 : [] <- ArrayList : toString 메서드가 override 되어 있음. for문 불필요. 출력이 굉장히 쉬움. print문에 넣기만 하면 됨. 
		
		
		// 리스트에 원소 추가: boolean add(Object o)  : 객체 저장. 알아서 뒤쪽으로 추가시킴. 
		// 저장할 객체를 주면 그 객체가 ArrayList에 추가됨.  boolean타입.
		// void add(int index, Object element) 저장할 위치 지정가능. 
		// boolean add(int index, Collection c) :컬렉션 가지고 있는 요소 그대로 저장. 위치 지정 가능. 
		languages.add("Java"); 
		languages.add("SQL");
		languages.add("HTML");
		languages.add("Java");  // 인덱스 사용 -> 같은 값 저장해도 ㄱㅊ
		System.out.println("리스트 크기 : "+ languages.size());   
		System.out.println(languages);
		
		// 리스트에서 특정 인덱스 위치(1뿐 - 구라)의 원소 값을 리턴: get(int index);
		System.out.println(languages.get(0)); // 인덱스는 0부터 시작 
		System.out.println(languages.get(1)); 
		for(int i = 0; i < languages.size() ; i ++) {   // size(): 메서드. 변수이름이 아님 -> 괄호 필수
			System.out.print(languages.get(i) +" ");
			
		}
		System.out.println();
		
		// 오버로딩(2가지)
		// remove(Object o) : 리스트에서 "처음" 등장하는 원소를 찾아서 삭제. - 값으로 삭제 <- 처음 Java만!. 리턴: boolean
		// remove(int index) : 리스트에서 인덱스 "위치"에 있는 원소를 삭제. - index로 삭제
		// removeAll(Collection c): 지정해주는 컬렉션의 객체들을 삭제. 
		// void clear() : ArrayList에 저장된 모든 객체 삭제
		System.out.println(languages.remove("Java")); 
		System.out.println(languages);
		
		System.out.println(languages.remove(0)); 
		System.out.println(languages);
		
		
		// 향상된 for 문(for-each): for (변수 선언 : 리스트){반복할 내용}
		
		for(String s : languages) {
			System.out.print(s+" ");
		}
		
		System.out.println();
		
		// Iterator<E> (패턴:) 객체를 사용한 "리스트 원소들" 반복, 리스트 원소들의 타입과 일치<>   <- 반복해주는 기계, 인터페이스 
		// 생성자 직접 호출 x,  객체 생성 메서드 사용! 
		// for-each(값을 위치를 이동하면서 읽음. 값이 없으면 종료. ^->^->^?-자동)를 수동으로 쓰는 게 itorator
		// 항상 첫번째 위치에 iterator 위치함. 
		// while 문 사용! 
		// hasNext: 그 다음 원소를 가졌는 지 물어봄. (boolean)
		// next: 현재위치의 값 리턴, 가리키는 위치를 이동(한칸 이동)하면서 리턴. 
		Iterator<String > itr = languages.iterator(); // iterator 객체 생성.
		while (itr.hasNext()) { 
			System.out.println(itr.next());
		}
		
		
		
		// remove(); : 삭제-> 특정위치(index) 객체 삭제  /  컬랙션 지정하면 컬렉션 객체(sub)들을 삭제 / all : 모든 객체 삭제
		// ArrayList ();  기본생성자 
		// ArrayList(Collcetion c) : 매개변수로 컬렉션 주면, 컬렉션의 요소를 저장하는 ArrayList를 만들 수 있음. (컬렉션들끼리 변환할 때.)
		// ArrayList(int initialCapacity) :  
		// 배열의 길이를 불러줌. 배열의 길이 변경 불가. 만들 때 저장하려는 객체의 갯수만큼 배열의 길이를 지정 - 추가 삭제 넉넉하게!
		// 처음에 ArrayList가 사용할 배열의 길이를 적절히 저장하는 게 중요! 공간 부족할 때 마다 생성, 복사의 과정을 거쳐야함 
	
		
		// int indexOf : 검색. 맨 앞부터 객체가 몇번 째? -1, 
		// int lastindexOf : 오른쪽 끝에서부터
		// contains() 객체 존재여부. boolean. 일부를 ?? 전체도 맞을 듯..? chatgpt 물어보기
		// get() 특정 위치에 있는 객체 반환. 객체 읽기
		// set() 특정 위치에 있는 객체 변경. 
		// subList : 새로운 list를 만듦( , )
		// toArray() : ArrayList의 객체배열을 반환 
		// isEmpty() : 비어있는지
		// trimTosize() : 빈공간 제거
		// size() : ArrayList에 저장된 객체의 갯수 반환 
	
		
		
		
		

	}

}
