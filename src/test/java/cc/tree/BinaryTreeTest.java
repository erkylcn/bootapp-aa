package cc.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cc.tree.BinaryTree;
import cc.tree.Node;


public class BinaryTreeTest {

	
	@Test
	public void rootIsNull(){
		BinaryTree<Integer> tree = new BinaryTree<>();
		
		assertNull(tree.getRoot());
	}
	
	@Test
	public void rootIsNotNull(){
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.addNode(new Node<Integer>(12));
		assertNotNull(tree.getRoot());
	}
	

	@Test
	public void nullNodeNotInserted(){
		BinaryTree<Integer> tree = new BinaryTree<>();
		assertFalse(tree.addNode(null));
	}
	
	@Test
	public void nodeNotInserted(){
		BinaryTree<Integer> tree = new BinaryTree<>();
		assertTrue(tree.addNode(new Node<Integer>(12)));
		assertEquals(12L, tree.getRoot().value.longValue());
		assertTrue(tree.addNode(new Node<Integer>(13)));
		assertTrue(tree.addNode(new Node<Integer>(11)));
		assertTrue(tree.addNode(new Node<Integer>(9)));
		assertTrue(tree.addNode(new Node<Integer>(8)));
		assertTrue(tree.addNode(new Node<Integer>(15)));
		assertTrue(tree.removeNode(new Node<Integer>(12)));
		assertEquals("[13 L:[11 L:[9 L:[8 L:null 8 R:null ] 9 R:null ] 11 R:null ] 13 R:[15 L:null 15 R:null ] ]", tree.toString());
		assertEquals(13L, tree.getRoot().value.longValue());
		assertTrue(tree.removeNode(new Node<Integer>(9)));
		assertTrue(tree.removeNode(new Node<Integer>(11)));
		assertTrue(tree.removeNode(new Node<Integer>(13)));
		assertEquals(15L, tree.getRoot().value.longValue());
		assertTrue(tree.removeNode(new Node<Integer>(8)));
		assertTrue(tree.removeNode(new Node<Integer>(15)));
		assertNull(tree.getRoot());
	}	
}
