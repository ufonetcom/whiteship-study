package io.collectionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.collectionTest.LinkedList.ListNode;

@DisplayName("LinkedList Test!")
class LinkedListTest {
	private LinkedList list;
	private ListNode head;
	
	@BeforeEach //각 메서드들이 동작하기 전에 실행되는 구문
	public void init() {
		list = new LinkedList();
		head = list.add(null, new ListNode(20), 0);
		head = list.add(head, new ListNode(40), 1);
		head = list.add(head, new ListNode(60), 2);
		head = list.add(head, new ListNode(80), 3);
		
	}
	
	@Test
	@DisplayName("노드 추가 테스트")
	void addTest() {
		assertEquals("[20, 40, 60, 80]", list.toString(head));
		list.add(head, new ListNode(50), 2);
		assertEquals("[20, 40, 50, 60, 80]", list.toString(head));
	}
	
	@Test
	@DisplayName("노드 삭제 테스트")
	void removeTest() {
		assertEquals("[20, 40, 60, 80]", list.toString(head));
		list.remove(head, 2);
		assertEquals("[20, 40, 80]", list.toString(head));
	}
	
	@Test
	@DisplayName("노드 포함 테스트(return boolean)")
	void containsTest() {
		assertEquals("[20, 40, 60, 80]", list.toString(head));
		assertTrue(list.contains(head, new ListNode(20))); //리스트에 20을 포함하고 있으면 성공
		assertFalse(list.contains(head, new ListNode(90))); //리스트에 90을 포함하고 있지 않으면 성공
		
	}

}
