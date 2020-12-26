package io.collectionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("노드 큐 테스트")
class LinkedNodeQueueTest {
	LinkedNodeQueue nqueue;
	
	@BeforeAll
	void init() {
		nqueue = new LinkedNodeQueue();
		nqueue.enqueue(1);
		nqueue.enqueue(3);
		nqueue.enqueue(5);
	}
	
	@Test
	@Order(1)
	@DisplayName("노드 큐 요소 삽입 테스트")
	void enqueueTest() {
		assertEquals("[1, 3, 5]", nqueue.toString());
		
		nqueue.enqueue(7);
		assertEquals("[1, 3, 5, 7]", nqueue.toString());
	}
	
	
	@Test
	@Order(2)
	@DisplayName("노드 큐 요소 삭제 테스트")
	void dequeueTest() {
		assertEquals("[1, 3, 5, 7]", nqueue.toString());
		
		nqueue.dequeue();
		assertEquals("[3, 5, 7]", nqueue.toString());
		
		nqueue.dequeue();
		nqueue.dequeue();
		nqueue.dequeue();
		assertEquals("[]", nqueue.toString());
		
		//[]에서 dequeue를 시도할 경우 exception
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()-> { 
			nqueue.dequeue(); 
			});
	}

}
