import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMultiThread {
    private static final int PORT = 9092;
    public static List<SocketThread> clients = new ArrayList<>();
    private static int id = 1;
    public static void main(String[] args){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server is running on port "+PORT);
            while (true){
                Socket clientSocket = serverSocket.accept();
                String clientName = "Client "+id++;
                System.out.println(clientName+ " connected.");
                SocketThread clientThread = new SocketThread(clientSocket,clients,clientName);
                clients.add(clientThread);
                clientThread.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
