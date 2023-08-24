package edu.java.mvc.controller;


public class PostDaoImpl implements PostDao {   
	private static PostDaoImpl instance = null; 

	private PostDaoImpl() {};

	public static PostDaoImpl getInstance() {
		if (instance ==null) {
			instance = new PostDaoImpl();
		}
		return instance;  //dao가 됨. 
	}

	// fields 
	private static final int MAX_LENGTH = 5; 
	private Post[] post = new Post[MAX_LENGTH]; //  post 애들을 모아서 post 배열을 만드는데..이걸 순수한 데이터 집합에 굳이 만들 필요가 없지. 기능 담당하는 쪽에서 배열을 만들어 저장, 삭제, 수정 등의 기능을 수. 
	private int count = 0; 


	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}

	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < count);  
	}

	@Override
	public int create(Post p) {
		if (isMemoryAvailable()) {  
			post[count] = p;
			count ++;
			return 1;
		}else {
			return 0;
		}
	}


	@Override
	public Post[] read() { // 반환타입: 배열-> 인덱스만 지정해서 줄 수없나? index, count를 이용해 특정 요소값만 내보내면 되지 않을까. 배열 전체를 내보내야하는데, null이 보이는것도.. 있는 걸로 쳐서.. 
		Post[] array = new Post[count]; 
		for (int i =0; i < count; i ++) {
			array[i] = post[i];  
		}
		return array;
	}

	@Override
	public Post read(int index) { // 오버로딩. 
		if (isValidIndex(index)){
			return post[index];
		}else {
			return null;	
		}
	}

	@Override
	public int update(int index, Post post) {
		if(isValidIndex(index)) {
			this.post[index] = post; //
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (!isValidIndex(index)){
			return 0;
		}
		for (int i = index; i < count-1 ; i ++) { 
			post[i] = post[i+1];            
		}
		post[count-1] =null;                            
		count --;
		return 1;
	}
}
