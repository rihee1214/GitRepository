package com.iu.s1.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class MemberVO {

	@NotEmpty
	private String username;
	@Pattern(regexp = "[^\s]{6,15}")
	private String password;
	@NotEmpty
	private String name;
	private String email;
	private String phone;
}
