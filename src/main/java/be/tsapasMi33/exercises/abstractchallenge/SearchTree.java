package be.tsapasMi33.exercises.abstractchallenge;

public class SearchTree implements NodeList{
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }


    private void performRemoval(ListItem toRemove, ListItem parent){
        if (toRemove.next() == null) {
            if (parent.next() == toRemove) {
                parent.setNext(toRemove.previous());
            } else if (parent.previous() == toRemove) {
                parent.setPrevious(toRemove.previous());
            } else {
                this.root = toRemove.previous();
            }
        } else if (toRemove.previous() == null) {
            if (parent.next() == toRemove) {
                parent.setNext(toRemove.next());
            } else if (parent.previous() == toRemove) {
                parent.setPrevious(toRemove.next());
            } else {
                this.root = toRemove.next();
            }
        } else {

            ListItem current = toRemove.next();
            ListItem leftmostParent = toRemove;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            toRemove.setValue(current.getValue());
            if (leftmostParent == toRemove) {
                toRemove.setNext(current.next());
            } else {
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        if (this.root == null) {
            this.root = listItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(listItem));
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(listItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    currentItem.setPrevious(listItem);
                    return true;
                }
            } else {
                System.out.println(listItem.getValue() + " is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        if (listItem != null) {
            System.out.println("Deleting item " + listItem.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = (currentItem.compareTo(listItem));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
