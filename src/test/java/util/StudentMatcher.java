package util;

import com.mockito.example.models.Student;
import org.mockito.ArgumentMatcher;

public class StudentMatcher implements ArgumentMatcher<Student> {
    private Student actual;

    public StudentMatcher(Student actual) {
        this.actual = actual;
    }

    @Override
    public boolean matches(Student expected) {
        return actual.equals(expected);
    }
}
