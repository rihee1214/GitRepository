package com.iu.s1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

//	@Autowired
//	private ResourceLoader resourceLoader;
	
	public String save(MultipartFile multipartFile, String filePath)throws Exception{

		/**
		 * 저장할 폴더가 시스템에 고정일 경우
		 * 굳이 이런방식을 사용할 이유가 없이 file객체를 직접 만들어서 filepath를 지정해 주면된다.
		 */
		
		/**
		 * ResourceLoader
		 * classpath 경로를 받아오기 위해 사용
		 * 
		 * 	String path="classpath:/static/";
		 * 	File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		 */
		
		/**
		 * ClassPathResource
		 * classPath 경로를 받아오기 위해 사용
		 * ResourceLoader와 같지만
		 * 시작 경로에서 classpath를 제외가능
		 */
		
		String path = "static";
		ClassPathResource classPathResource = new ClassPathResource(path);
		
		File file = new File(classPathResource.getFile(), filePath);
		
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}
}
