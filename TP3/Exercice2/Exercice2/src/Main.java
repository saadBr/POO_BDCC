import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        int tab[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int len = tab.length;
        int[][] plages = {{0, 5}, {5, 12}, {12, 20}};
        ExecutorService pool = Executors.newFixedThreadPool(plages.length);

        Sommeur[] sommeurs = new Sommeur[plages.length];

        for (int i = 0; i < plages.length; i++) {
            int debut = plages[i][0];
            int fin = plages[i][1];
            sommeurs[i] = new Sommeur(tab,debut,fin);
            pool.execute( sommeurs[i] );
        }

        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int somme = 0;
        for (Sommeur sommeur : sommeurs) {
            somme += sommeur.getSomme();
        }

        System.out.println("La somme totale du tableau est : " + somme);
    }
}
