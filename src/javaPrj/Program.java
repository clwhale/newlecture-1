
package javaPrj;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 추상클래스
		YBMExam exam1 = new YBMExam();
		NewlecExam exam2 = new NewlecExam();
		
		Exam[] exams = new Exam[2];
		exams[0] = exam1;
		exams[1] = exam2;
		
		for(int i=0; i<2; i++) {
			System.out.println(exams[i].total());
			System.out.println(exams[i].toString());
		}
	}

}

