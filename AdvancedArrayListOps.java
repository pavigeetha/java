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

    public ArrayList<String> startingWith(String prefix) {

        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.toLowerCase().startsWith(prefix.toLowerCase())) {
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

        System.out.print("Enter string to insert: ");
        String str = sc.nextLine();
        System.out.print("Enter index: ");
        int idx = sc.nextInt();
        sc.nextLine();
        ops.insert(idx, str);
        ops.display();
        System.out.print("\n");

        System.out.print("Enter substring for partial search: ");
        String substr = sc.nextLine();
        System.out.println("Matches: " + ops.partialMatch(substr));
        System.out.print("\n");

        System.out.print("Enter regex for search: ");
        String regex = sc.nextLine();
        System.out.println("Regex matches: " + ops.regexSearch(regex));
        System.out.print("\n");

        System.out.print("Enter starting text: ");
        String prefix = sc.nextLine();
        System.out.println("Starting with '" + prefix + "': " + ops.startingWith(prefix));
        System.out.print("\n");

        System.out.print("Sorting in ascending order: ");
        ops.sortAscending();
        ops.display();
        System.out.print("\n");

        System.out.print("Sorting in descending order: ");
        ops.sortDescending();
        ops.display();
        System.out.print("\n");

        System.out.print("Sort by length: ");
        ops.sortByLength();
        ops.display();
        System.out.print("\n");

        sc.close();
    }
}
