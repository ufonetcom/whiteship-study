package io.collectionTest;

import java.util.Arrays;

public class ArrayQueue {
	   int[] queueArray;
	   int top = -1;
	   int tail = -1;
	   int size;
	   
	   public ArrayQueue(int size) {
	      this.size = size;
	      queueArray = new int[size];
	   }
	   
	   
	   
	   
	   //dequeue를 실행할 때 큐가 비었으면(top과tail 둘다 -1이면) true를 반환
	   public boolean isEmpty() {
		   return top == -1 && tail == -1;
	   }
	   
	   
	   
	   public void enqueue(int data) {
		   //만약 큐의 길이와 (tail(index)의 +1) 이 같다면 큐의 길이를 늘려주기.
		   //큐가 full이라는 메세지를 던져주는 방법과 큐의 길이를 더 늘려주는 방법이 있다.
	      if(queueArray.length== (tail+1)) {
	         queueArray = Arrays.copyOf(queueArray, size+1);
	      }
	      queueArray[++tail] = data; //++를 먼저 쓴 경우는 증가를 한 후에 tail에 data를 삽입 한 경우.
	      
	      //top은 큐배열의 요소가 없고 enqueue가 일어났을때는 0으로 초기화, 요소가 있을때는 변화가 없다.
	      if(top==-1) {
	    	  top = 0;
	      }
	      
	   }
	   
	   
	   
	   public int dequeue() {
		   if(isEmpty()) {  //큐가 비었을때
			   throw new ArrayIndexOutOfBoundsException("큐가 비었습니다. 데이터를 추가해주세요.");
		   }else if(tail==0) {
			   int result = queueArray[tail];
			   queueArray = null;
			   top  = -1;
			   tail = -1;
			   return result;
		   }
		   
		   int[] tmp = queueArray.clone();
		   queueArray = new int[tmp.length-1];
		   //큐배열의 담긴 삭제 요소 방향인 왼쪽으로 하나씩 옮겨져야 함으로 길이-1까지. 
		   for(int i=0; i<queueArray.length; i++) {
			   queueArray[i] = tmp[i+1];
		   }
		   
		   //top과 tail의 index가 같으면 (top은 최대 인덱스가 0. 즉, top과tail이 0이면 둘다 -1로 초기화.
		   //index가 같지 않으면 tail은 증감연산자로 인하여 -1감소. top은 그대로.
		   tail--;

		   
		   return tmp[0];
	   }
	   
       //QueueArray toString
	   public String toString() {
	      if(queueArray==null) { return "[]"; }
	      
	      else if(queueArray.length==1) {
	         return "["+String.valueOf(queueArray[0])+"]";
	      }
	      
	      String result = "["+String.valueOf(queueArray[0]);
	      for(int i=1; i<queueArray.length; i++) {
	         result += String.valueOf(", "+queueArray[i]);
	      }
	      result += "]";
	      
	      return result;
	   }

	}
