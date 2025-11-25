import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import models.Student;
import models.Course;
import services.EnrollmentService;
import services.SafeRemoveService;
import repositories.StudentRegistry;
import repositories.CourseCatalog;

public class SafeRemoveServiceTestEduardo {

    @Test
    void naoDeveRemoverAlunoComMatriculaAtiva() {
        StudentRegistry reg = new StudentRegistry();
        Student joao = new Student("João", "Java");
        reg.registerStudent(joao);

        Course c = new Course("Java");
        CourseCatalog cat = new CourseCatalog();
        cat.addCourse(c);

        EnrollmentService enrollmentService = new EnrollmentService();
        enrollmentService.enroll(joao, c);

        SafeRemoveService safe = new SafeRemoveService(enrollmentService);

        assertThrows(IllegalArgumentException.class, () -> safe.removeStudent(joao, reg));
    }

    @Test
    void deveRemoverAlunoSemMatriculas() {
        StudentRegistry reg = new StudentRegistry();
        Student maria = new Student("Maria", "Python");

        reg.registerStudent(maria);

        EnrollmentService e = new EnrollmentService();
        SafeRemoveService safe = new SafeRemoveService(e);

        safe.removeStudent(maria, reg);

        assertFalse(reg.getStudents().contains(maria));
    }

    @Test
    void naoDeveRemoverCursoComMatriculas() {
        Student s = new Student("Pedro", "Java");
        Course c = new Course("Java");

        StudentRegistry reg = new StudentRegistry();
        reg.registerStudent(s);

        CourseCatalog cat = new CourseCatalog();
        cat.addCourse(c);

        EnrollmentService e = new EnrollmentService();
        e.enroll(s, c);

        SafeRemoveService safe = new SafeRemoveService(e);

        assertThrows(IllegalArgumentException.class, () -> safe.removeCourse(c, cat));
    }
}
