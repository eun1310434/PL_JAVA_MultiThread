/*=====================================================================
�� Infomation
  �� Data : 13.03.2018
  �� Mail : eun1310434@naver.com
  �� Blog : https://blog.naver.com/eun1310434
  �� Reference : ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, programmers.co.kr, 

�� Function
  �� 

�� Study
  �� Thread
      - ���μ��� ������ ����Ǵ� �������� �������� �ִ� �Ϸ��� �۾� �帧 ����.

  �� Multi-Thread 
      - ���α׷� ȯ�濡 ���� �ϳ��� ���μ������� �� �̻��� �����带 ���ÿ� �����ϴ� ���(CPU�� �ϳ��� �� �ú��� ���信 ����Ͽ� ����)

  �� Thread Process
      - ThreadŬ������ Runnable �������̽��� ��ӹްų� �����ϴ� Ŭ������ �ۼ�
      - run�޼���(: Thread�� ���� �޼ҵ�)�� �������̵� �� start�޼���� ����
      - Thread���� run()�� ȣ���Ͽ� ����ϸ� MainThread���� ���������� ����
      - Thread���� start()�� ȣ���Ͽ� ����ϸ� ������ ���μ������� ����ǹǷ� MainThread�� ������ ���� �ʰ� ���� 
         ��, start()�� �����ؾ� ������ ���μ����� �����

  �� Runnable 
      - Thread�� extends�Ͽ� ������ Ŭ������ �ٸ� Ŭ������ extends���� ����
      - Runnable interface�� implements�ϸ� Thread�� �ƴ� �ٸ� Ŭ������ extends ����
      - Custormizing Thread : Only extends Thread
      - Thread(Runnable) : Thread function + Other Class can extends 

  �� Thread �켱���� (setPriority)
      - 1 ~ 10 ������ ���� ǥ��
      - MIN_PRIORITY(1)
      -  NORM_PRIORITY(5) : �⺻������ ����
      - MAX_PRIORITY(10)

  �� Thread Synchronized
      - ��Ƽ ������� �۵��ϴ� ���α׷����� ���� �����尡 �ϳ��� ���� �޸𸮸� ���ÿ� ����� ��
        �ϳ��� �����尡 ��� ���� �� �ٸ� �����尡 �������� ���ϵ��� ���� ��.
      - �Ӱ迵��(Critical Section) : ����ȭ ����� �Ǵ� �ڵ� ����
      - synchronized()

  �� Thread Group
      - �����带 �������� ���� �׷�ȭ �Ͽ� ����
      - �׷�ȭ�� �� ��������� �ѹ��� �Ӽ��� �����ϴ� ���� ����
         : �켱���� �ϰ�����, ���� ������ ���� �ϰ� ���� ��..

  �� Thread Pool
      - �������� ���� ������ �ʿ��� �ڿ��� ���� ���̰��� �ѹ� ������ �����带 �����ϴ°�.
      - ���ε༭(Producer) - ������(Consumer) ���� ���
         : Queue��� Task�� �����ϴ� ������ �ξ� Producer�� ��û�ϴ� �۾��� ���ʴ�� Queue�� �״´�.
           ���� �۾��� ������ �۾� ó�� ����(FIFO, LIFO ��)�� ���� Consumer�� �ϳ��� ó���Ѵ�.
           �̶� Consumer�� ó�� ������ ���� ����ؼ� �۾��� ������ �Ǿ�� �ϱ� ������ 
           �ش� ��ü�� �Ź� �����ϰ� �Ҹ��Ű�� �ʴ´�(�Ź� �����ϰ� �Ҹ��Ű�� �Ǹ� �ý����� ���ϸ� �׸�ŭ ���̴� ���� �Ǳ� ����)
           ���� �����Ӵ� �۾��� Ǯ(Pool)�� ������ �ξ��ٰ� ���ε༭�� ��û�� ���� ������ ��� ���� ó���� �ϰ� �ȴ�.

  �� �н�üũ
      - ������� ��Ƽ�������?
      - �ڹ� ������ �ۼ�����?
      - �������� �켱������?
      - �������� ����ȭ �����?
      - ������ �׷��� ��� ������?
      - ������ Ǯ�� ��� ������?
=====================================================================*/
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
