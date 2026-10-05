package ArbrePkg;

import java.util.ArrayList;

public class ArbreBinaire<T> {

    private Node<T> root;
    
    public ArbreBinaire() {
        root = null;
    }
    public ArbreBinaire(T element) {
        root = new Node<T>(element);
    }
    public Node<T> ajouterRacine(T element) {
        if (root != null) {
            throw new IllegalStateException("La racine existe déjà.");
        }
        root = new Node<T>(element);
        return root;
    }
    public Node<T> getRoot() {
        return root;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public Node<T> ajouterFils(Node<T> parent, T enfant) {
        if (parent == null) {
            return null;
        }
        Node<T> nouveau = new Node<T>(enfant);
        parent.addChild(nouveau);
        return nouveau;
    }
    private void prefixe(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getElement());
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
    private void prefixeString(Node<T> node, StringBuilder resultat) {
        if (node == null) {
            return;
        }
        resultat.append(node.getElement()).append(" ");
        for (Node<T> child : node.getChildren()) {
            prefixeString(child, resultat);
        }
    }
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        prefixeString(root, resultat);
        return resultat.toString().trim();
    }
    public static class Node<T> {
        private T element;
        private ArrayList<Node<T>> children;
        public Node(T element) {
            this.element = element;
            this.children = new ArrayList<>();
        }
        public T getElement() {
            return element;
        }
        public ArrayList<Node<T>> getChildren() {
            return children;
        }
        private void addChild(Node<T> child) {
            children.add(child);
        }
    }
}
