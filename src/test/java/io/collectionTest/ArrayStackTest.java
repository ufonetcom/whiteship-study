package io.collectionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

//테스트 시 @BeforeEach와는 다르게 @BeforeAll을 사용한다면, testInstance어노테이션으로
//라이프 사이클을 클래스 단위로 설정 가능. @BeforeAll 어노테이션을 static method가 아닌 곳에서도 사용 가능.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class) //@Order 를 사용하기 위한 선언.
@DisplayName("정수형 배열 스택 테스트")
class ArrayStackTest {
	ArrayStack stack;
	
	//테스트 메서드 전체가 실행되기 이전에 딱 한번 실행되는 어노테이션.
	@BeforeAll
	void init() {
		stack = new ArrayStack(4); //스택의 길이 생성.
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
	}
	
	@Test
	@Order(1)
	@DisplayName("요소 추가 테스트")
	void pushTest() {
		assertEquals("[1, 3, 5, 7]", stack.toString());
		
		stack.push(9); //현재 길이가 4인 스택에 추가하려 할때.
		
		assertEquals("[1, 3, 5, 7, 9]", stack.toString());
	}

	@Test
	@Order(2)
	@DisplayName("요소 제거 테스트") 
	void popTest() {
		assertEquals("[1, 3, 5, 7, 9]", stack.toString());

		stack.pop();
		stack.pop();
		assertEquals("[1, 3, 5]", stack.toString());
		
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals("[]", stack.toString());
		
//		stack.pop();
		assertThrows(EmptyStackException.class, () -> stack.pop(), "스택이 비어있습니다.");
	}
}
