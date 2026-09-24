package SinglyListPkg;

public class SinglyListClass {
	private Node header;
	public SinglyListClass(Node header) {
		this.header = header;
	}
	public Integer getHeader() {return header.element;}
	public void addLast(Integer element) {
		Node newNode = new Node(element);
		Node tmpHeader=header;
		if (header==null) {
			header = newNode;
			return;
		}
		while(tmpHeader.getNext() != null) { 
			tmpHeader = tmpHeader.getNext();
		}
		tmpHeader.setNext(newNode);
	}
    public boolean isEmpty() {
        return header == null;
    }
    public Integer first() {
        if (isEmpty()) {
            return null;
        }
        return header.element;
    }
    public Integer last() {
        if (isEmpty()) {
            return null;
        }
        Node tmpHeader = header;
        while (tmpHeader.next != null) {
        	tmpHeader = tmpHeader.next;
        }
        return tmpHeader.element;
    }
	private static class Node {
		private Integer element;
		Node next;
		
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node(Integer element) {
			this.element = element;
			next = null;
		}
		public Integer getElement() { return element;}
		public void setElement(Integer element) { this.element = element;}
		public String toString() {
			return element.toString();
		}
	}
	
	public static void main(String[] args) {
		SinglyListClass maListe=new SinglyListClass(null);
		maListe.addLast(4);
		System.out.println(maListe.getHeader());
	}
}