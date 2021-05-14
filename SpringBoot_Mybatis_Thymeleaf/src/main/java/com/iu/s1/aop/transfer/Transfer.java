package com.iu.s1.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {

	public void takeSubway() {
		System.out.println("---지하철 탑승---");
		System.out.println("넷플릭스 시청");
	}
	
	public void takeBus() {
		System.out.println("---버스 탑승---");
		System.out.println("Melon 듣기");
	}
}
