/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * ����) ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���
*/
package com.eun1310434.multithread;

class ThreadRunnable_thread extends Thread{
	//�ڹٴ� ���� ����̱⿡  Thread�� ����� �� �ٸ� ����� ����.
	
	public void run(){
		System.out.println("extends Thread");
	}
}
class ThreadRunnable_runnable1 implements Runnable{
	//Thread ���� �ڹ��� ���� ����� �Ѱ踦 �غ��ϱ� ���Ͽ� �������̽� Runnable ���
	//Runnable �������̽��� ���� extends�� ���� �ٸ� ��� ����
	
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
		
		System.out.println("���α׷� ����");
		ThreadRunnable_thread t1 = new ThreadRunnable_thread();
		t1.start();
		
		ThreadRunnable_runnable1 t2 = new ThreadRunnable_runnable1();
		//t2.start();//Runnable �Ұ���
		Thread t2addthread = new Thread(t2);//Thread�� ��ü!
		t2addthread.start();
		
		
		ThreadRunnable_thread_runnable2 t3 = new ThreadRunnable_thread_runnable2();
		t3.start();
		
		
		System.out.println("���α׷� ����");
		
	}

}
