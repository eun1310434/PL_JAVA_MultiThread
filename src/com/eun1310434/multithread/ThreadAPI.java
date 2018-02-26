/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * ����) ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���
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
		
		System.out.println("���α׷� ����");
		ThreadAPI_thread t = new ThreadAPI_thread();
		t.setName("ThreadAPI_thread");
		
		t.setDaemon(true);
		//setDaemon(true)�� �������� ������ : ����������(���� ������)�� �����ϸ� ���� ����
		
		//t.run(); 
		//run�� main �޼ҵ��� ����� �Բ� ��.
		
		t.start(); 
		// start�� main �޼ҵ�� ������ ���� ��. CPU�� ���� �����ư��� ����
		
		
		for(int i = 0 ; i < 10; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			System.out.println("Main = " + i);
		}
		System.out.println("���α׷� ����");

		ThreadAPI_info.print(t);
		ThreadAPI_info.print(Thread.currentThread());
	}

}
