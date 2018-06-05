package cc.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cc.tree.Node;;

public class BinaryTree<T extends Number> {
	private Node<T> root;
	
	public BinaryTree(){
	} 
	
	public boolean addNode(Node<T> node){
		getClassLogger().info("Trying to add "+ String.valueOf(node));
		try{
			return addNode(root, node);
		}catch (Exception e) {
			getClassLogger().error("Something has gone wrong");
		}
		return false;
	}
	
	private Logger getClassLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}

	public boolean removeNode(Node<T> node){
		return removeNode(root, node);
	}

	private boolean removeNode(Node<T> root, Node<T> node) {
		if(root == null || node == null){
			return false;
		}
		
		if(this.root.value.longValue() == node.value.longValue()){
			addNode(this.root.right, this.root.left);
			this.root = this.root.right;
			return true;
		}
	
		if(root.value.longValue() > node.value.longValue()){
			
			if(root.left == null){
				return false;
			}
			
			if(root.left.value.longValue() == node.value.longValue()){
				Node<T> tmp = root.left;
				root.left = null;
				addNode(root, tmp.left);
				addNode(root, tmp.right);
				return true;
			}
			
			return removeNode(root.left, node);
		}
		
		if(root.right == null){
			return false;
		}
		
		if(root.right.value.longValue() == node.value.longValue()){
			Node<T> tmp = root.right;
			root.right = null;
			addNode(root, tmp.left);
			addNode(root, tmp.right);
			return true;
		}
		
		return removeNode(root.right, node);
	}
	
	


	private boolean addNode(Node<T> root, Node<T> node) {
		
		if(node == null){
			return false;
		}
		
		if(this.root == null){
			this.root = node;
			return true;
		}
		
		if(root.value.longValue() < node.value.longValue()){
			if(root.right == null){
				root.right = node;
				return true;
			}
			return addNode(root.right, node);
		}
		else{
			if(root.left == null){
				root.left = node;
				return true;
			}
			return addNode(root.left, node);
		}
	}

	public boolean isNodeExists(Node<T> node){
		return false;
	}
	
	@Override
	public String toString() {
		return printTree(this.root);
	}
	
	private String printTree(Node<T> root){
		if(root == null){
			return null;
		}
		
		long value = root.value.longValue();
		return "["+value +" L:"+ printTree(root.left) + " "+value+" R:" + printTree(root.right) +" ]";
	}
	

	public Node<T> getRoot() {
		return this.root;
	}
}
