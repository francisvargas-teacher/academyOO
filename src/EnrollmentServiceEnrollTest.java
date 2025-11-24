import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

// Testa se a matrícula funciona quando aluno e curso existem
public class EnrollmentServiceEnrollTest {

    @Test
    public void testEnrollBasic() {
        CourseCatalog catalog = new CourseCatalog();
        StudentRegistry registry = new StudentRegistry();
        EnrollmentService service = new EnrollmentService(registry, catalog);

        // cria aluno e curso simples
        Student s = new Student("1", "Gabriel","gabriel@gmail.com");
        Course c = new Course("C1", "Java",360);

        registry.addStudent(s);
        catalog.addCourse(c);

        // tenta matricular
        service.enroll("1", "C1");

        // verifica se foi matriculado
        List<Course> courses = service.getCoursesByStudent("1");
        Assertions.assertEquals(1, courses.size());
        Assertions.assertEquals("C1", courses.get(0).getCode());
    }
}