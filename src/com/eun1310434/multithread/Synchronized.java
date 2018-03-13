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
class Synchronized_runnable implements Runnable {
	public synchronized void sync_01() {
		//synchronized�� ó���� �ش� �Լ� ��ü��  ����ss
		
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
