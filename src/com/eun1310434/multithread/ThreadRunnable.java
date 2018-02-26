/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍
*/
package com.eun1310434.multithread;

class ThreadRunnable_thread extends Thread{
	//자바는 단일 상속이기에  Thread를 사용할 시 다른 상속은 못함.
	
	public void run(){
		System.out.println("extends Thread");
	}
}
class ThreadRunnable_runnable1 implements Runnable{
	//Thread 사용시 자바의 단일 상속의 한계를 극복하기 위하여 인터페이스 Runnable 사용
	//Runnable 인터페이스를 사용시 extends를 통해 다른 상속 가능
	
	public void run(){
		System.out.println("implements Runnable");
	}
}

class ThreadRunnable_thread_runnable2 extends Thread implements Runnable{
	
	public void run(){
		System.out.println("extends Thread implements Runnable");
	}
}



public class ThreadRunnable {

	public static void main(String[] ar) {
		
		System.out.println("프로그램 시작");
		ThreadRunnable_thread t1 = new ThreadRunnable_thread();
		t1.start();
		
		ThreadRunnable_runnable1 t2 = new ThreadRunnable_runnable1();
		//t2.start();//Runnable 불가능
		Thread t2addthread = new Thread(t2);//Thread와 합체!
		t2addthread.start();
		
		
		ThreadRunnable_thread_runnable2 t3 = new ThreadRunnable_thread_runnable2();
		t3.start();
		
		
		System.out.println("프로그램 종료");
		
	}

}
