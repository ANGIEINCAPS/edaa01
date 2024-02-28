package queue_singlelinkedlist;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param e the element to insert
	 * @return true if it was possible to add the element to this queue, else false
	 */
	public boolean offer(E e) {
		if (e == null) {
			return false;
		}
		QueueNode<E> n = new QueueNode<E>(e);

		if (last == null) {
			last = n;
			n.next = n;
		} else {
			n.next = last.next;
			last.next = n;
			last = n;
		}
		size++;
		return true;
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		}

		return last.next.element;

	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is empty.
	 * post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		}

		QueueNode<E> first = last.next;

		if (last == last.next) { // only one node in queue
			last = null; // LAST.NEXT ???
		} else {
			last.next = first.next; // multiple nodes left
		}

		size--;
		return first.element;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		/* remaining elements left to traverse */
		private int rem;

		/* Konstruktor */
		private QueueIterator() {
			if (last != null) {
				pos = last.next; // initialize pos to first element // initialize startPos to first element
			} else {
				pos = null;
			}
			rem = size;
		}

		public boolean hasNext() {
			return rem > 0;
		}

		/* Return element of current position, then move to next node */
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			E element = pos.element;
			pos = pos.next;
			rem--;
			return element;
		}
	}

	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * to this queue. The specified queue (q) is empty after the call.
	 * 
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q) {
		if (q == this) {
			throw new IllegalArgumentException();
		}

		if (q.last == null || q.size() == 0) {
			return;
		}

		if (last == null) {
			this.last = q.last;
		} else {
			QueueNode<E> temp = this.last.next;
			this.last.next = q.last.next;
			this.last = q.last;
			this.last.next = temp;
		}

		this.size += q.size();
		q.last = null;
		q.size = 0;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}