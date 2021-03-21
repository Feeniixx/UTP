package zad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface NewFunction<T, R> extends Function<T,R> {
    static List read(String s){
        List<String> ret = new ArrayList<>();
        try {
            ret = Files.readAllLines(Paths.get(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


    R call(T input) throws IOException;

    @Override
    default R apply(T input) {
        try {
            return call(input);
        } catch (IOException e) {
            System.out.println("Flines: Błąd odczytu pliku LamComFile.txt : NoSuchFileException");

        }
        return null;
    }
}


