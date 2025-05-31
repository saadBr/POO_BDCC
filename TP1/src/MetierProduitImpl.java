import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    public List<Produit> produits = new ArrayList<>();
    @Override
    public void add(Produit p) {
        produits.add(p);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit produit = findById(id);
        if (produit != null) {
            produits.remove(produit);
        }
    }
}
