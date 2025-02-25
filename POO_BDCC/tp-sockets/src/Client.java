import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",9090);
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out),true);
        Scanner sc = new Scanner(System.in);
        String msg;
        do {
            System.out.print("Moi : ");
            msg = sc.nextLine();
            pw.println(msg);
            msg = br.readLine();
            System.out.println("Lui : "+msg);
        }while ( !msg.equals("Bye"));

    }
}
