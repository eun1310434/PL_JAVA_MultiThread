/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * ����) ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���
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
		//ThreadPool�̶� �ѹ� ������ Thread�� ������ �����ϰ� ����
		//FixedThreadPool�� ���� �ִ� 2���� Thread�� ����� ���� 2���� ����.
		
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
			Thread t = new Thread(run);//������ ���ϰ� �߻�
			t.start();
		}
		*/
		
		
		for(Runnable run: runnable) {
			exec.execute(run);
		}
		
		exec.shutdown();
	}
}
