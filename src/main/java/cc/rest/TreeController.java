package cc.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cc.tree.BinaryTree;
import cc.tree.Node;

@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(path="/binarytree")
public class TreeController {

	private BinaryTree<Integer> intTree = new BinaryTree<>();
	
	@RequestMapping(path = "/addnode/{value}",  method = RequestMethod.PUT)
	public boolean addNode(@PathVariable("value") int value){
		return intTree.addNode(new Node<Integer>(Integer.valueOf(value)));
	}

	@RequestMapping(path = "/removenode/{value}",  method = RequestMethod.DELETE)
	public boolean removeNode(@PathVariable("value") int value){
		return intTree.removeNode(new Node<Integer>(Integer.valueOf(value)));
	}
	
	@RequestMapping(path = "/printtree",  method = RequestMethod.GET)
	public String printtree(){
		return intTree.toString();
	}
	
}
