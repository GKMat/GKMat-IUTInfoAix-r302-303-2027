package ArbrePkg;

public class TestExpression {

    public static void main(String[] args) {

        ArbreBinaire<String> arbre = new ArbreBinaire<>();

        ArbreBinaire.Node<String> moins =
                arbre.ajouterRacine("-");

        ArbreBinaire.Node<String> multiplication1 =
                arbre.ajouterFils(moins, "*");

        ArbreBinaire.Node<String> moins2 =
                arbre.ajouterFils(moins, "-");

        ArbreBinaire.Node<String> addition1 =
                arbre.ajouterFils(multiplication1, "+");

        arbre.ajouterFils(multiplication1, "5");

        arbre.ajouterFils(addition1, "2");
        arbre.ajouterFils(addition1, "3");

        arbre.ajouterFils(moins2, "9");

        ArbreBinaire.Node<String> multiplication2 =
                arbre.ajouterFils(moins2, "*");

        ArbreBinaire.Node<String> addition2 =
                arbre.ajouterFils(multiplication2, "+");

        arbre.ajouterFils(multiplication2, "3");

        arbre.ajouterFils(addition2, "1");

        ArbreBinaire.Node<String> addition3 =
                arbre.ajouterFils(addition2, "+");

        arbre.ajouterFils(addition3, "3");
        arbre.ajouterFils(addition3, "4");

        System.out.println("Préfixe :");
        arbre.prefixe();

        System.out.println();

        System.out.println("Postfixe :");
        arbre.postfixe();

        System.out.println();

        System.out.println("ToString :");
        System.out.println(arbre);
    }
}
