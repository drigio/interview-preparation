package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SimpleArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        // Append to the list (O(1))
        list.add("Ram");
        list.add("Sita");
        list.add("Lakshman");
        list.add("Ravan");

        // Add to an index (O(n))
        list.add(1,"Bharat");
        list.add(2, "Shatrughna");

        // ForEach example
        list.forEach(name -> System.out.print(name + " "));

        // Check if a value exists in array
        System.out.println();
        System.out.println(list.contains("Ram"));
        System.out.println(list.contains("Sugreev"));

        // Get the indexof of an element in array or return -1
        System.out.println(list.indexOf("Ravan"));
        System.out.println(list.indexOf("Sugreev"));

        // Check if array is empty
        System.out.println("Is the array empty? -> " + list.isEmpty());

        // Get an element at given position
        System.out.println(list.get(2));
        System.out.println(list.get(list.indexOf("Lakshman")));

        // Last Index of an element if multiple exist
        list.add("Lakshman");
        System.out.println(list.lastIndexOf("Lakshman"));

        // Remove an element using index
        System.out.println("Element removed " + list.remove(4));

        // Remove first occurence that matches
        System.out.println(list.remove("Sita"));

        // Replace and set an element in array
        System.out.println("Replaced Element by set() is " + list.set(3, "Sugreev"));

        // Get the size of array
        System.out.println(list.size());

        // Sort the array by the comparator given
        list.sort(Collections.reverseOrder());
        System.out.println("Reversed sort ");
        list.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Sorting using Collections.sort()
        Collections.sort(list); // Ascending order by default
        System.out.println("Ascending sort ");
        list.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // Create a sublist from previous list
        List<String> list2 = list.subList(2, 4);
        System.out.println("Sublist is ");
        list2.forEach(a -> System.out.print(a + " "));
        System.out.println();

        // Create an array from arraylist
        String arr[] = list.toArray(new String[list.size()]);
        System.out.println("Printing an array");
        for(String s : arr) System.out.print(s + " ");
        System.out.println();

        // Removes all elements that satisfy the condition
        list.add("Sita");
        list.add("Sita");
        list.add("Sita");

        System.out.println("Before removal");
        list.forEach(n -> System.out.print(n + " "));

        list.removeIf(n -> (n == "Sita"));
        System.out.println();

        System.out.println("After Removal");
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Removes all names starting with R");
        list.removeIf(n -> (n.toCharArray()[0] == 'R'));
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}