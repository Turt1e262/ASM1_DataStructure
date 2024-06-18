import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Marks: ");
                            double marks = scanner.nextDouble();
                            manager.addStudent(id, name, marks);
                        } catch (Exception e) {
                            System.err.println("Invalid input for adding student. Please try again.");
                            scanner.nextLine(); // Consume newline
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter ID to Edit: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter New Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter New Marks: ");
                            double marks = scanner.nextDouble();
                            manager.editStudent(id, name, marks);
                        } catch (Exception e) {
                            System.err.println("Invalid input for editing student. Please try again.");
                            scanner.nextLine(); // Consume newline
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter ID to Delete: ");
                            String id = scanner.nextLine();
                            manager.deleteStudent(id);
                        } catch (Exception e) {
                            System.err.println("Invalid input for deleting student. Please try again.");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Enter Name to Search: ");
                            String name = scanner.nextLine();
                            List<Student> foundStudents = manager.searchStudent(name);
                            for (Student student : foundStudents) {
                                System.out.println(student);
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid input for searching student. Please try again.");
                        }
                        break;
                    case 5:
                        try {
                            List<Student> sortedStudents = manager.sortStudentsByMarks();
                            for (Student student : sortedStudents) {
                                System.out.println(student);
                            }
                        } catch (Exception e) {
                            System.err.println("Error occurred while sorting students. Please try again.");
                        }
                        break;
                    case 6:
                        manager.displayStudents();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.err.println("Invalid choice. Please choose a valid option.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
