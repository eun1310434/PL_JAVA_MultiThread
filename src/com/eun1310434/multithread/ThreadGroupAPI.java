/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * ����) ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���
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
		//ThreadGroup�� Thread�� ���ļ� �ѹ��� ��������
		
		g1.setDaemon(true);
		//Thread.setDaemon(true)�� �������� ������ : ���� �����尡 �����ϸ� ���� ����
		g1.setMaxPriority(Thread.MIN_PRIORITY);
		//ThreadGroup���� �켱������ �ִ� 5���� ����
		
		g2.setDaemon(true);
		//Thread.setDaemon(true)�� �������� ������ : ���� �����尡 �����ϸ� ���� ����
		g2.setMaxPriority(2);
		//ThreadGroup���� �켱������ �ִ� 5���� ����
		
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
