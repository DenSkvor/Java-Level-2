import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scn;
    private Thread msgOut;

    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println(serverSocket.getInetAddress().toString());
            System.out.println(serverSocket.getLocalPort());

            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();

            System.out.println("Клиент подключился");
            System.out.println(socket.toString());

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scn = new Scanner(System.in);

            msgOut = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println("Введите сообщение");
                        String outMessage = scn.nextLine();
                        sendMsg(outMessage);
                        if (outMessage.equalsIgnoreCase("/end")) {
                            close();
                        }
                    }

                }
            });

            msgOut.start();

            while (true) {
                String msgFromClient = in.readUTF();
                System.out.println("Клиент: " + msgFromClient);
                if (msgFromClient.equalsIgnoreCase("/end")) {
                    sendMsg("/end");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент отключился");
        }

    }

    public void sendMsg(String msg) {
        if (!msg.trim().isEmpty()) {
            try {
                out.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(msg);
        }
    }

    public void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scn.close();
    }

}