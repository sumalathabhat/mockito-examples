import com.mockito.example.db.StudentRepository;
import com.mockito.example.models.Student;
import com.mockito.example.service.NotificationService;
import com.mockito.example.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService( new StudentRepository(), new NotificationService());
        Student student = Student.builder().id(1).name("Student1").age(6).grade("1st").build();
        studentService.addStudent(student);
        Student actualStudent = studentService.getStudent(student.getId());
        System.out.println("Actual Student = " + actualStudent.getName());
    }
}