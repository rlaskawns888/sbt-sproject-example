package com.example.demo.controller;

import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.dto.BoardDto;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {
	private BoardService boardService;
		
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	/**
	 * 전체 리스트 페이지 이동
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String list(Model model) {					
		List<BoardDto> boardDtoList = boardService.getBoardList();
		model.addAttribute("postList", boardDtoList);
		
		return "board/list.html";
	}
	
	/**
	 * 등록 페이지 이동
	 * @return
	 */
	@GetMapping("/post")
	public String post() {
		return "board/post.html";
	}

	/*
	 * 등록
	 */
	@PostMapping("/post")
	public String write(BoardDto boatdDto) {
		boardService.savePost(boatdDto);
		return "redirect:/";
	}
	
	/**
	 * 상세 페이지 이동
	 * @param boardSeq
	 * @param model
	 * @return
	 */
	@GetMapping("/post/{boardSeq}")
	public String detail(@PathVariable("boardSeq") Long boardSeq, Model model) {
		BoardDto boardDto = boardService.getPost(boardSeq);
		model.addAttribute("post", boardDto);
		
		return "board/detail.html";
	}
	
	/**
	 * 수정 페이지 이동
	 * @param boardSeq
	 * @param model
	 * @return
	 */
	@GetMapping("/post/edit/{boardSeq}")
	public String edit(@PathVariable("boardSeq") Long boardSeq, Model model) {
		BoardDto boardDto = boardService.getPost(boardSeq);
		model.addAttribute("post", boardDto);
		
		return "/board/edit.html";
	}
	
	/**
	 * 수정
	 * @param boardDto
	 * @return
	 */
	@PutMapping("/post/edit/{boardSeq}")
	public String update(BoardDto boardDto) {
		boardService.savePost(boardDto);
		return "redirect:/";
	}
	
	/**
	 * 삭제
	 * @param BoardSeq
	 * @return
	 */
	@DeleteMapping("/post/{boardSeq}")
	public String delete(@PathVariable("boardSeq") Long boardSeq) {
		boardService.deletePost(boardSeq);
		return "redirect:/";
	}
}
