package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("springConfig.xml");
		
		// 2. 컨테이너로부터 테스트할 객체를 Lookup한다.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		if(boardService != null) {
			System.out.println("Lookup 성공 : " + boardService.toString());
		}
		
		// 3. 검색한 객체의 메소드 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(10);
		vo.setTitle("테스트 제목");
		vo.setWriter("테스터");
		vo.setContent("테스트 내용................");
		boardService.insertBoard(vo);
		
		vo.setTitle("[제목 수정]");
		vo.setContent("[내용 수정..........]");
		vo.setSeq(1);
//		boardService.updateBoard(vo);
		
//		boardService.deleteBoard(vo);
		
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		for (BoardVO board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
	}
}





