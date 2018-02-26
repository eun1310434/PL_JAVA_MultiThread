/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍
*/

package com.eun1310434.multithread;

class ThreadGroupAPI_thread extends Thread {
	String name;
	String threadGroupName;

	public ThreadGroupAPI_thread (ThreadGroup _tg, String _name) {
		super(_tg, _name);
		this.name = _name;
		this.threadGroupName = _tg.getName() ;
		//this.setDaemon(_tg.isDaemon());
	}
	
	
	public void run() { 
		for(int n = 1; n <= 10; ++n) {
			System.out.println(threadGroupName+" : "+ this.isDaemon()+" - "+ name + " : " + n);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class ThreadGroupAPI {
	public static void main(String[] ar) {
		ThreadGroup  mainGroup = Thread.currentThread().getThreadGroup();
		
		ThreadGroup  g1 = new ThreadGroup("G1");
		ThreadGroup  g2 = new ThreadGroup("G2");
		//ThreadGroup은 Thread를 뭉쳐서 한번에 관리가능
		
		g1.setDaemon(true);
		//Thread.setDaemon(true)는 종속적인 쓰레드 : 메인 쓰레드가 종료하면 따라 종료
		g1.setMaxPriority(Thread.MIN_PRIORITY);
		//ThreadGroup에서 우선순위는 최대 5까지 가능
		
		g2.setDaemon(true);
		//Thread.setDaemon(true)는 종속적인 쓰레드 : 메인 쓰레드가 종료하면 따라 종료
		g2.setMaxPriority(2);
		//ThreadGroup에서 우선순위는 최대 5까지 가능
		
		ThreadGroupAPI_thread t1 = new ThreadGroupAPI_thread(g1, "A");
		ThreadGroupAPI_thread t2 = new ThreadGroupAPI_thread(g1, "B");
		ThreadGroupAPI_thread t3 = new ThreadGroupAPI_thread(g2, "C");
		ThreadGroupAPI_thread t4 = new ThreadGroupAPI_thread(g2, "D");
		ThreadGroupAPI_thread t5 = new ThreadGroupAPI_thread(g2, "E");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		//mainGroup.list();	
		System.out.println("Main Finish ");
	}
}
