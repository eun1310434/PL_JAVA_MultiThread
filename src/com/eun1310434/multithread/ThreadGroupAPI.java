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
