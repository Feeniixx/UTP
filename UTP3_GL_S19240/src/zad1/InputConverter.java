/**
 *
 *  @author Kostiuk Taras S19461
 *
 */


package zad1;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {
    private T fileName;

    public InputConverter(T fileName) {
        super();
        this.fileName = fileName;
    }


    public <U> U convertBy(Function...funkcja){

        List tmp = new LinkedList();

        tmp.add(funkcja[0].apply(fileName));
        for (int i = 1; i <funkcja.length ; i++) {
            tmp.add(funkcja[i].apply(tmp.get(i-1)));
        }
        return (U) tmp.get(tmp.size()-1);
    }
}
