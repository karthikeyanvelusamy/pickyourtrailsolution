package com.pickyourtrail.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Driver class for running the super stack operations
 * 
 * @author Karthikeyan
 *
 */
public class SuperStackDriver {

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// This will read the number of operations
		int n = Integer.parseInt(reader.readLine());
		// Instantiating the stack
		SuperStack stack = new SuperStack();

		while (n-- > 0) {
			String[] data = reader.readLine().split("\\ ");
			String opr = data[0];
			if (opr.equals("push")) {
				int value = Integer.parseInt(data[1]);
				stack.push(value);
			} else if (opr.equals("pop")) {
				stack.pop();
			} else if (opr.equals("inc")) {
				int elementCount = Integer.parseInt(data[1]);
				int increVal = Integer.parseInt(data[2]);
				stack.incr(elementCount, increVal);
			}

			Integer top = stack.peek();
			System.out.println((top == null) ? "EMPTY" : top);
		}

	}

}

/**
 * The SuperStack class will give the stack operations push,pop,peek and
 * additionally icrementing the values by O(1) by the doubly linked list
 * implementation
 * 
 * 
 *
 */
class SuperStack {

	private Node head;
	private Node tail;

	public void push(int value) {
		Node n = new Node(value, null, null);
		if (head == null) {
			head = n;
			tail = head;
		} else {
			head.prev = n;
			n.next = head;
			head = n;
		}
	}

	public Integer pop() {
		if (head != null) {
			Node value = head;
			head = head.next;
			if (head == null) {
				tail = head;
			}

			return value.value;
		}
		return null;
	}

	public Integer peek() {
		return (head != null) ? head.value : null;
	}

	public void incr(int bottomElementCount, int incrementVal) {
		if (tail != null) {
			Node tmp = tail;
			while (bottomElementCount-- > 0) {
				tmp.value += incrementVal;
				tmp = tmp.prev;
			}
		}

	}
}

class Node {

	int value;
	Node next;
	Node prev;

	public Node(int value, Node next, Node prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

}
