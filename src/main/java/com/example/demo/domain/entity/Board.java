package com.example.demo.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbBoard")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class Board implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long boardSeq;
	
	@Column(length = 10, nullable = false)
	private String boardWriter;
	
	@Column(length = 100, nullable = false)
	private String boardSubject;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String boardContent;
	
	@Column(updatable = false)
	private String InsUserId;
	
	@CreatedDate
    @Column(updatable = false)
	private LocalDateTime insDate;
	
	@Column
	private String updUserId;
	
	@LastModifiedDate
	private LocalDateTime UpdDate;

	@Builder
	public Board(Long boardSeq, String boardWriter, String boardSubject, String boardContent) {		
		this.boardSeq = boardSeq;
		this.boardWriter = boardWriter;
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
	}

}
