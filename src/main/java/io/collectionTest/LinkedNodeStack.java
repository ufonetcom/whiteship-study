package io.collectionTest;

public class LinkedNodeStack {
	   private ListNode head;
	   private int stackSize=0; //노드의 갯수
	   
	   public class ListNode{
	      int data;
	      ListNode next;
	      
	      public ListNode(int data) {
	         this.data = data;
	         this.next = null;
	      }
	   }
	   
	   public void push(int data) {
	      stackSize += 1;
	      
	      if(head==null) {
	         head = new ListNode(data);
	         return;
	      }
	      //Data를 push할 인덱스를 계산하여 push할 노드의 이전 노드를 찾아낸다.(이전노드 : x)
	      ListNode x = head;
	      for(int i=1; i<stackSize-1; i++) {
	         x = x.next;
	      }
	      //이전노드의 다음노드, 즉 push할 해당 인덱스에 값을 push하고 링크를 연결한다.
	      x.next = new ListNode(data);
	   }
	   
	   public int pop() {
	      int popData;
	      if(head==null) { throw new IndexOutOfBoundsException(); }
	      if(stackSize==1) {
	         popData = head.data;
	         head = null;
	         stackSize = 0;
	         return popData;
	      }
	      //위과정과 동일
	      ListNode x = head;
	      for(int i=1; i<stackSize-1; i++) {
	         x = x.next;
	      }
	      popData = x.next.data;
	      
	      stackSize -= 1;
	      
	      return popData;
	   }
	   
	  //QueueArray toString
	   public String toString() {
	      if(head==null) { return "[]"; }
	      else if(stackSize==1) {
	         return "["+String.valueOf(head.data)+"]";
	      }
	      
	      String result = "["+String.valueOf(head.data);
	      
	      while(head.next != null) {
	    	  head = head.next;
	    	  result += String.valueOf(", "+head.data);
	      }
	      result += "]";
	      
	      return result;
	   }
	   
	   
	}