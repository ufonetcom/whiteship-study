package io.collectionTest;


import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack {
   private int[] stackArr;
   private int top = -1;
   private int size=0;
   
   public ArrayStack(int size) {
      this.size=size;
      this.stackArr=new int[size];
   }
   
   public ArrayStack() {}

//data push
   public void push(int data) {
       if(top==-1) {
    	   stackArr = new int[] {data};
    	   size++;
    	   top++;
    	   return;
       }
       
	   //stack이 하나이상 채워저 있을때 배열(stack 공간)을 +1의 길이로 복사하여 확장시킨다.
	   stackArr = Arrays.copyOf(stackArr, stackArr.length+1);
	   size = stackArr.length;
     
       stackArr[++top] = data; //[++top]을 이용하여 증가된 top값에 바로 data를 삽입한다.
   }
   
   //data peek
   public int peek() {
      //stack이 비어있다면 반환해야 할 맨 꼭대기 값이 존재하지 않으므로 오류를 발생시킨다.
      if(stackArr==null) {
         throw new EmptyStackException();
      }
      return stackArr[top];
   }
   
   //data pop
   public int pop() {
	  //pop할 원소가 없는 경우
      if(top==-1) {
         throw new EmptyStackException();
      }
      //stackArr원소가 1개인 경우
      if(top==0) {
    	  int result = stackArr[top--];
    	  stackArr = null;
    	  return result;
      }
      
      int tmp[] = stackArr.clone();
      stackArr = new int[--size];
      for(int i=0; i<size; i++) {
    	  stackArr[i] = tmp[i];
      }
      return tmp[top--]; //[top--]를 이용하여 값을 반환 시키고 top 감소.
   }
   
   //StackArr toString
   public String toString() {
      if(stackArr==null) { return "[]"; }
      
      else if(stackArr.length==1) {
         return "["+String.valueOf(stackArr[0])+"]";
      }
      
      String result = "["+String.valueOf(stackArr[0]);
      for(int i=1; i<stackArr.length; i++) {
         result += String.valueOf(", "+stackArr[i]);
      }
      result += "]";
      
      return result;
   }

}
