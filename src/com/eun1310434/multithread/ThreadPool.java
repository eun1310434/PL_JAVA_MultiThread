/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍
*/

package com.eun1310434.multithread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPool_thread implements Runnable {
	private String name;
	
	public ThreadPool_thread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int n = 1; n <= 6; ++n) {
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {}
			System.out.println(name + " : " + n );
			System.out.flush();
		}
	}
}
public class ThreadPool {
	public static void main(String[] ar) {
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		//ThreadPool이란 한번 생성된 Thread를 재사용이 가능하게 해줌
		//FixedThreadPool을 통해 최대 2개의 Thread를 만들어 놓고 2개만 재사용.
		
		Runnable[] runnable = new Runnable[] {
				new ThreadPool_thread("A"), 
				new ThreadPool_thread("B"),
				
				new ThreadPool_thread("C"), 
				new ThreadPool_thread("D"), 
				
				new ThreadPool_thread("E"), 
				new ThreadPool_thread("F"), 
				
				new ThreadPool_thread("G"), 
				new ThreadPool_thread("H"), 
				
				new ThreadPool_thread("I")
		};
		
		/*
		for(Runnable run: runnable) {
			Thread t = new Thread(run);//굉장한 부하가 발생
			t.start();
		}
		*/
		
		
		for(Runnable run: runnable) {
			exec.execute(run);
		}
		
		exec.shutdown();
	}
}
