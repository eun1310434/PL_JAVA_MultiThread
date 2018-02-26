/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍
*/
package com.eun1310434.multithread;

class ThreadAPI_thread extends Thread{
	public void run(){
		for(int i = 0 ; i < 100 ; ++i){
			try{
				Thread.sleep(10);
			}catch(Exception e){}
			System.out.println("MyThread = " + i);
		}
	}
}

class ThreadAPI_info{
	Thread currentThread;
	
	private ThreadAPI_info(){}
	
	public static void print(Thread currentThread){
		new ThreadAPI_info();
		System.out.println("_______________________________________");
		System.out.println("name = " + currentThread.getName());
		System.out.println("currentThread = " + currentThread);
		System.out.println("priority = " + currentThread.getPriority());
		System.out.println("isAlive = " + currentThread.isAlive());
		System.out.println("isDeamon = " + currentThread.isDaemon());
	}
}

public class ThreadAPI {

	public static void main(String[] ar) {
		
		System.out.println("프로그램 시작");
		ThreadAPI_thread t = new ThreadAPI_thread();
		t.setName("ThreadAPI_thread");
		
		t.setDaemon(true);
		//setDaemon(true)는 종속적인 쓰레드 : 상위쓰레드(메인 쓰레드)가 종료하면 따라 종료
		
		//t.run(); 
		//run은 main 메소드의 실행과 함께 함.
		
		t.start(); 
		// start는 main 메소드와 별개로 실행 함. CPU를 서로 번갈아가며 점유
		
		
		for(int i = 0 ; i < 10; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			System.out.println("Main = " + i);
		}
		System.out.println("프로그램 종료");

		ThreadAPI_info.print(t);
		ThreadAPI_info.print(Thread.currentThread());
	}

}
