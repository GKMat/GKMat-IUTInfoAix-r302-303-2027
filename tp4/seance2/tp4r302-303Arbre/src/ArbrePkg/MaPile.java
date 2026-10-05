package ArbrePkg;

public class MaPile<T> {
	private Node<T> sommet;
	public MaPile() {
        sommet = null;
    }
	public boolean isEmpty() {
        return sommet == null;
    }
	public void empiler(T element) {
        Node<T> nouveau = new Node<T>(element);
        nouveau.suivant = sommet;
        sommet = nouveau;
    }
	public T depiler() {
        if (isEmpty()) {
            return null;
        }
        T element = sommet.element;
        sommet = sommet.suivant;
        return element;
    }
	public T sommet() {
        if (isEmpty()) {
            return null;
        }
        return sommet.element;
    }
	private static class Node<T> {
        private T element;
        private Node<T> suivant;

        public Node(T element) {
            this.element = element;
            this.suivant = null;
        }
    }

}
