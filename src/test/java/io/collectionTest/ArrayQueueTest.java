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
@DisplayName("정수형 배열 큐 테스트")
class ArrayQueueTest {
	ArrayQueue queue;
	
	@BeforeAll
	void init() {
		//생성 시 0(default)값이 차지 않도록 배열의 길이를 맞춰준다.
		//길이를 생성하지 않을 경우, enqueue메소드에서 배열을 따로 생성해준다.
		queue = new ArrayQueue(3);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(5);
	}
	
	@Test
	@DisplayName("요소 추가 테스트")
	@Order(1)
	void enqueueTest() {
		assertEquals("[1, 3, 5]", queue.toString());
		
		//길이가 3인 꽉찬배열에 요소를 삽입할 때
		queue.enqueue(7);
		assertEquals("[1, 3, 5, 7]", queue.toString());
	}
	
	
	@Test
	@DisplayName("요소 제거 테스트")
	@Order(2)
	void dequeueTest() {
		assertEquals("[1, 3, 5, 7]", queue.toString());
		
		//1,3,5,7 중 먼저들어온 1을 pop
		queue.dequeue();
		assertEquals("[3, 5, 7]", queue.toString());
		
		queue.dequeue();  //3 pop
		queue.dequeue();  //5 pop
		queue.dequeue();  //7 pop
		assertEquals("[]", queue.toString());
		
		//[]에서 dequeue할 시 exception
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()-> { 
			queue.dequeue(); 
			});
		
	}

}
