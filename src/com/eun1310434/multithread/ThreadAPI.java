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
