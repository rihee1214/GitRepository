package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private FileManager fileManager;
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}
	
	public MemberVO getCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getCheck(memberVO);
	}
	
	public MemberVO getPage(MemberVO memberVO)throws Exception{
		return memberMapper.getPage(memberVO);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Long setMember(MemberVO memberVO, MultipartFile file)throws Exception{
		Long result = memberMapper.setMember(memberVO);
		
		if(file.getSize()!=0&&result>0) {
			String path = "upload/member/";
			MemberFileVO memberFileVO = new MemberFileVO(fileManager.save(file, path));
			memberFileVO.setOriName(file.getOriginalFilename());
			memberFileVO.setUserName(memberVO.getUserName());
			result=memberMapper.setMemberFile(memberFileVO);
		}
		
		if(result<1) {
			throw new Exception();
		}
		
		return result;
	}
}
