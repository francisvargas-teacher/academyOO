import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Testa erro ao tentar matricular aluno inexistente
public class EnrollmentServiceInvalidTest {

    @Test
    public void testEnrollInvalidStudent() {
        CourseCatalog catalog = new CourseCatalog();
        StudentRegistry registry = new StudentRegistry();
        EnrollmentService service = new EnrollmentService(catalog, registry);

        Course c = new Course("C1", "Java");
        catalog.addCourse(c);

        // espera exceção porque não existe aluno "X"
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.enroll("X", "C1");
        });
    }
}