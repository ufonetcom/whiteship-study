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
   
   //data push
   public void push(int data) {
      //만약 stack이 data로 꽉 채워졌을때 배열복사를 진행하여 현재크기의 2배를 늘려준다.
      if(stackArr.length==top+1) {
         stackArr = Arrays.copyOf(stackArr, stackArr.length*2); //vector의 상속받기 때문에 2배를 확장.
         size = stackArr.length;
      }
      
      stackArr[++top] = data; //[++top]을 이용하여 증가된 top값에 바로 data를 삽입한다.
   }
   
   //data peek
   public int peek() {
      //stack이 비어있다면 반환해야 할 맨 꼭대기 값이 존재하지 않으므로 오류를 발생시킨다.
      if(size==0) {
         throw new EmptyStackException();
      }
      return stackArr[top];
   }
   
   //data pop
   public int pop() {
      if(top==-1) {
         throw new EmptyStackException();
      }
      return stackArr[top--]; //[top--]를 이용하여 값을 반환 시키고 top 감소.
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
