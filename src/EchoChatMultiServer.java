
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoChatMultiServer {
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
                    WorkerThread thread = new WorkerThread(socket);
                    thread.start();
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