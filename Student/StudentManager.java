import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String id, String name, double marks) {
        // Check for invalid characters in ID and name
        if (!isValidInput(id) || !isValidInput(name)) {
            System.err.println("Error: ID and Name should not contain special characters.");
            return;
        }

        // Check for duplicate ID
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.err.println("Error: Student ID " + id + " already exists.");
                return;
            }
        }

        // Check if marks are within the valid range (0 to 10)
        if (marks < 0 || marks > 10) {
            System.err.println("Error: Marks should be between 0 and 10.");
            return;
        }

        students.add(new Student(id, name, marks));
    }

    public void editStudent(String id, String name, double marks) {
        // Check for invalid characters in name
        if (!isValidInput(name)) {
            System.err.println("Error: Name should not contain special characters.");
            return;
        }

        // Check if marks are within the valid range (0 to 10)
        if (marks < 0 || marks > 10) {
            System.err.println("Error: Marks should be between 0 and 10.");
            return;
        }

        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(name);
                student.setMarks(marks);
                return;
            }
        }
        System.err.println("Error: Student ID " + id + " not found.");
    }

    public void deleteStudent(String id) {
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            System.err.println("Error: Student ID " + id + " not found.");
        }
    }

    public Student getStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        System.err.println("Error: Student ID " + id + " not found.");
        return null;
    }

    public List<Student> searchStudent(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> sortStudentsByMarks() {
        List<Student> sortedStudents = new ArrayList<>(students);
        boolean swapped;
        for (int i = 0; i < sortedStudents.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < sortedStudents.size() - 1 - i; j++) {
                if (sortedStudents.get(j).getMarks() < sortedStudents.get(j + 1).getMarks()) {
                    Student temp = sortedStudents.get(j);
                    sortedStudents.set(j, sortedStudents.get(j + 1));
                    sortedStudents.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break; // No swapping means the list is already sorted
        }
        return sortedStudents;
    }

    


    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private boolean isValidInput(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }
}
