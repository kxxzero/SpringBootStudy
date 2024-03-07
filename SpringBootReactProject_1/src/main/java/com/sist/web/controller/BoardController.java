package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;

@RestController
@CrossOrigin(origins="*")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/board/list_react")
	public Map boardListData(int page) {
		Map map=new HashMap();
		
		int rowSize=10;
		int start=(rowSize*page)-rowSize;
		
		List<BoardVO> list=dao.boardListData(start);
		
		int count=(int)dao.count();
		int totalpage=(int)(Math.ceil(count/10.0));
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) {
			endPage=totalpage;
		}
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("count", count);
		map.put("list", list);
		
		return map;
	}
	
	
	@PostMapping("/board/insert_react")
	public String boardInsert(Board vo) {
		String result="";
		
		try {
			dao.save(vo);
			result="yes";
		} catch(Exception ex) {
			result="no";
		}
		return result;
	}
	
	
	@GetMapping("/board/detail_react")
	public Board boardDetail(int no) {
		Board vo=dao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		dao.save(vo);
		vo=dao.findByNo(no);
		return vo;
	}
	
	
	@GetMapping("/board/update_react")
	public Board boardUpdate(int no) {
		Board vo=dao.findByNo(no);
		return vo;
	}
	
	
	@PostMapping("/board/update_ok_react")
	public String boardUpdateOk(Board vo) {
		Board dbVO=dao.findByNo(vo.getNo());
		String result="";
		if(vo.getPwd().equals(dbVO.getPwd())) {
			result="yes";
			vo.setHit(dbVO.getHit());
			dao.save(vo);
		} else {
			result="no"; 
		}
		return result;
	}
	
	
	@PostMapping("/board/delete_react")
	public String boardDelete(int no, String pwd) {
		String result="";
		Board vo=dao.findByNo(no);
		if(vo.getPwd().equals(pwd)) {
			result="yes";
			dao.delete(vo);
		} else {
			result="no";
		}
				
		return result;
	}
}