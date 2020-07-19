package com.multicampus.controller.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardListVO;
import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/transfer.do")
	@ResponseBody
	public List<BoardVO> transfer(BoardVO vo) {
		vo.setSearchCondition("T");
		vo.setSearchKeyword("");
		return boardService.getBoardList(vo);
	}
	
/*	@RequestMapping("/transfer.do")
	@ResponseBody
	public BoardListVO transfer(BoardVO vo, BoardListVO listVO) {
		vo.setSearchCondition("T");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		listVO.setBoardList(boardList);
		return listVO;
	}*/
	

	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoardView(@ModelAttribute("board") BoardVO vo) throws Exception {
		vo.setTitle("10���� �̻� ����");
		vo.setWriter("�׽�Ʈ");
		vo.setContent("2000���� �̸��� ����");
		return "insertBoard";
	}	
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws Exception {
		// ���� ���ε� ��� �߰�
		MultipartFile uploadFile = vo.getUploardFile();
		if(!uploadFile.isEmpty())
			uploadFile.transferTo(new File("C:/DEV/" + uploadFile.getOriginalFilename()));
		
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard";		
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		// Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("T"); 
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}

}
















