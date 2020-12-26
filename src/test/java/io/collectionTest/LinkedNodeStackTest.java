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
@DisplayName("노드 스택 테스트")
class LinkedNodeStackTest {
	LinkedNodeStack nstack;

	@BeforeAll
	void init() {
		nstack = new LinkedNodeStack();
		nstack.push(1);
		nstack.push(3);
		nstack.push(5);
	}
	
	@Test
	@DisplayName("요소 추가 테스트")
	@Order(1)
	void pushTest() {
		System.out.println("추가 : "+nstack.toString());
		assertEquals("[1, 3, 5]", nstack.toString());
		nstack.push(7);
		assertEquals("[1, 3, 5, 7]", nstack.toString());
	}
	
	@Test
	@DisplayName("요소 제거 테스트")
	@Order(2)
	void popTest() {
		assertEquals("[1, 3, 5, 7]", nstack.toString());
		//1,3,5,7 에서 pop 두번
		nstack.pop();
		nstack.pop();
		assertEquals("[1, 3]", nstack.toString());
		
		//1,3에서 pop 두번
		nstack.pop();
		nstack.pop();
		assertEquals("[]", nstack.toString());
		
		//[]에서 pop할 시 exception
		Assertions.assertThrows(IndexOutOfBoundsException.class,()-> { 
			nstack.pop(); 
			});

	}

}
