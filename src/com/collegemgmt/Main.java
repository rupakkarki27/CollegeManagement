package com.collegemgmt;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentFileOperation studentFileOperation = new StudentFileOperation("students.ser");
        TeacherFileOperation teacherFileOperation = new TeacherFileOperation("teachers.ser");
        
        ArrayList<Student> students = studentFileOperation.readFromFile();
        ArrayList<Teacher> teachers = teacherFileOperation.readFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. View Students");
            System.out.println("2. View Teachers");
            System.out.println("3. Add Student");
            System.out.println("4. Add Teacher");
            System.out.println("5. Edit Student");
            System.out.println("6. Edit Teacher");
            System.out.println("7. Delete Student");
            System.out.println("q. Quit");

            String input = scanner.nextLine();

            switch (input) {
                case "q":
                    System.out.println("Gracefully shutting down");
                    System.exit(0);
                    break;
                case "1":
                    ArrayList<Student> studentsFromFile;

                    studentsFromFile = studentFileOperation.readFromFile();

                    System.out.println("STUDENTS");
                    System.out.println("ID\tName\tAddress\tDOB\tDepartment\tCourse");
                    for(Student s : studentsFromFile) {
                        System.out.println(s.getStudentId() + "\t" + s.getName() + "\t" + s.getAddress() + "\t" + s.getDateOfBirth() + "\t" + s.getDepartment() + "\t" + s.getCourse());
                    }

                    break;
                case "2":

                    ArrayList<Teacher> teachersFromFile;

                    teachersFromFile = teacherFileOperation.readFromFile();

                    System.out.println("TEACHERS");
                    System.out.println("ID\tName\tAddress\tDOB\tDepartment");

                    for(Teacher t : teachersFromFile) {
                        System.out.println(t.getTeacherId() + "\t" + t.getName() + "\t" + t.getAddress() + "\t" + t.getDateOfBirth() + "\t" + t.getDepartment());

                    }

                    break;
                case "3":
                    System.out.print("Creating student...\n");

                    System.out.print("Enter Student's name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student's address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter Student's date of birth (DD-MM-YYYY): ");
                    String dateOfBirth = scanner.nextLine();

                    System.out.print("Enter Student's ID: ");
                    int studentId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Student's department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Student's course: ");
                    String course = scanner.nextLine();

                    Student student = new Student(
                            name,
                            address,
                            dateOfBirth,
                            studentId,
                            department,
                            course
                    );

                    students.add(student);

                    studentFileOperation.writeToFile(students);

                    break;

                case "4":
                    System.out.print("Creating Teacher...\n");

                    System.out.print("Enter Teacher's name: ");
                    String teacherName = scanner.nextLine();

                    System.out.print("Enter Teacher's address: ");
                    String teacherAddress = scanner.nextLine();

                    System.out.print("Enter Teacher's date of birth (DD-MM-YYYY): ");
                    String teacherDateOfBirth = scanner.nextLine();

                    System.out.print("Enter Teacher's ID: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Teacher's department: ");
                    String teacherDepartment = scanner.nextLine();


                    Teacher teacher = new Teacher(
                            teacherName,
                            teacherAddress,
                            teacherDateOfBirth,
                            teacherId,
                            teacherDepartment
                    );

                    teachers.add(teacher);

                    teacherFileOperation.writeToFile(teachers);

                    break;
                case "5":

                    System.out.println("Editing Student");

                    System.out.println("Enter student ID to edit");
                    int idToEdit = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter new Name for the student");
                    String newName = scanner.nextLine();

                    for(Student s : students) {
                        if(s.getStudentId() == idToEdit) {
                            s.setName(newName);
                        }
                    }

                    studentFileOperation.writeToFile(students);

                    break;

                case "7":
                    System.out.println("Deleting student");

                    System.out.println("Enter student ID to delete");
                    int idToDelete = Integer.parseInt(scanner.nextLine());

                    students.removeIf(s -> s.getStudentId() == idToDelete);

                    studentFileOperation.writeToFile(students);

                    break;

                default:
                    System.out.println("Please choose a valid option");
                    break;
            }
        }
    }
}
