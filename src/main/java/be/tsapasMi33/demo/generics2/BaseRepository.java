package be.tsapasMi33.demo.generics2;

public interface BaseRepository<T,S> {
    T get(S id);
}
