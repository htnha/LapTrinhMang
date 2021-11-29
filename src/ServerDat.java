import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ServerDat {
    public final static int SERVER_PORT = 7;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
                    DataInputStream is = new DataInputStream(socket.getInputStream());
                    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                    String message = is.readUTF();
                    System.out.println("Client:" + message);
                    os.writeUTF("" + sort(message));
                    is.close();
                    os.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Long> sort(String text){
        StringTokenizer stringTokenizer = new StringTokenizer(text," ");
        ArrayList<Long> arrayList = new ArrayList<Long>();
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            long value = Long.parseLong(token);
            arrayList.add(value);
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}

