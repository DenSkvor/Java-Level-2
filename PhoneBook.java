import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private HashMap<String, ArrayList<String>> contacts;

    public PhoneBook(){
        contacts = new HashMap<>();

        addNewContact("Иванов", "100-00-00");
        addNewContact("Петров","200-00-00");
        addNewContact("Сидоров","300-00-00");
        addNewContact("Иванова","400-00-00");
        addNewContact("Петрова","500-00-00");
        addNewContact("Сидорова","600-00-00");
        addNewContact("Попов","700-00-00");
        addNewContact("Алексеев","800-00-00");
        addNewContact("Иванов","900-00-00");
        addNewContact("Иванов","000-00-00");

    }

    public void addNewContact(String surname, String phoneNumber){
        if(!contacts.containsKey(surname)) {
            ArrayList<String> number = new ArrayList<>();
            number.add(phoneNumber);
            contacts.put(surname, number);
        }
        else {
            contacts.get(surname).add(phoneNumber);
        }
    }

    public String getPhoneNumber(String phoneHolderSurname){
        if(contacts.containsKey(phoneHolderSurname)) return contacts.get(phoneHolderSurname).toString();
        else return "Такого человека в справочнике нет.";
    }
}
