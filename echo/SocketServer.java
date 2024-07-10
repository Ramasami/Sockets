package echo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9200);
        while (true) {
            System.out.println("Connecting");
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            Thread thread = new Thread(() -> readAndWrite(bufferedReader, printWriter));
            thread.start();
        }
    }

    private static void readAndWrite(BufferedReader bufferedReader, PrintWriter printWriter) {
        try {
            while (true) {
                String input = null;
                input = bufferedReader.readLine();
                printWriter.println("Server Says: " + input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
