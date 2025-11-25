public class SafeRemoveService {

    private final EnrollmentService enrollmentService;

    public SafeRemoveService(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void removeStudent(Student s, StudentRegistry registry) {
        if (enrollmentService.isStudentEnrolled(s)) {
            throw new IllegalArgumentException("❌ Não é possível remover: aluno está matriculado.");
        }
        registry.removeStudent(s);
    }

    public void removeCourse(Course c, CourseCatalog catalog) {
        if (enrollmentService.hasEnrollmentsInCourse(c)) {
            throw new IllegalArgumentException("❌ Não é possível remover: curso possui matrículas.");
        }
        catalog.removeCourse(c);
    }
}
