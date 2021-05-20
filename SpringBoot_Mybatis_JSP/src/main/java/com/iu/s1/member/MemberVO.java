package com.iu.s1.member;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class MemberVO {

	private String username;
	@Pattern(regexp = "[^\s]{6,15}")
	private String password;
	private String name;
	private String email;
	private String phone;
}
