package ir.jiring.assignment.service;

import ir.jiring.assignment.exception.MessageSendingException;
import ir.jiring.assignment.exception.SocketStartingException;
import ir.jiring.assignment.exception.SocketStoppingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NewsFeed {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;


    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException exception) {
            throw new SocketStartingException();
        }
    }

    public String sendMessage(String news) {
        try {
            out.println(news);
            return in.readLine();
        } catch (IOException exception) {
            throw new MessageSendingException();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException exception) {
            throw new SocketStoppingException();
        }
    }
}
