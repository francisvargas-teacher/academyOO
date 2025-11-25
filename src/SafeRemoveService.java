public class SafeRemoveService {

    private final EnrollmentService enrollmentService;

    public SafeRemoveService(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void removeStudent(Student s, StudentRegistry registry, Course c) {
        if (enrollmentService.isStudentEnrolled(s.getId(),c.getCode())) {
            throw new IllegalArgumentException("❌ Não é possível remover: aluno está matriculado.");
        }
        registry.removeStudent(s);
    }

    public void removeCourse(Course c, CourseCatalog catalog) {
        catalog.removeCourse(c);
    }
}
