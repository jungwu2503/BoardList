package bitedu.bipa.boardList.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.boardList.service.BoardService;
import bitedu.bipa.boardList.vo.BoardVO;

@Controller("BoardController")
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	
	//R1
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView list() {
		System.out.println("list");
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardVO> list = bs.searchAll();
		mav.addObject("list",list);
		mav.setViewName("./manager/board_list");
		return mav;
	}
	
	//D
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("boardNo") String boardNo) {
		ModelAndView mav = new ModelAndView();
		boolean flag = bs.deleteBoard(boardNo);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	
	//R2
	@RequestMapping(value="/view_detail.do", method=RequestMethod.GET)
	public ModelAndView view_detail(@RequestParam("boardNo") String boardNo) {
		ModelAndView mav = new ModelAndView();
		BoardVO board = bs.select(boardNo);
		mav.addObject("board", board);
		mav.setViewName("./manager/board_detail");
		return mav;
	}
	
	//U
	@RequestMapping(value="view_update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("board") BoardVO board) {
		ModelAndView mav = new ModelAndView();
		boolean flag = bs.updateBoard(board);
		mav.setViewName("redirect:list.do");
		return mav;
	}
	

	
}
