package AdvancedCSharp_11Oct_2015;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04SrabskoUnleashed {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> srabskoStatistics = new LinkedHashMap<>();
        String inputLine = inputScanner.nextLine();

        while (!inputLine.equals("End")) {

            Pattern srabskoPattern = Pattern.compile("([\\w\\s]+)\\s@([a-zA-z\\s]+)\\s(\\d+)\\s(\\d+)");
            Matcher srabskoMatcher = srabskoPattern.matcher(inputLine);
            if (srabskoMatcher.find()) {
                String venue = srabskoMatcher.group(2);
                String singer = srabskoMatcher.group(1);
                int ticketPrice = Integer.parseInt(srabskoMatcher.group(3));
                int ticketCount = Integer.parseInt(srabskoMatcher.group(4));

                if (!srabskoStatistics.containsKey(venue)) {
                    srabskoStatistics.put(venue, new LinkedHashMap<>());
                }

                if (!srabskoStatistics.get(venue).containsKey(singer)) {
                    srabskoStatistics.get(venue).put(singer, ticketCount * ticketPrice);
                } else {
                    int oldValue = srabskoStatistics.get(venue).get(singer);
                    srabskoStatistics.get(venue).put(singer, oldValue + ticketCount * ticketPrice);
                }
            }

            inputLine = inputScanner.nextLine();
        }

        for (String venue : srabskoStatistics.keySet()) {
            System.out.printf("%s%n", venue);
            srabskoStatistics.get(venue)
                    .entrySet()
                    .stream()
                    .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                    .forEach(pair -> System.out.printf("#  %s -> %d%n", pair.getKey(), pair.getValue()));
        }
    }
}