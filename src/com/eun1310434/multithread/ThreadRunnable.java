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
