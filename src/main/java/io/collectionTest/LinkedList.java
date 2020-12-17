package io.collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedList {
	
	static class ListNode { //public->static.. test클래스 문제
		private int data;
		private ListNode next;
		
		public ListNode(int input) {
			this.data = input;
			this.next = null;
		}
	}
	
	
	public LinkedList() {}
	
	public LinkedList(int input) {
		add(null, new ListNode(input), 0);
	}
	public LinkedList(ListNode nodeToAdd) {
		add(null, nodeToAdd, 0);
	}

	// add
	public ListNode add(ListNode head, ListNode nodeToAdd, int position) {// 가장 앞의 노드, 추가할노드, 추가할노드의 인덱스
		
		if(head == null) return nodeToAdd;
		
		//addFirst
		if(position==0) {
			nodeToAdd.next = head;
			return nodeToAdd;
		}
		
		ListNode x = head;
		for (int i = 0; i < position-1; i++) { // 추가할 노드의 이전노드를 구한다.
			x = x.next;
		}
		
		nodeToAdd.next = x.next;
		x.next = nodeToAdd;

		return head;
	}

	// remove
	public ListNode remove(ListNode head, int positionToRemove) {
		ListNode returndata; // remove메서드는 반환값이 해당 노드로 되어있기 때문에 그것을 받을 변수.
		ListNode x = head; // 첫번째 요소인 head를 x에 담는다. (x가 head를 가리킨다.)
		ListNode todoDeleted; // 실제로 제거해야 할 노드

		for (int i = 0; i < positionToRemove - 1; i++) { // 해당position의 이전 노드를 찾는다.
			x = x.next;
		}

		ListNode tmp = x; // 삭제할 노드의 이전 노드를 tmp에 담는다.
		todoDeleted = tmp.next; // tmp의 다음 노드가 삭제할 노드이기때문에 삭제할 노드를 담는다.
		tmp.next = tmp.next.next; // 바로 노드를 삭제하지 않고 링크 작업을 실행한다.

		returndata = todoDeleted; // 노드가 제거되도 제거된 노드를 반환 해주어야하기 때문에 반환변수에 담는다.
		todoDeleted = null; // 모든 링크작업을 맞춘 후 해당 노드를 삭제한다.

		return returndata;

	}

	// contains
	boolean contains(ListNode head, ListNode nodeTocheck) {// 가장 앞 헤더, 찾을 노드.
		ListNode x = head;

		while (x != null) { // x노드가 null이 아니면 돌린다.
			if (x.data == nodeTocheck.data) { // x의 데이터와 찾을노드의 데이터가 같다면 true반환.
				return true;
			}
			x = x.next; // 아니면 다음노드를 탐색.
		}

		return false;
	}
	
	public String toString(ListNode head) {
		if(head == null) return "";
		
		List<String> nodes = new ArrayList<>();
		ListNode tmp = head;
		
		while(head != null) {
			nodes.add(String.valueOf(head.data));
			head = head.next;
		}
		head = tmp;
		int size=0;
		String[] array = new String[nodes.size()];
		for(String print : nodes) {
			array[size++] = print;
		}
		return Arrays.toString(array);
	}

}
