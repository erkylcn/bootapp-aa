package cc.tree;

public class Node<T> {
	Node<T> left;
	Node<T> right;
	T value;
	
	public Node(T t) {
		this.value = t;
	}
}
