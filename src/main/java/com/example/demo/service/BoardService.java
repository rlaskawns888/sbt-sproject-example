package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.repository.BoardRepository;
import com.example.demo.dto.BoardDto;
import com.example.demo.dto.PagingDto;

@Service
public class BoardService {
	private BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	/**
	 * 저장.
	 * @param boardDto
	 * @return
	 */
	@Transactional
	public Long savePost(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getBoardSeq();
	}
	
	/**
	 * 전체 출력
	 * @return
	 */
	@Transactional
	public List<BoardDto> getBoardList() {		
		List<Board> boardList = boardRepository.findAll();
		List<BoardDto> boardDtoList = new ArrayList<>();
		
		for(Board board : boardList) {
			BoardDto boardDto = BoardDto.builder()
					.boardSeq(board.getBoardSeq())
					.boardSubject(board.getBoardSubject())
					.boardWriter(board.getBoardWriter())
					.boardContent(board.getBoardContent())
					.insDate(board.getInsDate())
					.build();
			
			boardDtoList.add(boardDto);
		}
		
		return boardDtoList;
	}
	
	/**
	 * 상세.
	 * @param boardSeq
	 * @return
	 */
	@Transactional
	public BoardDto getPost(Long boardSeq) {
		Board board = boardRepository.findById(boardSeq).get();
		
		BoardDto boardDto = BoardDto.builder()
				.boardSeq(board.getBoardSeq())
				.boardSubject(board.getBoardSubject())
				.boardContent(board.getBoardContent())
				.boardWriter(board.getBoardWriter())
				.insDate(board.getInsDate())
				.build();
		
		return boardDto;
	}
	
	/**
	 * 삭제.
	 * @param boardSeq
	 */
	@Transactional
	public void deletePost(Long boardSeq) {
		boardRepository.deleteById(boardSeq);
	}
}
