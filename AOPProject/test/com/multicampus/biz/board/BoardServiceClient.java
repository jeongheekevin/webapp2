package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("springConfig.xml");
		
		// 2. �����̳ʷκ��� �׽�Ʈ�� ��ü�� Lookup�Ѵ�.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		if(boardService != null) {
			System.out.println("Lookup ���� : " + boardService.toString());
		}
		
		// 3. �˻��� ��ü�� �޼ҵ� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setSeq(10);
		vo.setTitle("�׽�Ʈ ����");
		vo.setWriter("�׽���");
		vo.setContent("�׽�Ʈ ����................");
		boardService.insertBoard(vo);
		
		vo.setTitle("[���� ����]");
		vo.setContent("[���� ����..........]");
		vo.setSeq(1);
//		boardService.updateBoard(vo);
		
//		boardService.deleteBoard(vo);
		
//		List<BoardVO> boardList = boardService.getBoardList(vo);
//		for (BoardVO board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
	}
}





