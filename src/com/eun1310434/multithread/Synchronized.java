/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍
*/
package com.eun1310434.multithread;
class Synchronized_runnable implements Runnable {
	public synchronized void sync_01() {
		//synchronized를 처리한 해당 함수 전체에  적용
		
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" : sync_01() - Start!!");
		for(int n = 1; n <= 5; ++n) {
			System.out.println(threadName + " : " + n );
			System.out.flush();
		}
		System.out.println(threadName+" : sync_01() - Finish!!");
	}
	
	
	
	public void sync_02() {
		String threadName = Thread.currentThread().getName();
		
		synchronized(this) {
			//synchronized를 처리한 해당 부분에  적용
			System.out.println(threadName+" : sync_02() - Start!!");
			for(int n = 1; n <= 5; ++n) {
				System.out.println(threadName + " : " + n );
				System.out.flush();
			}
			System.out.println(threadName+" : sync_02() - Finish!!");
		}
	}
	
	
	
	static int x = 1;
	public void sync_03() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName+" : sync_03() - Start!!");
		for(int n = 1; n <= 5; ++n) {
			synchronized(this) {
				System.out.println(""+ x +") "+threadName +" : " + n );
				System.out.flush();
				x++;//synchronized를 활용하여 공유하는 객체의 동기화를 실시함
			}
		}
		System.out.println(threadName+" : sync_03() - Finish!!");
	}
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " Thread Start!");
		//sync_01();
		//sync_02();
		sync_03();
	}
}

public class Synchronized {
	public static void main(String[] ar) {
		Synchronized_runnable runnable = new Synchronized_runnable();
		
		Thread a = new Thread(runnable, "A");
		Thread b = new Thread(runnable, "B");
		Thread c = new Thread(runnable, "C");
		
		a.start();
		b.start();
		c.start();
	}
}
