import java.io.*;
import java.util.*;

public class FileHandlingMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== FILE HANDLING MENU ===");
            System.out.println("1. Check if file exists");
            System.out.println("2. Get last modification date/time");
            System.out.println("3. Rename a file");
            System.out.println("4. Create a new directory");
            System.out.println("5. Check if file is readable");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();  

            switch (ch) {
                case 1:
                    System.out.print("Enter file path: ");
                    String path = sc.nextLine();
                    try {
                        FileInputStream file = new FileInputStream(path);
                        System.out.println("File found successfully!");
                        file.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found at the given location!");
                    } catch (IOException e) {
                        System.out.println("Error closing file.");
                    }
                    break;

                case 2:
                    System.out.print("Enter file path: ");
                    path = sc.nextLine();
                    File file = new File(path);
                    if (file.exists()) {
                        System.out.println("Last Modified: " + new Date(file.lastModified()));
                    } else {
                        System.out.println("File does not exist!");
                    }
                    break;

                case 3:
                    System.out.print("Enter current file path: ");
                    String oldPath = sc.nextLine();
                    System.out.print("Enter new file path: ");
                    String newPath = sc.nextLine();
                    File oldFile = new File(oldPath);
                    File newFile = new File(newPath);
                    if (oldFile.renameTo(newFile)) {
                        System.out.println("File renamed successfully!");
                    } else {
                        System.out.println("Rename operation failed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter directory path to create: ");
                    String dirPath = sc.nextLine();
                    File dir = new File(dirPath);
                    if (dir.mkdir()) {
                        System.out.println(" Directory created successfully!");
                    } else {
                        System.out.println("Failed to create directory or it already exists.");
                    }
                    break;

                case 5:
                    System.out.print("Enter file path: ");
                    path = sc.nextLine();
                    file = new File(path);
                    if (file.canRead()) {
                        System.out.println("The file can be read.");
                    } else {
                        System.out.println("The file cannot be read.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}