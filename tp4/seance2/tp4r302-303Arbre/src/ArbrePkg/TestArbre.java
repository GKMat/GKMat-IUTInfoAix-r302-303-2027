package ArbrePkg;

public class TestArbre {

    public static void main(String[] args) {

        ArbreBinaire<String> arbre = new ArbreBinaire<>();

        arbre.ajouterRacine("html");

        arbre.ajouterFils("html", "head");
        arbre.ajouterFils("html", "body");

        arbre.ajouterFils("head", "title");
        arbre.ajouterFils("title", "Page test");

        arbre.ajouterFils("body", "h1");
        arbre.ajouterFils("body", "p");

        arbre.ajouterFils("h1", "Titre niveau 1");
        arbre.ajouterFils("p", "Ceci est un paragraphe");

        System.out.println(arbre);
    }
}
