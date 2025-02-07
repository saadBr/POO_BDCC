package ma.enset.tp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ProductController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private ListView<Product> productListView;

    // Liste des produits
    private final ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        productListView.setItems(productList); // Lier la liste observable à la ListView
    }

    @FXML
    public void addProduct() {
        String name = nameField.getText();
        String priceText = priceField.getText();

        // Vérifier que les champs ne sont pas vides
        if (name.isEmpty() || priceText.isEmpty()) {
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            Product product = new Product(name, price);
            productList.add(product);

            // Réinitialiser les champs
            nameField.clear();
            priceField.clear();
        } catch (NumberFormatException e) {
            System.out.println("Prix invalide !");
        }
    }
}