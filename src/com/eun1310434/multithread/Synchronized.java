/**
 * 26.02.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * ����) ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���
*/
package com.eun1310434.multithread;
class Synchronized_runnable implements Runnable {
	public synchronized void sync_01() {
		//synchronized�� ó���� �ش� �Լ� ��ü��  ����
		
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
			//synchronized�� ó���� �ش� �κп�  ����
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
				x++;//synchronized�� Ȱ���Ͽ� �����ϴ� ��ü�� ����ȭ�� �ǽ���
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
