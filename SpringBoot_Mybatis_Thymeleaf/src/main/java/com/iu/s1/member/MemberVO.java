package com.iu.s1.member;

import lombok.Data;

@Data
public class MemberVO {

	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	private MemberFileVO memberFileVO;
}
