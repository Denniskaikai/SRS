package Schoolrecordsystem;
import java.util.*;

public class Demo {
	public static class Student {
	    String id;
	    String pw;
	    String name;
	    int age;
	    String address;
	    char gender;
	    int GPA;
	    Map<String, Double> subjects;

	    public Student(String id, String pw, String name, int age, String address, char gender) {
	        this.id = id;
	        this.pw = pw;
	        this.name = name;
	        this.age = age;
	        this.address = address;
	        this.gender = gender;
	        this.subjects = new HashMap<>();
	    }
	    
	    public void Subject(String subject, double result) {
	        subjects.put(subject, result);
	    }
	    
	    public void addSubject() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the subject you want to add:");
	        String subject = scanner.nextLine();
	        System.out.println("Enter the result:");
	        double result = scanner.nextInt();
	        subjects.put(subject, result);
	    }
	    
	    public void deleteSubject() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the subject you want to delete:");
	        String subject = scanner.nextLine();
	        if (subjects.containsKey(subject)) {
	            subjects.remove(subject);
	        } else {
	            System.out.println("Subject not found.");
	        }
	    }
	    
	    public void listSubjects() {
	        for (Map.Entry<String, Double> entry : subjects.entrySet()) {
	            System.out.println("Subject: " + entry.getKey() + ", Result: " + entry.getValue());
	        }
	        System.out.println("GPA: " + String.format("%.2f", calculateGPA()));
	    }
	    
	    public void changeResult() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the subject you want to change the result for:");
	        String subject = scanner.nextLine();
	        System.out.println("Enter the new result:");
	        double newResult = scanner.nextDouble();
	        scanner.nextLine();
	        if (subjects.containsKey(subject)) {
	            subjects.put(subject, newResult);
	        } else {
	            System.out.println("Subject not found.");
	        }
	    }
	    
	    public double calculateGPA() {
	        double total = 0;
	        for (double result : subjects.values()) {
	            total += result;
	        }
	        return (double)total / subjects.size();
	    }
	    
	    public String getId() {
	        return id;
	    }
	    
	    public String getPw() {
	    	return pw;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public char getGender() {
	        return gender;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }

	    public void setPw(String pw) {
	        this.pw = pw;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public void setGender(char gender) {
	        this.gender = gender;
	    }
	}
	public static Student getStudentById(String id, Student[] students) {
	        for (Student student : students) {
	            if (student.id.equals(id)) {
	                return student;
	            }
	        }
	        return null;
	    }
	public static class Teacher{
		String id;
		String pw;
		public Teacher(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
		public String getId() {
	        return id;
	    }
	    
	    public String getPw() {
	    	return pw;
	    }
	}
	public static Teacher getTeacherById(String id, Teacher[] teachers) {
	    for (Teacher teacher : teachers) {
	        if (teacher.getId().equals(id)) {
	            return teacher;
	        }
	    }
	    return null;
	}

	public static void main(String[] args) {
		
	Student s1234567 = new Student("s1234567","12345678","Tom",18,"HK",'M'); //Assume data in database
	s1234567.Subject("Math", 2);
	s1234567.Subject("English", 2);
    Student s7654321 = new Student("s7654321","87654321","Jerry",18,"KL",'F');
    s7654321.Subject("Math", 2);
    s7654321.Subject("English", 2);
    Student[] students = {s1234567,s7654321};
    Teacher t1234567 = new Teacher("t1234567","12345678");
    Teacher[] teachers = {t1234567};
	
	char user;
	int valid;
	String username; //user input
	String password;// user input
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Please enter your username and password");
    System.out.println("Username:");
    username = scanner.nextLine();//get username
    user = username.charAt(0);//identify the user
    Student student = getStudentById(username, students); 
    Teacher teacher = getTeacherById(username, teachers);
	System.out.println("Password:");
	password = scanner.nextLine();//get password
	if (student != null) {
        if (password.equals(student.getPw())) {
        	valid = 1;
            System.out.println("Login successful");
            } else {
            	valid = 0;
            	System.out.println("Incorrect password");
            	}
        } 
	else if (teacher != null) {
		if (password.equals(teacher.getPw())) {
			valid = 1;
			System.out.println("Login successful");
			} else {
				valid = 0;
				System.out.println("Incorrect password");
				} 
	}else {
		valid = 0;
		System.out.println("Username not found");
		}
	
    if (user == 's' && valid == 1) {//user is student
    	int end = 0;
    	System.out.println("Enter Student System");
    	do {
    		System.out.println("Enter the operation(1:view personal information 2:update personal information 3:End)");
        	int operation = scanner.nextInt();
        	scanner.nextLine();
        	switch(operation){
        	case 1: // show student information
        		System.out.println("Name: " + student.getName());
    			System.out.println("Age: " + student.getAge());
    			System.out.println("Address: " + student.getAddress());
    			System.out.println("Gender: " + student.getGender());
    			student.listSubjects();
    			break;
    			
    		case 2:// able to update student's name and address 
    			System.out.println("Enter the latest personal information(Enter Null remain unchange)");
    			System.out.println("Name: ");
    			String newname = scanner.nextLine();
    			if (newname != "Null" || newname != "null") {
    				student.setName(newname);
    				}
    			System.out.println("Address: ");
    			String newaddress = scanner.nextLine();
    			if (newaddress != "Null" || newname != "null") {
    				student.setAddress(newaddress);
    			}
    			break;
    			
    		case 3: //leave the system
    			end = operation;
    			System.out.println("End");
    			break;
    	}
    	} while (end != 3);//loop until user want to leave
    }
    
    if (user == 't'&& valid == 1) {//user is teacher
    	int end = 0;
    	System.out.println("Enter Teacher System");
    	do {
    		System.out.println("Enter the operation(1:view student information 2:update student result 3:create or delete the record of student 4.End)");
    	    int operation = scanner.nextInt();
     	    scanner.nextLine();
     	    if (operation != 4) {
    		System.out.println("Enter username of student that you want to operate:");
    		String studentid = scanner.nextLine();
		    Student st = getStudentById(studentid, students);
		    if (st == null) {
		    	System.out.println("Username not found");
		        }
    	    switch (operation) {
    	    case 1://view student information
    	    	System.out.println("Name: " + st.getName());
			    System.out.println("Age: " + st.getAge());
			    System.out.println("Address: " + st.getAddress());
			    System.out.println("Gender: " + st.getGender());
			    st.listSubjects();
			    break;
			case 2://update student grade
    		    st.changeResult();
    		    break;
    	    case 3://create or delete the record of student
    	    	int op = 0;
    	    	System.out.println("Enter the operation(1:Create a subject 2:Delete a subject");
    	    	op = scanner.nextInt();
    	    	scanner.nextLine();
    	    	if (op == 1 || op ==2) {
    	    	switch (op) {
    	    	case 1:
    	    		st.addSubject();
    	    		break;
    	    	case 2:
    	    		st.deleteSubject();
    	    		break;
    	    	}
    	    	} else {
    	    		System.out.println("operation not found");
    	    	}
    	    }
     	    } else {
     	    	end = 4;
     	    	System.out.println("End");
     	    }
     	    }while (end != 4);//loop until user want to leave
    		
    	}
    scanner.close();
	}
}

