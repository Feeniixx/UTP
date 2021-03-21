package zad5;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Maybe<T> {
    T moje;

    public Maybe(T moje) {
        this.moje = moje;
    }

    public static <T> Maybe<T> of(T t) {
        return new Maybe<>(t);
    }

    boolean isPresent() {
        if (moje == null) {
            return false;
        }
        return true;
    }

    void ifPresent(Consumer cons) {
        if (isPresent()) {
            cons.accept(moje);
        }
    }

    <A> Maybe<A> map(Function<T, A> func) {
        if (!isPresent()) {
            return new Maybe<>(null);
        } else {
            return new Maybe<A>(func.apply(moje));
        }

    }

    T get() {
        if (!isPresent()) {
            throw new NoSuchElementException("maybe is empty");
        }
        return moje;
    }

    T orElse(T defVal) {
        if (!isPresent()) {
            return defVal;
        } else return moje;
    }

    Maybe<T> filter(Predicate<T> pred) {
        if (!isPresent() || !pred.test(moje))
            return new Maybe<>(null);
        return this;
    }

    @Override
    public String toString() {
        if (!isPresent()) {
            return "Maybe is empty";
        } else {
            return "Maybe has value " + moje;
        }
    }
}