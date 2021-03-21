package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<U> {
    private List<U> lista;

    public ListCreator(List<U> lista) {
        super();
        this.lista = lista;
    }


    public ListCreator<U> when(Predicate<U> predicate) {
        List<U> result = new ArrayList<U>();
        for (int i = 0; i < lista.size(); i++) {
            if (predicate.test(lista.get(i)))
                result.add(lista.get(i));
        }
        this.lista = result;
        return this;
    }

    public <K> List<U> mapEvery(Function<U, K> func) {
        List<U> res = new ArrayList<U>();
        for (U strings : lista) {
            res.add((U) func.apply(strings));

        }
        this.lista = res;
        return lista;

    }

    public static <U> ListCreator<U> collectFrom(List<U> dane) {

        return new ListCreator<>(dane);
    }


}
