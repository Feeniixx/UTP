
package zad1;
        import java.util.*;
        import java.util.function.BiConsumer;
        import java.util.function.Function;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class XList<T> extends ArrayList<T>{
    private static Pattern pattern;
    private static Matcher matcher;

    public XList() {
        super();
    }

    public XList(T...args) {
        super(Arrays.asList(args));
    }

    public XList(Collection<T> c) {
        super(c);
    }


    @SafeVarargs
    public static <T>XList of(T...t) {
        return new XList<>(t);
    }


    public static <T>XList<T> of(Collection<T> collection){
        return new XList<T>(collection);
    }


    public static XList<String> tokensOf(String string) {
        return new XList<>(string.split(" "));
    }


    public static XList<String> charsOf(String string){
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            ret.add(String.valueOf(string.charAt(i)));
        }
        return new XList<>(ret);
    }

    public XList<T> union(Collection<T> collection) {
        XList<T> ret = new XList<>();
        ret.addAll(this);
        ret.addAll(collection);
        return ret;
    }

    public static XList<String> tokensOf(String string, String regex) {
        return new XList<>(string.split(regex));
    }

    public XList<T> diff(Collection<T> collection) {
        XList<T> ret = new XList<>();
        ret.addAll(this);
        ret.removeAll(collection);
        return ret;
    }

    public XList<T> union(T...t){
        XList<T> ret = new XList<>();
        ret.addAll(this);
        Collections.addAll(ret, t);
        return ret;
    }


    public XList<T> unique() {
        XList<T> ret = new XList();
        ret.addAll(this);
        int flaga = 0;
        for (int i = 0; i < ret.size(); i++){
            flaga=0;
            for (int j = 0; j < ret.size(); j++){
                if (this.get(i).equals(ret.get(j))) {
                    ++flaga;
                    if (flaga > 1){ ret.remove(j);j--;};
                }
            }
        }
        return ret;
    }

    public XList<T> combine() {
        List<T> returnList = new ArrayList<>();
        T comb;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size(); j++) {
                comb = (T) ((this.get(i).toString()) + (this.get(j).toString()));
                returnList.add(comb);
            }
        }
        return new XList<T>(returnList);
    }


    public <R> XList<R> collect(Function<T, R> f) {
        List<R> returnList = new ArrayList<R>();
        for (R r : returnList) {
            returnList.add(f.apply((T) r));
        }
        return new XList<R>(returnList);
    }

    public String join(String string) {
        StringBuilder sB = new StringBuilder();
        for (T t : this) {
            sB.append(t.toString() + string);
        }
        return sB.toString();
    }

    public String join() {
        StringBuilder sB = new StringBuilder();
        for (T t : this) {
            sB.append(t.toString() + " ");
        }
        return sB.toString();
    }

    public void forEachWithIndex(BiConsumer<T,Integer> c) {
        for (int i = 0; i < this.size(); i++) {
            c.accept(this.get(i), i);
        }
    }


}
