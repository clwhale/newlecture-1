package collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// import poly.Exam;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Exam exam = new Exam();
//		Object x = 3;
//		Object[] list = new Object[10];
//		list[0] = 3;
//		list[1]  = exam;
//		System.out.println(((Exam)list[1]).total());
//		
//		List list = new ArrayList();	
		
		// Set : 중복을 제거하는 Collection
		Set<Integer> set = new HashSet<>();
		
		set.add(3);
		set.add(3);
		set.add(3);
		set.add(3);
		set.size();
		
		for (int obj : set) {
			System.out.println(obj);
		}

		// List : 순서가 key가 되는 Collection
		List list = new ArrayList();

		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		list.add(3);
		
		list.get(2);
		for(Object n : list)
			System.out.println(n);

		// Map 계열
		Map<String, Integer> map = new HashMap<>();
		// 사용자 정의된 키를 가지는 Collection
		map.put("kor",3);
		map.put("eng",3);
		map.put("math",3);
		
		map.get("kor");
		
		for(Object k : map.keySet())
			System.out.println(k);
		
		for(Object v : map.values())
			System.out.println(v);
		
		Map<String, Object> note = new HashMap<>();
		note.put("id", 1);
		note.put("title", "hello");
		note.put("hit", 20);
		
		List<Map<String, Object>> noteList = new ArrayList<>();
		noteList.add(note);
		
//		
////		GList list = new GList ();
//		list.add(exam);
//		list.add(exam);
//		list.add(exam);
//		list.add(exam);
//		list.add(exam);
////		list.remove(exam);
//		list.add(3);
//		list.get(0);
//		list.get(1);
//		
//		int size = list.size();
//		
//		for (int i = 0; i < size; i++) {
//			System.out.println(((Exam)list.get(i)).total());
//		}
//		
//		
	}

}
