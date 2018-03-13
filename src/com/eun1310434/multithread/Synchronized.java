/*=====================================================================
□ Infomation
  ○ Data : 13.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference : 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, programmers.co.kr, 

□ Function
  ○ 

□ Study
  ○ Thread
      - 프로세스 내에서 실행되는 시작점과 종료점이 있는 일련의 작업 흐름 단위.

  ○ Multi-Thread 
      - 프로그램 환경에 따라 하나의 프로세스에서 둘 이상의 스레드를 동시에 실행하는 방식(CPU가 하나일 때 시분할 개념에 기반하여 동작)

  ○ Thread Process
      - Thread클래스나 Runnable 인터페이스를 상속받거나 구현하는 클래스를 작성
      - run메서드(: Thread의 메인 메소드)를 오버라이딩 → start메서드로 실행
      - Thread에서 run()을 호출하여 사용하면 MainThread에서 순차적으로 실행
      - Thread에서 start()을 호출하여 사용하면 별개의 프로세스에서 실행되므로 MainThread에 영향을 받지 않고 실행 
         즉, start()로 실행해야 별도의 프로세스로 실행됨

  ○ Runnable 
      - Thread를 extends하여 구현한 클래스는 다른 클래스를 extends하지 못함
      - Runnable interface로 implements하면 Thread가 아닌 다른 클래스를 extends 가능
      - Custormizing Thread : Only extends Thread
      - Thread(Runnable) : Thread function + Other Class can extends 

  ○ Thread 우선순위 (setPriority)
      - 1 ~ 10 사이의 수로 표시
      - MIN_PRIORITY(1)
      -  NORM_PRIORITY(5) : 기본적으로 사용됨
      - MAX_PRIORITY(10)

  ○ Thread Synchronized
      - 멀티 스레드로 작동하는 프로그램에서 여러 스레드가 하나의 공유 메모리를 동시에 사용할 때
        하나의 스레드가 사용 중일 때 다른 스레드가 접근하지 못하도록 막는 것.
      - 임계영역(Critical Section) : 동기화 대상이 되는 코드 영역
      - synchronized()

  ○ Thread Group
      - 스레드를 목적성에 따라 그룹화 하여 관리
      - 그룹화가 된 스레드들은 한번에 속성을 지정하는 것이 가능
         : 우선순위 일괄지정, 데몬 스레드 여부 일관 지정 등..

  ○ Thread Pool
      - 스레드의 최초 생성에 필요한 자원의 낭비를 줄이고자 한번 생성한 스레드를 재사용하는것.
      - 프로듀서(Producer) - 컨슈머(Consumer) 패턴 사용
         : Queue라는 Task을 보관하는 영역을 두어 Producer가 요청하는 작업을 차례대로 Queue에 쌓는다.
           쌓인 작업은 정해진 작업 처리 순서(FIFO, LIFO 등)에 따라 Consumer가 하나씩 처리한다.
           이때 Consumer는 처리 순서에 따라 계속해서 작업이 실행이 되어야 하기 때문에 
           해당 객체를 매번 생성하고 소멸시키지 않는다(매번 생성하고 소멸시키게 되면 시스템의 부하를 그만큼 높이는 것이 되기 때문)
           따라서 컨슈머는 작업을 풀(Pool)에 보관해 두었다가 프로듀서의 요청이 있을 때마다 즉시 실행 처리를 하게 된다.

  ○ 학습체크
      - 스레드와 멀티스레드란?
      - 자바 스레드 작성법은?
      - 스레드의 우선순위란?
      - 스레드의 동기화 방법은?
      - 스레드 그룹의 사용 목적은?
      - 스레드 풀의 사용 목적은?
=====================================================================*/
package com.eun1310434.multithread;
class Synchronized_runnable implements Runnable {
	public synchronized void sync_01() {
		//synchronized를 처리한 해당 함수 전체에  적용ss
		
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
			//synchronized를 처리한 해당 부분에  적용
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
				x++;//synchronized를 활용하여 공유하는 객체의 동기화를 실시함
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
