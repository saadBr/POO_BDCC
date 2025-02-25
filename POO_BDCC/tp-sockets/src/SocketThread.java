import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class SocketThread extends Thread {
    private Socket s;
    private int magic;
    private String name;
    private List<Socket> sockets;
    public SocketThread(Socket s,int magic,List<Socket> sockets) {
        this.s = s;
        this.magic = magic;
        this.sockets = sockets;
    }
    private void broadcastmessage() throws IOException {
        for (Socket s:sockets){
            if(s!=this.s){
                OutputStream out = s.getOutputStream();
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(out),true);
                pw.println(name+ " a gagne");
            }
        }
    }
    @Override
    public void run() {
        try {
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out),true);
            Scanner sc = new Scanner(System.in);
            int nbMagic;
            pw.println("Welcome , enter your name :");
            name = br.readLine();
            do {
                nbMagic = Integer.parseInt(br.readLine());
                if (nbMagic > magic) {
                    pw.println("Entrez un nombre inferieure");
                } else if (nbMagic < magic) {
                    pw.println("Entrez un nombre superieure");
                }
                else {
                    pw.println("Bravo, vous avez gagne");
                    broadcastmessage();
                }
            }while (nbMagic != magic);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
