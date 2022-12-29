package book.controller;

import java.util.ArrayList;
import java.util.Scanner;

import book.view.BookView;
import book.vo.BookDAO;
import book.vo.BookVO;

public class BookController {
	public static final int CONTINUE = 1;
	public static final int BREAK = 0;
	
//	여러 도서 정보(동적 인원수)를 입력 받기 위해서 ArrayList 객체 생성
	ArrayList<Integer> isbns = new ArrayList<Integer>();
	ArrayList<String> bookNames = new ArrayList<String>();
	ArrayList<String> publishes = new ArrayList<String>();
	ArrayList<String> authors = new ArrayList<String>();
	ArrayList<Integer> prices = new ArrayList<Integer>();
	ArrayList<String> categories = new ArrayList<String>();
	
//	콘솔창에서 입력받은 도서정보를 사용하여 각각의 ArrayList에 저장해 둔다.
	public void consoleToList() {
//		콘솔에 입력 받기 위해 Scanner 생성
		Scanner s1 = new Scanner(System.in); // 문자열입력용
		Scanner s2 = new Scanner(System.in); // 숫자입력용
		
//		flag변수:콘솔창에서 도서정보를 입력 받을 때 계속 입력받을 것인지 멈출것인지의 
//		상태를 저장하는 변수
		int flag = CONTINUE;
		System.out.println("************* 도서 정보 입력 *************");
		while(true) {
			if(flag == CONTINUE) {
				System.out.print("** 도서번호입력: ");
				isbns.add(s2.nextInt());
				System.out.print("** 도서명입력: ");
				bookNames.add(s1.nextLine());
				System.out.print("** 출판사입력: ");
				publishes.add(s1.nextLine());
				System.out.print("** 저자명입력: ");
				authors.add(s1.nextLine());
				System.out.print("** 가격입력: ");
				prices.add(s2.nextInt());
				System.out.print("** 분류명입력: ");
				categories.add(s1.nextLine());
			}else if(flag == BREAK) {
				break;
			}
			System.out.print("계속 도서정보를 입력받으시겠습니까?(계속: 1, 중지: 0): ");
			flag = s2.nextInt();
		}
		
		s1.close();
		s2.close();
	}
//	BookVO객체를 생성하고
//	생성된 BookVO객체를 BookDAO 객체의 ArrayList에 저장한다.(insert()사용)
	public void voToDAO(BookDAO dao) {
		
		for (int i = 0; i < isbns.size(); i++) {
			BookVO svo = new BookVO(isbns.get(i), bookNames.get(i), publishes.get(i), authors.get(i), prices.get(i), categories.get(i));
			dao.insert(svo);
		}
	}
	

	public static void main(String[] args) {
		BookController controller = new BookController();
//		콘솔창에서 입력 받은 값을 각각의 정보를 저장하는 ArrayList에 저장하는 메소드
		controller.consoleToList();
//		입력받은 값들을 사용하여 BookVO객체를 생성하여 DAO의 ArrayList에 저장하는 메소드
		BookDAO dao = new BookDAO();
		controller.voToDAO(dao);
//		화면에 출력
		BookView sView = new BookView();
		sView.view(dao.select());
	}

}
