package java8.chap04.streams.traders;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by aaron on 16-12-13.
 */
public class TraderStream {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high).");
        List<Transaction> transactions2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(transactions2011);
        System.out.println();

        System.out.println("2. What are all the unique cities where the traders work?");
        Set<String> uniqueCities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toSet());
        System.out.println(uniqueCities);
        System.out.println();

        System.out.println("3. Find all traders from Cambridge and sort them by name.");
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
        System.out.println(tradersFromCambridge);
        System.out.println();

        System.out.println("4. Return a string of all traders’ names sorted alphabetically.");
        Optional<String> allNames = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce(String::concat);
        System.out.println(allNames);

        System.out.println("5. Are any traders based in Milan?");
        if (transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println();

        System.out.println("6. Print all transactions’ values from the traders living in Cambridge.");
        List<Integer> transactionValues = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());
        System.out.println(transactionValues);
        System.out.println();

        System.out.println("7. What’s the highest value of all the transactions?");
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);
        System.out.println();

        System.out.println("8. Find the transaction with the smallest value.");
        Optional<Transaction> smallestValueTransaction = transactions.stream()
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b);
        System.out.println(smallestValueTransaction);


    }
}
