package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alexandr on 21.01.16.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String , Connection>();
    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }
        @Override
        public void run()
        {
            ConsoleHelper.writeMessage("Установлено новое соеденение с адресом:" + this.socket.getRemoteSocketAddress());

            String nameNewClient = null;
            try( Connection connection = new Connection(this.socket))
            {

                nameNewClient = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,nameNewClient));
                sendListOfUsers(connection, nameNewClient);
                serverMainLoop(connection, nameNewClient);



            }
            catch (IOException e){ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");}
            catch (ClassNotFoundException e){ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");}
            if(nameNewClient!=null)
            {
                connectionMap.remove(nameNewClient);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, nameNewClient));
            }
            ConsoleHelper.writeMessage("Connection with server is closed");
        }

        private String serverHandshake(Connection connection) throws IOException,ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME)
                {
                    if (message.getData() != null && !message.getData().isEmpty())
                    {
                        if (!connectionMap.containsKey(message.getData()))
                        {
                            connectionMap.put(message.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return message.getData();
                        }
                    }
                }
            }

        }
        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String ,Connection> pairConection : connectionMap.entrySet())
            {
                if (!pairConection.getKey().equals(userName))
                {
                    Message messageUserAdded = new Message(MessageType.USER_ADDED, pairConection.getKey());
                    connection.send(messageUserAdded);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String messageText = message.getData();
                    String newMessageText = userName +": " + messageText;
                    Message newMessage = new Message(MessageType.TEXT,newMessageText);
                    sendBroadcastMessage(newMessage);
                }
                else ConsoleHelper.writeMessage("Принято не текстовое сообщение");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        ConsoleHelper.writeMessage("введите порт сервера");
        int portServer = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(portServer)){
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true)
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }catch (IOException e){ConsoleHelper.writeMessage("Ошибка сокета");}
    }

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Map.Entry<String ,Connection> pair: connectionMap.entrySet())
            {
                pair.getValue().send(message);
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Сообщение НЕ отправлено: ");
        }

    }
}
