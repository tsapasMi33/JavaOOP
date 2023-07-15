package be.tsapasMi33.exercises.mobilephone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) != -1) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        if (findContact(oldContact) != -1) {
            myContacts.set(findContact(oldContact),newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        return myContacts.remove(contact);
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact.getName());
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public Contact queryContact(String name) {
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(name))
                return myContact;
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        int i = 1;
        for (Contact c: myContacts) {
            System.out.printf("%d. %s -> %s\n", i, c.getName(),c.getPhoneNumber());
            i++;
        }
    }
}