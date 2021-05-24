package com.iu.s1.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberVO {

	@Pattern(regexp = "[^\s]{6,15}")
	private String userName;
	private String password;
	@Length(min=4)
	@NotEmpty
	private String name;
	private String email;
	private String phone;
	
	private MemberFileVO memberFileVO;
}
