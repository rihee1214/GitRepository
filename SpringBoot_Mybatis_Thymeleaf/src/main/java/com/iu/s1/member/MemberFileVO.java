package com.iu.s1.member;

import com.iu.s1.util.FileVO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberFileVO extends FileVO{

	private String userName;
	
	public MemberFileVO(String fileName) {
		this.setFileName(fileName);
	}
}
