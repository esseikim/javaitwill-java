package edu.java.map01;

import java.util.HashMap;
import java.util.Set;

/*  E: 어떤 타입의 원소를 갖는다. 원소 명시해줘야 함. 
* 
* Collection<E>
*     |_ List<E>                                              |_  Set<E>
*           |_ ArrayList<E>, LinkedList<E>, ..              |_  HashSet<E>, TreeSet<E>
*  (저장 삭제 느림, 검색 빠름          저장, 삭제 빠름, 검색 느림)                 (검색         정렬)
*  
*   List, Set의 공통점: 한가지 타입의 객체들을 여러개 저장할 수 있는 데이터 타입. 원소의 타입만 알면 됨. 
*   *****   [ , ] 사용해 원소나열, 출력
*   
*   List : 인덱스 있음. 저장순서 중요(add 호출할 때마다 인덱스 자동 증가). 중복 허용
*   Set : 인덱스 없음. 중복된 값을 저장할 수 없음.         
*   
*    Object로 선언하면 key값으로 어떤 타입이든 사용 가능.
*   ******HashMap<Objet, ArrayList<Object>> m ;
*   
*   Map<K, V>  // K, V : 데이터 타입이 뭐냐.  Object로 선언하면 key값으로 어떤 타입이든 사용 가능.
*    |_ HashMap<K, V>, TreeMap<K, V>
*    
*    Map: 키(key)와 값(value)의 쌍으로 구성된 데이터를 저장하는 데이터 타입.
*    (1) Key: 중복된 값을 가질 수 없음. 연속된 값을 가질 필요는 없음. 
*        - (List에서의 index: 연속된 값.) 중복되지만 않으면 연속되지 않아도 됨. 값을 찾을 수 있기만 하면 됨. 
*        -  리스트에서 "인덱스"의 역할을 함(데이터 저장/검색/수정/삭제할 때 값을 찾기위한 용도).
*         
*    (2) Value : 중복된 값을 가질 수 있음. 
*    
*    (3) HashMap : 검색을 빠르게 할 수 있는 Map. 
*    (4) TreeMap : 정렬을 빠르게 할 수 있는 Map.
*    
*    ***** Map: {k:v, k:v, k:v,..}
*    
*/

public class MapMain01 { 
	// ***** put(저장, 변경), remove(삭제), get(읽기) // 전체읽기 : keySet() :키를 다 읽어와야함! (중복x, 순서x)

	public static void main(String[] args) {
		// 정수를 key로 하고, 문자열을 Value로 하는 HashMap 변수 선언, 초기화 
		
	HashMap<Integer, String> students = new HashMap<>();
	
	// put(key, value): Map에 key-value 쌍의 데이터를 저장. -> key, value 합해서 하나의 element가 됨! 
	students.put(1, "강효남");
	students.put(2, "김다훈");
	students.put(3, "김도현");
	students.put(20, "김다훈");  // 저장됨. value값 중복은 허용. 
	
	System.out.println("map size = "+ students.size()); 
	System.out.println(students); 
	
	// get(key): 해당 key에 해당하는 value를 리턴. key에 매핑된 value가 없으면 null을 리턴. 
	System.out.println(students.get(3));
	System.out.println(students.get(10));  // null
	// 키에 매핑된(해당하는) value 있으면 리턴, 없으면 null을 리턴
                               
	
	// getOrDefault(key, defaultValue): 절대로 null이 나올 수 없게끔 함. 
	// key에 매핑된 value를 리턴. key에 매핑된 value가 없으면 defaultValue를 리턴. 
	System.out.println(students.getOrDefault(3, "무명씨"));  // defalut 값 무시
	System.out.println(students.getOrDefault(10, "무명씨"));  // value 찾을 수 없어, 두번째 argument로 넘긴 defualt를 argument로 넘겨줌. 
	
	// remove(key): key에 매핑된 key-value 원소를 삭제. 삭제할 땐 key로 삭제, 지울 수 있는게 없으면 null 리턴 -> 에러 x
	// key가 없는 경우일수도, key에 매핑된 값 자체가 null일 수도. 
	students.remove(20);
	System.out.println("map size = "+ students.size());
	System.out.println(students);
	
	// 변경 메서드 따로 없음(set X). put이 저장도, 변경도 가능
	// put(key, value):
	// (1) Map에 key가 존재하지 않으면 key-value 데이터를 저장.
	// (2) Map에 key가 존재하면, key에 매핑된 값을 변경.
	students.put(3, "KIM Dohyun");
	System.out.println(students);
	
	
	
	/* Map에서 향상된 for문 : key를 먼저 찾아야 함(index), key: 한가지 타입의 값들을 여러개 저장 가능, 중복x <- set과 동일
	 * Map에서 key를 가져오면 key는 set이 된다. 모든 Map은 keySet();을 가지고 있다. 
	 * <- 리턴타입 : set,      index-> Integer 타입! 
	 */
	Set<Integer> keyset = students.keySet(); 
	// (1) Map의 key들로만 이루어진 Set으로 만듦. <- keyset
	for(Integer i : keyset) {  
		// (2) key들을 처음부터 끝까지 순회하면서 
		System.out.println(i + ":" + students.get(i));  
		// key에 매핑된 value를 찾음 
		// key 옆에 value값 구하기: get 메서드로 읽어오면 됨.
	}
	
	 
	
	}

}
