package ArbrePkg;
import java.util.ArrayList;

public class ArbreBinairetest<T> {
	private Node<T> root;
	
	public ArbreBinairetest(Node<T> root) {
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
	private void postfixe(Node<T> node) {
	    if (node == null) {
	        return;
	    }

	    for (Node<T> child : node.getChildren()) {
	        postfixe(child);
	    }

	    System.out.println(node.getElement());
	}
	public void postfixe() {
	    postfixe(root);
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
	public void construireExpression() {
	    Node<String> deux = new Node<>("2");
	    Node<String> trois = new Node<>("3");
	    Node<String> cinq = new Node<>("5");
	    Node<String> neuf = new Node<>("9");
	    Node<String> un = new Node<>("1");
	    Node<String> quatre = new Node<>("4");

	    Node<String> plus1 = new Node<>("+");
	    plus1.addChild(deux);
	    plus1.addChild(trois);

	    Node<String> fois1 = new Node<>("*");
	    fois1.addChild(plus1);
	    fois1.addChild(cinq);

	    Node<String> plus2 = new Node<>("+");
	    plus2.addChild(trois);
	    plus2.addChild(quatre);

	    Node<String> plus3 = new Node<>("+");
	    plus3.addChild(un);
	    plus3.addChild(plus2);

	    Node<String> fois2 = new Node<>("*");
	    fois2.addChild(plus3);
	    fois2.addChild(new Node<>("3"));

	    Node<String> moins1 = new Node<>("-");
	    moins1.addChild(neuf);
	    moins1.addChild(fois2);

	    Node<String> moins2 = new Node<>("-");
	    moins2.addChild(fois1);
	    moins2.addChild(moins1);

	    root = (Node<T>) moins2;
	}

	
	public static void main(String[] args) {
		/*Node deux = new Node(2);
		//Node plus = new Node("+");
	    Node huit = new Node(8);
	    Node vingt = new Node(20);
	    Node cinq = new Node(5,deux, huit);
	    Node dix = new Node(10,cinq,vingt);
		ArbreBinaire maListe=new ArbreBinaire(dix);
		maListe.prefixe();
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
		System.out.println(arbre);*/
		ArbreBinairetest<String> arbre = new ArbreBinairetest<>(null);

	    arbre.construireExpression();

	    System.out.println("Postfixe :");
	    arbre.postfixe();
	}
}
