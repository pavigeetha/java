import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Comparator;

public class AdvancedArrayListOps {

    private ArrayList<String> list;

    public AdvancedArrayListOps() {
        list = new ArrayList<>();
    }

    public void append(String str) {
        list.add(str);
    }

    public void insert(int index, String str) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, str);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public boolean search(String str) {
        for (String s : list){
            if (s.equals(str)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> startingWith(String c) {

        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.toLowerCase().startsWith(c.toLowerCase())) {
                result.add(s);
            }
        }
        Collections.sort(result); 
        return result;
    }

    public void sortAscending() {
        Collections.sort(list);
    }

    public void sortDescending() {
        Collections.sort(list, Collections.reverseOrder());
    }

    
    public void removeDuplicates() {

        LinkedHashSet<String> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
    }

    public ArrayList<String> partialMatch(String substring) {

        ArrayList<String> matches = new ArrayList<>();
        for (String s : list) {
            if (s.toLowerCase().contains(substring.toLowerCase())) {
                matches.add(s);
            }
        }
        return matches;
    }
    
    public ArrayList<String> regexSearch(String regex) {

        ArrayList<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                matches.add(s);
            }
        }
        return matches;
    }


    public void sortByLength() {
        list.sort(Comparator.comparingInt(String::length));
    }

    public void display() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdvancedArrayListOps ops = new AdvancedArrayListOps();

        System.out.println("Enter strings or 'stop' to stop:\n");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop")) break;
            ops.append(input);
        }
        System.out.print("\n");

        ops.removeDuplicates();
        System.out.print("List after removing duplicates: ");
        ops.display();
        System.out.print("\n");

        int stop = 0;
        int choice = 0;
        String str ;

        while (stop == 0){
            System.out.println("The Menu\n 1. Append a string\n 2. Insert a new string\n 3. Search for a string\n 4. Words starting with a letter\n 5. Sort in ascending order\n 6. Sort in descending order\n 7. Partial search\n 8. Regex Search\n 9. Sort based on length\n 10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter string to append: ");
                    str = sc.next();
                    ops.append(str);
                    ops.display();
                    System.out.print("\n");
                    break;

                case 2:

                    System.out.print("Enter string to insert: ");
                    str = sc.next();
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    ops.insert(idx, str);
                    ops.removeDuplicates();
                    ops.display();
                    System.out.print("\n");
                    break;
                
                case 3:

                    System.out.print("Enter string for linear search: ");
                    str = sc.next();
                    if (ops.search(str)){
                        System.out.println("The string is present in the list");
                    }
                    else{
                        System.out.println("The string is not present in the list");
                    }
                    System.out.print("\n");
                    break;

                case 4:

                    System.out.print("Enter starting letter: ");
                    String c = sc.next();
                    System.out.println("Starting with '" + c + "': " + ops.startingWith(c));
                    System.out.print("\n");
                    break;

                case 5:

                    System.out.print("Sorting in ascending order: ");
                    ops.sortAscending();
                    ops.display();
                    System.out.print("\n");
                    break;

                case 6:
                    
                    System.out.print("Sorting in descending order: ");
                    ops.sortDescending();
                    ops.display();
                    System.out.print("\n");
                    break;

                case 7:
                    System.out.print("Enter substring for partial search: ");
                    String substr = sc.next();
                    System.out.println("Words with the given substring: " + ops.partialMatch(substr));
                    System.out.print("\n");
                    break;
                
                case 8:
                    System.out.print("Enter regex for search: ");
                    String regex = sc.next();
                    System.out.println("Regex matches: " + ops.regexSearch(regex));
                    System.out.print("\n");
                    break;

                case 9:
                    System.out.print("Sort by length: ");
                    ops.sortByLength();
                    ops.display();
                    System.out.print("\n");
                    break;

                case 10:
                    stop = 1;
                    System.out.println("Exiting the program!");
                    break;

                default:
                    break;
            }
        }

        sc.close();
    }
}
