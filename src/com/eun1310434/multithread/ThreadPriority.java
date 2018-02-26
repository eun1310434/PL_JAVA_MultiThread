/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍
*/
package com.eun1310434.multithread;
class ThreadPriority_thread extends Thread {
	private String name;

	public ThreadPriority_thread(String _name){
		this.name = _name;
	}
	
	public void run() {
		System.out.println(name+ " - Start");
		for(int n = 0; n < 100; n++) {
			System.out.println(name+ " - " + n);
		}
		System.out.println(name+ " - Finish");
	}
}

public class ThreadPriority {
	public static void main(String[] ar) {
		ThreadPriority_thread a = new ThreadPriority_thread("A");
		ThreadPriority_thread b = new ThreadPriority_thread("B");
		ThreadPriority_thread c = new ThreadPriority_thread("C");
		
		a.setPriority(Thread.MAX_PRIORITY);
		//a의 우선순위 최대 : MAX_PRIORITY = 10
		
		b.setPriority(8);
		//b의 우선순위 중간 : 7

		c.setPriority(Thread.MIN_PRIORITY);
		//c의 우선순위 최소 : Thread.MIN_PRIORITY = 1
		
		a.start();
		b.start();
		c.start();
	}
}
