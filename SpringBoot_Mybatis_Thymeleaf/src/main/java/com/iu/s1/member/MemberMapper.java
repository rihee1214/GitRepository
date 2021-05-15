package com.iu.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	//로그인 체크
	public MemberVO getLogin(MemberVO memberVO)throws Exception;
	//회원가입 아이디 체크
	public MemberVO getCheck(MemberVO memberVO)throws Exception;
	//멤버 페이지
	public MemberVO getPage(MemberVO memberVO)throws Exception;
	//회원가입
	public Long setMember(MemberVO memberVO)throws Exception;
	//멤버사진 업로드
	public Long setMemberFile(MemberFileVO memberFileVO)throws Exception;
}
