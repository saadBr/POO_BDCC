import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServerMultiThread {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Random r = new Random();
        int nbMagic = r.nextInt(100);
        List<Socket> sockets = new ArrayList<>();
        while (true) {
            Socket s = ss.accept();
            sockets.add(s);
            SocketThread st = new SocketThread(s,nbMagic, sockets);
            st.start();
        }
    }
}
