// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре
// будут повторяющиеся имена с разными телефонами, их необходимо считать,
// как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;


public class Main {

    static Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        // Заранее делаем переменные, чтобы программа не тратила на них время в цикле.
        PhoneBook phoneBook1 = new PhoneBook();
        char ans = ' ';
        int count = 0;
        Integer num = null;
        String name = null;
        while(true) { // Создаем цикл, для эффекта меню
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu: ");
            System.out.println("1. Add contact");
            System.out.println("2. Find contact");
            System.out.println("3. Get contacts");
            System.out.println("4. Exit");
            System.out.println();
            System.out.println("Enter number of action: ");
            try {
                ans = (char) scanner.nextInt(); // Вводим номер действия
            } catch (java.util.InputMismatchException e) {
                System.out.println();
            }
            System.out.println();
            if (ans == 1) { // Добавление контакта
                System.out.println("Enter name: ");
                name = scanner.next();
                System.out.println("Enter number: ");
                num = scanner.nextInt();
                phoneBook1.add(name, num);
            } else if (ans == 2) {
                System.out.println("Enter name: ");
                name = scanner.next();
                System.out.println(phoneBook1.find(name));
            } else if (ans == 3) {
                System.out.println(phoneBook1.getPhoneBook());
            } else if (ans == 4) {
                System.out.println("You exit from phone directory!");
                break;
            }
            System.out.println();
        }
    }

}

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer num) { // Функция для добавления контакта.
        ArrayList<Integer> nums = new ArrayList<>();
        int count = 0;
        if (phoneBook.get(name) != null) {
            nums = phoneBook.get(name);
            for (int i = 0; i < nums.size(); i++) {
                if (Objects.equals(nums.get(i), num)) count++;
            }
        }
        if (count == 0) {
            nums.add(num);
            phoneBook.put(name, nums);
        }
    }

    public ArrayList<Integer> find(String name) { // Функция для поиска контакта.
        if (!phoneBook.containsKey(name)) return new ArrayList<>();
        return phoneBook.get(name);
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() { // Функция для вывода справочника.
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(String name : phoneBook.keySet()) {
            map.put(name, phoneBook.get(name));
        }
        return map;
    }
}