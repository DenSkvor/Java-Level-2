import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client  {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Scanner scn;
    private Thread msgIn;
    private Thread msgOut;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start() {
        try {
            scn = new Scanner(System.in);
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        msgIn = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String msgFromServer = in.readUTF();
                        System.out.println("Сервер: " + msgFromServer);
                        if(msgFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        msgOut = new Thread(new Runnable() {
            @Override
            public void run() {
                    while (true) {
                        System.out.println("Введите сообщение");
                        String outMessage = scn.nextLine();
                        sendMsg(outMessage);
                        if (outMessage.equalsIgnoreCase("/end")) {
                            break;
                        }
                    }
            }
        });

        msgIn.start();
        msgOut.start();

        try {
            msgIn.join();
            msgOut.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        close();

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
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scn.close();
    }

}
