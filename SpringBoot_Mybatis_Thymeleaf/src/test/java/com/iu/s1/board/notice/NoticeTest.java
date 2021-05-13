package com.iu.s1.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.s1.board.BoardVO;

@SpringBootTest
class NoticeTest {

	@Autowired
	private NoticeService noticeService;
	
	@Test
	void setinsertTest()throws Exception{
		for(int i = 0 ; i < 100; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title"+i);
			boardVO.setContents("contents"+i);
			boardVO.setWriter("writer"+i);
			//noticeService.setBoard(boardVO);
			Thread.sleep(500);
		}
		System.out.println("finish");
	}
	
	//void test() throws Exception {
		//List<BoardVO> ar = noticeService.getList();
		//assertNotEquals(0, ar.size());
		//for(BoardVO boardVO:ar) {
			//System.out.println(boardVO.toString());
		//}
	//}

}
