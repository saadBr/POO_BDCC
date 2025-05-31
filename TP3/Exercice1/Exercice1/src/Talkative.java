public class Talkative implements Runnable {
    private int valeur;
    public Talkative(int valeur) {
        this.valeur = valeur;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(valeur+" ");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Talkative(i)).start();
        }
    }
}
