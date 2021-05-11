package com.iu.s1.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoticeTest {

	@Autowired
	private NoticeService noticeService;
	
	@Test
	void test() throws Exception {
		assertNotNull(noticeService.getList());
	}

}
