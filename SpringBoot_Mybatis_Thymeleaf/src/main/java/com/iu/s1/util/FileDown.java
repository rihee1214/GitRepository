package com.iu.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//custom view생성
//1. Abstract View라는 클래스를 상속받아야 한다.
// FileDown 변수명 = new FileDown(); 같은 식으로 사용해야 한다.
// 개발자가 따로 지정하지 않으면 첫글자를 소문자로 바꾼것이 참조 변수명이 된다.
// component 옆에 문자열로 이름을 줄 수 있다.
// @Component("custom")
@Component
public class FileDown extends AbstractView{

	@Autowired
	private ResourceLoader resourceLoader;
	
	//2. 추상메서드 renderMergedOutputModel을 overriding 한다.
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
											HttpServletRequest request,
											HttpServletResponse response) throws Exception {
		// model은 ModelAndView의 Model객체
		// 어느폴더의 어느 파일을 받을 것인지 알려주어야 한다.
		String fileName = (String)model.get("fileName");
		String filePath = (String)model.get("filePath");
		String oriName = (String)model.get("oriName");
		
		String path = "classpath:/static/";
		
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		
		file = new File(file, fileName);
		
		//한글처리
		response.setCharacterEncoding("UTF-8");
		response.setContentLengthLong(file.length());
		
		fileName = URLEncoder.encode(oriName, "UTF-8");
		
		//이 상황의 header는 클라이언트에게 해당 파일이 어느 파일인지 알려주는 역활을 한다.
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"" );
		response.setHeader("Content-Transfer-Encoding", "binary");

		//HD에서 file을 읽는다.
		FileInputStream fi = new FileInputStream(file);
		//Client로 전송할 준비를 한다.
		OutputStream os = response.getOutputStream();
		
		//전송을 담당한다.
		FileCopyUtils.copy(fi, os);
		
		os.close();
		fi.close();
	}
	
	
}
