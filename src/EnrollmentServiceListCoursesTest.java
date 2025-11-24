import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

// Testa se listar cursos retorna vazio quando o aluno não tem matrícula
public class EnrollmentServiceListCoursesTest {

    @Test
    public void testListEmpty() {
        CourseCatalog catalog = new CourseCatalog();
        StudentRegistry registry = new StudentRegistry();
        EnrollmentService service = new EnrollmentService(registry, catalog);

        Student s = new Student("1", "Gabriel","gabriel@gmail.com");
        registry.addStudent(s);

        List<Course> courses = service.getCoursesByStudent("1");

        Assertions.assertTrue(courses.isEmpty());
    }
}