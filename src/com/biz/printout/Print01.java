package com.biz.printout;

public class Print01 {

	public static void main(String[] args) {
		int intNum = 30;
		System.out.println(intNum);
		
		// 100개의 임의의 숫자를 생성해서 콘솔에 보여주는 매우 단순한 코드를 작성해보자
		for(int i = 0 ; i < 100 ; i ++) {
			makeScore();
		}
		
	}
	
	public static void makeScore() {
		System.out.println((int)(Math.random()*100+1));
	}
}
