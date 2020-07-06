import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    private boolean isAuthorized = false;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        doAuth();
                        readMessage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        closeConnection();
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during client handler initialization");
        }
    }

    public String getName() {
        return name;
    }

    public void doAuth() throws IOException {
        //Таймер
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                while (true){
                    long currentTime = System.currentTimeMillis();
                    if((currentTime - startTime) == 120000 || isAuthorized) break;
                }
                if(!isAuthorized) closeConnection();
            }
        });
        timer.start();
        while (true) {
            String str = in.readUTF();
            if (str.startsWith("/auth")) {
                String[] parts = str.split("\\s");
                String nickname = server.getAuthService().getNickByLoginAndPass(parts[1], parts[2]);
                if (nickname != null) {
                    if (server.isNickFree(nickname)) {
                        sendMessage("/authok " + nickname);
                        name = nickname;
                        server.broadcastMessage(name + " come in chat");
                        server.subscribe(this);
                        isAuthorized = true;
                        return;
                    } else {
                        sendMessage(String.format("Nickname[%s] is already in use", nickname));
                    }
                } else {
                    sendMessage("Incorrect login and/or password");
                }
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Модифицировано под личные сообщения
    public void readMessage() throws IOException {
        while (true) {
            String strFromClient = in.readUTF();
            if (strFromClient.equals("/end")) {
                return;
            }else if (strFromClient.startsWith("/w ")) {
                String[] tokens = strFromClient.split("\\s");
                String nick = tokens[1];
                String msg = strFromClient.substring(4 + nick.length());
                server.sendMsgToClient(this , nick, msg);
            }
            server.broadcastMessage(String.format("%s: %s", name, strFromClient));
        }
    }
    //Модифицировано для таймера
    public void closeConnection() {
        if(isAuthorized) {
            server.unsubscribe(this);
            server.broadcastMessage(name + " left chat");
        }
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
