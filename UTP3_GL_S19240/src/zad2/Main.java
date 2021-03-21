package zad2;

import zad1.InputConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *  @author Golunko Lizaveta S19240
 *
 */


public class Main {
    public static void main(String[] args) throws IOException {
        NewFunction<String,List<String>> flines = (
                e->{
                    return NewFunction.read(e);
                }
        );
        NewFunction<List<String>,String> join = (
                e->{
                    String ret = "";
                    for (String index : e) {
                        ret += index;
                    }
                    return ret;
                }
        );
        NewFunction<String,List<Integer>> collectInts = (
                e->{
                    String s;
                    List<Integer> ret= new ArrayList<>();
                    Pattern patt = Pattern.compile("\\d+");
                    Matcher math = patt.matcher(e);
                    while (math.find()){
                        ret.add(Integer.valueOf(math.group()));
                    }
                    return ret;
                }
        );
        NewFunction<List<Integer>,Integer> sum = (
                e->{
                    int ret = 0;
                    for (int in:e) {
                        ret+=in;
                    }
                    return ret;
                }
        );

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

        // Zadania badawcze:
        // Operacja flines zawiera odczyt pliku, zatem może powstac wyjątek IOException
        // Wymagane jest, aby tę operację zdefiniowac jako lambda-wyrażenie
        // Ale z lambda wyrażeń nie możemy przekazywac obsługi wyjatków do otaczającego bloku
        // I wobec tego musimy pisać w definicji flines try { } catch { }
        // Jak spowodować, aby nie było to konieczne i w przypadku powstania wyjątku IOException
        // zadziałała klauzula throws metody main
    }
}