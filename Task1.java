import java.io.*;
import java.util.Scanner;

public class FileHandlingProject {

    // Method to create a new file
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Method to append text to a file
    public static void appendToFile(String fileName, String content) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            bw.newLine();
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending.");
            e.printStackTrace();
        }
    }

    // Method to edit (overwrite) a file
    public static void editFile(String fileName, String newContent) {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(newContent);
            bw.newLine();
            System.out.println("File edited successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while editing.");
            e.printStackTrace();
        }
    }

    // Method to read a file
    public static void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Contents ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please create or check the file name.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to delete a file
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    // Main method with menu-driven program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        String fileName, content;

        do {
            System.out.println("\n--- File Handling Project ---");
            System.out.println("1. Create File");
            System.out.println("2. Append to File");
            System.out.println("3. Edit File");
            System.out.println("4. Read File");
            System.out.println("5. Delete File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    createFile(fileName);
                    break;
                case 2:
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    System.out.print("Enter content to append: ");
                    content = sc.nextLine();
                    appendToFile(fileName, content);
                    break;
                case 3:
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    System.out.print("Enter new content: ");
                    content = sc.nextLine();
                    editFile(fileName, content);
                    break;
                case 4:
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    readFile(fileName);
                    break;
                case 5:
                    System.out.print("Enter file name: ");
                    fileName = sc.nextLine();
                    deleteFile(fileName);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
