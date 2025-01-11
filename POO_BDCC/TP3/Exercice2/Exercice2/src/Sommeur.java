public class Sommeur implements Runnable{
    private int debut,fin, somme;
    private int[] tab;

    public Sommeur(int[] tab, int debut, int fin) {
        this.tab = tab;
        this.debut = debut;
        this.fin = fin;
        this.somme = 0;
    }
    public void run() {
        for (int i = debut; i < fin ; i++)
        {
            somme += tab[i];
        }
    }

    public int getSomme() {
        return somme;
    }
}

