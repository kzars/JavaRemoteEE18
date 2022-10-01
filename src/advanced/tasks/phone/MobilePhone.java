package advanced.tasks.phone;

// TODO
// 1.addNewContact
// 2.findContact
// 3.updateContact
// 4.printContacts
// 5.queryContact
// 6.removeContact

import java.util.ArrayList;

public class MobilePhone {

    //Fields
    private String myNumber;
    private ArrayList<Contact> myContacts;

    //Constructor
    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        //Check if contact exists
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already in the list");
            return false;
        }else {
            myContacts.add(contact);
            return true;
        }
    }

    //Returns index if contact does  exist and -1 if does not exist
    private int findContact (String contactName){
        for (int i = 0; i < myContacts.size(); i++){
            Contact tmpContact = myContacts.get(i);
            if (tmpContact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public void printContacts(){
        System.out.println("Contact list");
        for(int i = 0; i < myContacts.size(); i++){
            System.out.printf("%d. %s --> %s\n", (i+1), myContacts.get(i).getName(), myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0 ){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists in the list.");
            return false;
        }

        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + "was updated");
        return true;
    }

    public Contact queryContact(String name){
        int position  = findContact(name);
        if(position >= 0){
            return myContacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + ", was not found");
            return false;
        }
        this.myContacts.remove(position);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

}
