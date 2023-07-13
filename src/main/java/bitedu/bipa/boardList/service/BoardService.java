package bitedu.bipa.boardList.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.boardList.dao.BoardDAO;
import bitedu.bipa.boardList.vo.BoardVO;

@Service("BoardService")
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	//search list all
	public ArrayList<BoardVO> searchAll(){
		ArrayList<BoardVO> list = dao.searchAll();
		return list;
	}
	
	public boolean deleteBoard(String no) {
		boolean flag = false;
		flag = dao.delete(Integer.parseInt(no));
		return flag;
	}
	
	public BoardVO select(String boardNo) {
		BoardVO board = new BoardVO();
		board = dao.select(Integer.parseInt(boardNo));
		return board;
	}

}
