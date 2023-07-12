package bitedu.bipa.boardList.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bitedu.bipa.boardList.service.BoardService;
import bitedu.bipa.boardList.vo.BoardVO;

@Controller("BoardController")
@RequestMapping("board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	//**insert url later**//
//	@RequestMapping(value="/", method.RequestMethod.GET)
	public ModelAndView list() {
		System.out.println("list");
		System.out.println("list");
		System.out.println("list");
		ModelAndView mav = new ModelAndView();
		ArrayList<BoardVO> list = bs.searchAll();
		return mav;
	}
	//**insert url later**//
//	@RequestMapping(value="/", method.RequestMethod.GET)
	public ModelAndView delete(@RequestParam("no") String no) {
		ModelAndView mav = new ModelAndView();
		boolean flag = bs.deleteBoard(no);
		mav.setViewName("");	//**insert url later**//
		return mav;
	}
	
}
