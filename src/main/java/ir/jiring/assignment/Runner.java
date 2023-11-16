package ir.jiring.assignment;

import ir.jiring.assignment.service.NewsFeed;
import ir.jiring.assignment.util.MessageGenerator;
import ir.jiring.assignment.util.Util;

import java.util.logging.Level;

public class Runner {
    public static void main(String[] args) {
        NewsFeed client = new NewsFeed();
        client.startConnection("127.0.0.1", 6666);

        MessageGenerator.generateMessage().forEach(n -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Util.log(Level.INFO, client.sendMessage(n));
        });
    }
}
