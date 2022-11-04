package collect;

// import poly.Exam;

public class GList<U> {
	
	private U[] data;
	private int index;
	private int max;
	
	public GList(){
		index = 0;
		max = 3;
		data = (U[])new Object[max];
	}
	
	U get(int i){
		return data[i];
	}
	
	int size(){
		return index;
	}
	public void add(U obj) {
		// 배열이 꽉 찬 경우
		if (index <= max) {
			U[] newArr = (U[]) new Object[max+3];
			for (int i = 0; i < data.length; i++) {
				newArr[i] = data[i];
			}
			data = newArr;
			max += 3;
		}
		data[index] = obj;
		System.out.println(data[index].toString() + ": index : " + index);
		index++;
	}
	public void remove(U exam) {
		
	}
}
