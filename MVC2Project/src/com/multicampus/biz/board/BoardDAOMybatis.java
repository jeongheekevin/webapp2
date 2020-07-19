package com.multicampus.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class BoardDAOMybatis implements BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� insertBoard() ��� ó��");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� deleteBoard() ��� ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis ������� getBoard() ��� ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println(vo.getSearchCondition());
		System.out.println(vo.getSearchKeyword());
		System.out.println("===> MyBatis ������� getBoardList() ��� ó��");
		return (List<BoardVO>) mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}







