import java.io.*;
import java.net.Socket;

public class WorkerThread extends Thread {
    private Socket socket;
    public WorkerThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            System.out.println("Client accepted: " + socket);
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            String messageFromClient;
            do {
                messageFromClient = is.readUTF();
                StringBuilder input1 = new StringBuilder();
                input1.append(messageFromClient);
                os.writeUTF(input1.reverse().toString());
                os.flush();
            } while (!messageFromClient.equalsIgnoreCase("quit"));
            os.close();
            is.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
