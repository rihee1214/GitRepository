package com.iu.s1.board;

import java.sql.Date;

import lombok.Data;

/**
@Getter		//getter메서드
@Setter		//setter 메서드
@ToString		//toString Overide
@NoArgsConstructor	//default 생성자
@AllArgsConstructor	//매개변수가 있는 생성자
@RequiredArgsConstructor //필수 매개변수만 있는 생성자
@EqualsAndHashCode //hash, equals 메서드
*/

@Data	//lombok의 모든 annotation선언과 동일
public class BoardVO {
	
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private Long hit;
}
