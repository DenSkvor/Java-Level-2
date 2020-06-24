import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        doCollectionExample1();

        System.out.println();

        doCollectionExample2();

    }

    public static void doCollectionExample1(){
        ArrayList<String> cities = new ArrayList<>(20);

        cities.add("Москва");
        cities.add("Санкт-Петербург");
        cities.add("Новосибирск");
        cities.add("Екатеринбург");
        cities.add("Екатеринбург");
        cities.add("Казань");
        cities.add("Казань");
        cities.add("Казань");
        cities.add("Нижний Новгород");
        cities.add("Нижний Новгород");
        cities.add("Нижний Новгород");
        cities.add("Нижний Новгород");
        cities.add("Челябинск");
        cities.add("Самара");
        cities.add("Омск");
        cities.add("Ростов-на-Дону");
        cities.add("Уфа");
        cities.add("Красноярск");
        cities.add("Красноярск");
        cities.add("Воронеж");

        LinkedHashMap<String, Integer> uniqueCities = new LinkedHashMap<>();

        for (String city : cities) {
            if(!uniqueCities.containsKey(city)) uniqueCities.put(city, 1);
            else uniqueCities.put(city, (uniqueCities.get(city) + 1));
        }
        System.out.println(uniqueCities);

    }

    public static void doCollectionExample2(){

        PhoneBook phoneBook = new PhoneBook();
        System.out.println("Иванов: " + phoneBook.getPhoneNumber("Иванов") + "\n");
        System.out.println("Петрова: " + phoneBook.getPhoneNumber("Петрова") + "\n");

        phoneBook.addNewContact("Петрова","555-55-55");

        System.out.println("Петрова: " + phoneBook.getPhoneNumber("Петрова") + "\n");
        System.out.println("Аникеев: " + phoneBook.getPhoneNumber("Аникеев") + "\n");
    }

}
