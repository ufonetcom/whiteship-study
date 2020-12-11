package io.collectionTest;

import java.util.Arrays;

public class LinkedNodeQueue {
	private ListNode head;
	private ListNode tail;
	private int queueSize = 0;
	
	
	public class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void enqueue(int data) {
		ListNode x = new ListNode(data);
		if(head == null) {
			head = x;
			tail = x;
		}else {
			ListNode temp = tail;
			tail = x;
			temp.next = tail;
		}
		queueSize++;
	}
	
	//toString과 흡사한 메서드.
	public void checkQueue() {
		ListNode check = head;
		int[] checkArr = new int[queueSize];
		int index=0;
		while(check != null) {
			checkArr[index]=check.data;
			check = check.next;
			index++;
		}
		System.out.println(Arrays.toString(checkArr));
	}
	
	public int dequeue() {
		if(head != null) {
			ListNode temp = head; //head노드를 temp노드에 임시 저장시킨다.
			head = head.next;  //
			temp.next = null; //dequeue할 노드의 링크를 끊어준다.
			queueSize--;
			
			return temp.data;
		}else {
			throw new ArrayIndexOutOfBoundsException("큐가 비어있습니다. 데이터 추가를 해주세요.");
		}
		
	}
	
}
