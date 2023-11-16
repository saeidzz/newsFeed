package ir.jiring.assignment.util;

import ir.jiring.assignment.dto.News;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class MessageGenerator {
    private MessageGenerator() {

    }

    public static List<String> generateMessage() {
        List<String> newsList = new ArrayList<>();
        IntStream.range(0, Util.getFrequency()).forEach(i -> newsList.add(getNews()));
        return newsList;
    }

    private static String getNews() {
        StringBuilder newsContent = new StringBuilder();
        IntStream.range(0, Util.nextInt(3, 6)).forEach(i -> {
            newsContent.append(Util.getRandomKeyword());
            newsContent.append(" ");
        });
        short priority = ProbabilityGenerator.getPriority();
        return Util.toJson(News.of(priority, newsContent.toString()));

    }

}
