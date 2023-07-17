package be.tsapasMi33.exercises.abstractchallenge;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem listItem);
    boolean removeItem(ListItem listItem);
    void traverse(ListItem root);
}
