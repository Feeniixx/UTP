/**
 *
 *  @author Golunko Lizaveta S19240
 *
 */

package zad1;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Function<String,List<String>> flines = (
                e->{
                    List<String> ret = new ArrayList<>();
                    try {
                        ret = Files.readAllLines(Paths.get(e));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    return ret;
                }
        );
        Function<List<String>,String> join = (
                e->{
                    String ret = "";
                    for (String index : e) {
                        ret += index;
                    }
                    return ret;
                }
        );
        Function<String, List<Integer>> collectInts = x ->{

            List<Integer> obj= new ArrayList<>();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(x);
            while (matcher.find()){
                obj.add(Integer.valueOf(matcher.group()));
            }
            return obj;
        };
        Function<List<Integer>,Integer> sum = (
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

    }
}
