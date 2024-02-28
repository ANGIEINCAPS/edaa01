package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> q1;
	private FifoQueue<Integer> q2;

	@BeforeEach
	void setUp() throws Exception {
		q1 = new FifoQueue<Integer>();
		q2 = new FifoQueue<Integer>();

	}

	@AfterEach
	void tearDown() throws Exception {
		q1 = null;
		q2 = null;

	}

	@Test
	void testConcatEmpty() {
		q1.append(q2);
		
		assertEquals(0, q1.size(), "Wrong size after concatenation");
		assertTrue(q1.isEmpty(), "q1  not empty after concatenation");
		assertTrue(q2.isEmpty(), "q2 not empty after concatenation");
	}

	@Test
	void testConcatEmptyToNonEmpty() {
		q1.offer(1);
		q1.offer(2);
		q1.append(q2);
		
		Iterator<Integer> itr = q1.iterator();
		
		for (int i = 1; i <= 2; i++) {
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
		}
		
		assertEquals(2, q1.size(), "Wrong size after concatenation");
		assertTrue(q2.isEmpty(), "q2 not empty after concatenation");
	}

	@Test
	void testConcatNonEmptyToEmpty() {
		q2.offer(1);
		q2.offer(2);
		q1.append(q2);
		
		Iterator<Integer> itr = q1.iterator();
		
		for (int i = 1; i <= 2; i++) {
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from next");
		}


		assertEquals(2, q1.size(), "Wrong size after concatenation");
		assertTrue(q2.isEmpty(), "q2 not empty after concatenation");
	}

	@Test
	void testConcat() {
		q1.offer(1);
		q1.offer(2);
		q2.offer(3);
		q2.offer(4);
		
		q1.append(q2);
		
		Iterator<Integer> itr = q1.iterator();
		
		for (int i = 1; i <= 4; i++) {
			assertEquals(Integer.valueOf(i), itr.next(), "Wrong result from itr.next");
		}
		
		assertEquals(4, q1.size(), "Wrong size after concatenation");
		assertTrue(q2.isEmpty(), "q2 not empty after concatenation");
	}
	
	@Test
	void testSelfConcat() {
		q1.offer(1);
		q1.offer(2);
		
		assertThrows(IllegalArgumentException.class, () -> q1.append(q1));	}

}