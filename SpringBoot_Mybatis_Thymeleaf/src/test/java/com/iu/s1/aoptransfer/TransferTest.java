package com.iu.s1.aoptransfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.s1.aop.transfer.Card;
import com.iu.s1.aop.transfer.Transfer;

@SpringBootTest
class TransferTest {

	@Autowired
	private Transfer transfer;
	@Autowired
	private Card card;
	
	@Test
	void test() {
		//OOP 언어의 한계 이것을 더 OOP 답게 해주는 것이 AOP이다.
		//부수적이고 공통적인 일들을 대신 처리해 준다.
		//특정 로그 기록을 찍을 때 많이 사용할 것이다.
		//혹은 transaction처리할 때 사용할 것이다.
//		card.cardCheck();
//		transfer.takeBus();
//		card.cardCheck();
//		card.cardCheck();
//		transfer.takeSubway();
//		card.cardCheck();
		transfer.takeBus();
		transfer.takeSubway();
	}

}
