package book.view;

import java.util.ArrayList;

import book.vo.BookVO;

// 화면에 보여주기(출력) 위한 객체
public class BookView {
	
//	view(ArrayList<StudentVO> svoList): 화면에 출력을 위한 메소드
	public void view(ArrayList<BookVO> bvoList) {
		for (BookVO bvo : bvoList) {
			System.out.println("=========================");
			System.out.println("= 도서번호: " + bvo.getIsbn());
			System.out.println("= 도서명: " + bvo.getBookName());
			System.out.println("= 출판사: " + bvo.getPublish());
			System.out.println("= 저자명: " + bvo.getAuthor());
			System.out.println("= 가격: " + bvo.getPrice());
			System.out.println("= 분류명: " + bvo.getCategory());
			System.out.println("-------------------------");
		}
	}
}
