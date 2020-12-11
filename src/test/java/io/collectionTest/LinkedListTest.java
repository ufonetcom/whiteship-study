package io.collectionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.collectionTest.LinkedList.ListNode;

class LinkedListTest {
	private LinkedList list;
	private ListNode head;
	
	@BeforeEach
	public void init() {
		list = new LinkedList();
		head = list.add(null, new ListNode(20), 0);
		head = list.add(head, new ListNode(40), 1);
		head = list.add(head, new ListNode(60), 2);
		head = list.add(head, new ListNode(80), 3);
		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
