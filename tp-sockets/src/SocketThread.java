import java.io.*;
import java.net.Socket;
import java.util.List;

public class SocketThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private List<SocketThread> clients;
    private String clientName;
    public SocketThread(Socket socket, List<SocketThread> clients, String clientName) {
        this.socket = socket;
        this.clients = clients;
        this.clientName = clientName;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void broadcast(String message){
        for (SocketThread client : clients){
               client.out.println(message);
        }
    }
    @Override
    public void run() {
        String message;
        try {
            out.println(clientName);
            while ((message=in.readLine())!= null){
                System.out.println(clientName+ ": "+message);
                broadcast(clientName+": "+ message);
            }
        }catch (IOException e){
            System.out.println(clientName+" disconnected");
        }finally {
            try {
                clients.remove(this);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
