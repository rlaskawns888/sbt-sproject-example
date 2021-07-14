package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.domain.entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
	private Long boardSeq;
	private String boardWriter;
	private String boardSubject;
	private String boardContent;
	private LocalDateTime insDate;

	public Board toEntity() {
		Board build = Board.builder()
				.boardSeq(boardSeq)
				.boardWriter(boardWriter)
				.boardSubject(boardSubject)
				.boardContent(boardContent)
				.build();

		return build;
    }

	@Builder
	public BoardDto(Long boardSeq, String boardWriter, String boardSubject, String boardContent, LocalDateTime insDate) {
		this.boardSeq = boardSeq;
		this.boardWriter = boardWriter;
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
		this.insDate = insDate;
	}
	
	
}
