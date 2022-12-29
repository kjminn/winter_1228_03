package book.vo;

import java.util.ArrayList;

//Data Access Object
public class BookDAO {
//	ArrayList: 학생정보객체(StudentVO)들을 저장하기 위해
	ArrayList<BookVO> bvoList = new ArrayList<BookVO>();

//	insert: ArrayList에 학생정보객체(StudentVO)를 추가하는 메소드
	public void insert(BookVO svo) {
		bvoList.add(svo);
	}
	
//	select: 전체 학생정보객체들을 반환하는 메소드
	public ArrayList<BookVO> select(){
		return bvoList;
	}
	
}
