import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter le programme");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    for (Produit produit : metier.getAll()) {
                        System.out.println(produit);
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'ID du produit à rechercher : ");
                    long idRecherche = scanner.nextLong();
                    Produit produit = metier.findById(idRecherche);
                    if (produit != null) {
                        System.out.println("Produit trouvé : " + produit);
                    } else {
                        System.out.println("Aucun produit trouvé avec cet ID.");
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'ID du produit : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consomme la nouvelle ligne restante

                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();

                    System.out.print("Entrez la marque du produit : ");
                    String marque = scanner.nextLine();

                    System.out.print("Entrez le prix du produit : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la nouvelle ligne restante

                    System.out.print("Entrez la description du produit : ");
                    String description = scanner.nextLine();

                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idSup = scanner.nextLong();
                    metier.delete(idSup);
                    System.out.println("Produit supprimé avec succès.");
                    break;

                case 5:
                    System.out.println("Programme terminé.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}