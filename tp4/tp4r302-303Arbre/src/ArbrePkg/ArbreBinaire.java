package ArbrePkg;
import java.util.ArrayList;

public class ArbreBinaire<T> {
	private Node<T> root;
	
	public ArbreBinaire(Node<T> root) {
		this.root = root;
	}
	public T getRoot() {
		if (isEmpty()) {
            return null;
        }
        return root.getElement();
        }
	public boolean isEmpty() {
		return root == null;
	}
	
	private void prefixe(Node<T> node) {
		if(node == null) {
			return;
		}
		System.out.println(node.getElement());
		/*prefixe(node.getLeft());
		prefixe(node.getRight());*/
		for (Node<T> child : node.getChildren()) { 
			prefixe(child); 
			}
	}
	public void prefixe() {
		prefixe(root);
	}
	private String prefixeString(Node<T> node) {
		if (node == null) { return ""; }
		String resultat = node.getElement() + " ";
		for (Node<T> child : node.getChildren()) { 
			resultat += prefixeString(child); 
			} 
		return resultat;
	}
	public String toString() { return prefixeString(root); }
	
	private static class Node<T>{
		private T element;
		private ArrayList<Node<T>> children;
		//Node left;
		//Node right;

		/*public Node(T element, Node left, Node right) {
			this.element = element;
			this.children = new ArrayList<>();
			//this.left = left;
			//this.right = right;
		}*/
		public Node (T element) { 
			this.element = element;
			this.children = new ArrayList<>();
			//left = null;
			//right = null;
			}
		public T getElement() { return element;}
		public ArrayList<Node<T>> getChildren() {return children;}		
		public void addChild(Node<T> child) {
		    children.add(child);
		}
		//public Node getLeft() {return left;}
		//public Node getRight() {return right;}

		//public void setRight(Node right) {this.right = right;}
		//public void setLeft(Node left) {this.left = left;}
	}
	
	public static void main(String[] args) {
		/*Node deux = new Node(2);
		//Node plus = new Node("+");
	    Node huit = new Node(8);
	    Node vingt = new Node(20);
	    Node cinq = new Node(5,deux, huit);
	    Node dix = new Node(10,cinq,vingt);
		ArbreBinaire maListe=new ArbreBinaire(dix);
		maListe.prefixe();*/
		ArbreBinaire<String> arbre = new ArbreBinaire<>(null);
		Node<String> cinq = new Node<>("5");
		Node<String> deux = new Node<>("2");
		Node<String> huit = new Node<>("8");
		Node<String> plus = new Node<>("+");
		Node<String> fois = new Node<>("*");
		plus.addChild(cinq);
		plus.addChild(deux);
		fois.addChild(plus);
		fois.addChild(huit);
		arbre.root = fois;
		//arbre.prefixe();
		System.out.println(arbre);
	}
}
