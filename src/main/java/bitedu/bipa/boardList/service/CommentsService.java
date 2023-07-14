package bitedu.bipa.boardList.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitedu.bipa.boardList.dao.CommentsDAO;
import bitedu.bipa.boardList.vo.CommentsVo;


@Service
public class CommentsService {
	
	@Autowired
	private CommentsDAO dao;
	
	//댓글조회
	public ArrayList<CommentsVo> findByBoard(int boardNo){
		ArrayList<CommentsVo> list = dao.findByBoard(boardNo);
		
		return list;
	}
	
}
