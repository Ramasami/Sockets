package echo;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9200);
        BufferedReader systemBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        BufferedReader socketBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {
        String input = systemBufferedReader.readLine();

        printWriter.println(input);

        String output = socketBufferedReader.readLine();
        System.out.println(output);
        }
    }
}
