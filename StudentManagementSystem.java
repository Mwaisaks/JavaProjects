import java.util.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        HashSet<Integer> studentIDs = new HashSet<>();
        ArrayList<String> studentList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to your dashboard.");
            System.out.println("1.Add Student \n2.Remove Student \n3.Display Students \n4.Sort Students \n5.Exit  ");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter the Student Name");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    try{
                        if(!studentIDs.add(id)){
                            throw new Exception("Student ID already exists.");
                        }
                        students.put(id, name);
                        studentList.add(name);
                        System.out.println("Student added successfully!");
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            
                case 2:
                    System.out.println("Enter student ID to remove: ");
                    int removeID = scanner.nextInt();
                    try {
                        if (!students.containsKey(removeID)){
                            throw new Exception("Student ID not found.");
                        }
                        studentList.remove(students.get(removeID));
                        studentIDs.remove(removeID);
                        students.remove(removeID);
                        System.out.println("Student removed successfully.");
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Student List:");
                    Iterator<Map.Entry<Integer, String>> iterator = students.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<Integer, String> entry = iterator.next();
                        System.out.println("ID: "+ entry.getKey() + ", Name: " + entry.getValue());
                    }
                    break;

                case 4:
                    Collections.sort(studentList);
                    System.out.println("---Students---");
                    for (String student : studentList){
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.Please try again.");
                    break;
            }
        }
    }
}
