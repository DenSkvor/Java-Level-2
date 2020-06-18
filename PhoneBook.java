import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<String[]> contacts;

    private ArrayList<String> phoneNumbersForSameSurname;

    public PhoneBook(){
        contacts = new ArrayList<>(20);

        contacts.add(new String[]{"Иванов","100-00-00"});
        contacts.add(new String[]{"Петров","200-00-00"});
        contacts.add(new String[]{"Сидоров","300-00-00"});
        contacts.add(new String[]{"Иванова","400-00-00"});
        contacts.add(new String[]{"Петрова","500-00-00"});
        contacts.add(new String[]{"Сидорова","600-00-00"});
        contacts.add(new String[]{"Попов","700-00-00"});
        contacts.add(new String[]{"Алексеев","800-00-00"});
        contacts.add(new String[]{"Иванов","900-00-00"});
        contacts.add(new String[]{"Иванов","000-00-00"});

        phoneNumbersForSameSurname = new ArrayList<>();

    }

    public void addNewContact(String surname, String phoneNumber){
        contacts.add(new String[]{surname, phoneNumber});
    }

    public String getPhoneNumber(String phoneHolderSurname){
        phoneNumbersForSameSurname.clear();
        if(checkMatch(contacts, phoneHolderSurname)){
            for (String[] contact : contacts){
                if(contact[0].equals(phoneHolderSurname)){
                    phoneNumbersForSameSurname.add(contact[1]);
                }
            }
            return phoneNumbersForSameSurname.toString();
        }
        return "Такого человека в справочнике нет";
    }

    private boolean checkMatch(ArrayList<String[]> arrayList, String str){
        for(String[] value : arrayList){
            if(value[0].equals(str)) return true;
        } return false;
    }

}
