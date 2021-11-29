import java.io.*;
import java.net.*;
public class EchoChatSingleServer {
    public final static int SERVER_PORT = 7;
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client accepted: " + socket);
                    DataInputStream is = new DataInputStream(socket.getInputStream()) ;
                    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                    String messageFromClient;
                    do{
                        messageFromClient = is.readUTF();
                        StringBuilder input1 = new StringBuilder();
                        input1.append(messageFromClient);
                        os.writeUTF(input1.reverse().toString());
                        os.flush();
                    }while(!messageFromClient.equalsIgnoreCase("quit"));
                    os.close();
                    is.close();
                    socket.close();
                } catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}