import java.util.ArrayList;

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

        ArrayList<String> uniqueCities = new ArrayList<>(cities);

        int cityCopies;

        for (int i = 0; i < uniqueCities.size(); i++) {
            cityCopies = 1;
            if (i == uniqueCities.size() - 1){
                System.out.println("[" + uniqueCities.get(i) + "]" + " встречается в списке: " + cityCopies);
                break;
            }
            for (int j = i + 1; j < uniqueCities.size(); j++){
                if(uniqueCities.get(i).equals(uniqueCities.get(j))) {
                    cityCopies++;
                    uniqueCities.remove(j);
                    j--;
                }
            }
            System.out.println("[" + uniqueCities.get(i) + "]" + " встречается в списке: " + cityCopies);
        }
        uniqueCities.trimToSize();
    }

    public static void doCollectionExample2(){

        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Сидоров: " + phoneBook.getPhoneNumber("Сидоров"));
        System.out.println("Иванов: " + phoneBook.getPhoneNumber("Иванов"));

        phoneBook.addNewContact("Иванов", "777-77-77");

        System.out.println("Иванов: " + phoneBook.getPhoneNumber("Иванов"));
        System.out.println("Аникеев: " + phoneBook.getPhoneNumber("Аникеев"));

    }

}
