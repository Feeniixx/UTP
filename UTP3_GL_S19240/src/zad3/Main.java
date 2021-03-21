


package zad3;


import zad1.InputConverter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        String fname = System.getProperty("user.home") + "/LamComFile.txt";
        InputConverter<String> fileConv = new InputConverter<>(fname);
        List<String> lines = fileConv.convertBy(flines);
        String text = fileConv.convertBy(flines, join);
        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

        System.out.println(lines);
        System.out.println(text);
        System.out.println(ints);
        System.out.println(sumints);

        List<String> arglist = Arrays.asList(args);
        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
        sumints = slistConv.convertBy(join, collectInts, sum);
        System.out.println(sumints);

        // Przy powierzchownej implementacji
        // następujący fragment:
        slistConv.convertBy(collectInts, sum); // [1] spowoduje powstanie wyjątku ClassCastException

        // Zadania badawcze:
        // jak temu zaradzić w fazie kompilacji programu, tak by kompilator oznaczył [1] jako błąd
        // - wymaga odpowiedniej definicji klasy InputConverter, wszelkie modyfikacje klasy Main są też dozwolone,
        // ale niekonieczne (a nawet niepotrzebne)
    }
}

