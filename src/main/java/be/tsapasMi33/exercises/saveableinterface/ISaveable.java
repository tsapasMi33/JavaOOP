package be.tsapasMi33.exercises.saveableinterface;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> list);
}
