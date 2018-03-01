/**
 * 01.03.2018
 * eun1310434@naver.com
 * https://blog.naver.com/eun1310434
 * ����) ���� ���� ����Ʈ���� ����, Java Documentation, ��� �ڹ� ���α׷���, https://programmers.co.kr
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
    	
    	
    	//�޼ҵ常 ������ �� �ִٸ�, ���� ���ϰ� ���α׷��� ����
    	//�ڹٴ� �޼ҵ常 ���� �Ұ� -> �Ź� ��ü�� ���� �� �Ű����� ���� 
    	//����ǥ�������� �ذ�!!
        new Thread(
        		()->{//()->{ ..... } �κ��� ���ٽ�, 
        			 //�ٸ����� �͸� �޼ҵ�, JVM�� Thread�����ڸ� ���� ()->{} �� �������� ��� �߷�
        			 //Thread������ api�� ���� Runnable�������̽��� �޾Ƶ��̴� ���� Ȯ��
        			for(int i = 0; i < 3; i++){
        				System.out.println("lambda Thread use");
        			}
        		}
        		).start();
    }   
}
