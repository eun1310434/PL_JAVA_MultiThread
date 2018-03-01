/**
 * 01.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * 참고) 쉽게 배우는 소프트웨어 공학, Java Documentation, 헬로 자바 프로그래밍, https://programmers.co.kr
*/
package com.eun1310434.multithread;

public class ThreadLambda {

    public static void main(String[] args) {
    	/*
        new Thread(
        		new Runnable(){
        			public void run(){
        				for(int i = 0; i < 3; i++){
        					System.out.println("Basic use");
        				}
        			}	
        		}
        		).start();
		*/
    	
    	
    	//메소드만 전달할 수 있다면, 좀더 편리하게 프로그래밍 가능
    	//자바는 메소드만 전달 불가 -> 매번 객체를 생성 후 매개변수 전달 
    	//람다표현식으로 해결!!
        new Thread(
        		()->{//()->{ ..... } 부분이 람다식, 
        			 //다른말로 익명 메소드, JVM은 Thread생성자를 보고 ()->{} 이 무엇인지 대상 추론
        			 //Thread생성자 api를 보면 Runnable인터페이스를 받아들이는 것을 확인
        			for(int i = 0; i < 3; i++){
        				System.out.println("lambda Thread use");
        			}
        		}
        		).start();
    }   
}
