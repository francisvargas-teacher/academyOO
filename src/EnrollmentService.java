import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();
    private StudentRegistry studentRegistry;
    private CourseCatalog courseCatalog;

    public EnrollmentService(StudentRegistry studentRegistry, CourseCatalog courseCatalog) {
        this.studentRegistry = studentRegistry;
        this.courseCatalog = courseCatalog;
    }

    public void enroll(String studentId, String courseCode) {

        // Busca aluno
        Student student = studentRegistry.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado."));

        // Busca curso
        Course course = courseCatalog.findByCode(courseCode)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado."));

        // Verifica se já está matriculado
        for (Enrollment e : enrollments) {
            if (e.getStudent().getId().equalsIgnoreCase(studentId) &&
                    e.getCourse().getCode().equalsIgnoreCase(courseCode)) {
                throw new IllegalArgumentException("Aluno já está matriculado nesse curso.");
            }
        }

        enrollments.add(new Enrollment(student, course));
    }

    public List<Course> getCoursesByStudent(String studentId) {
        List<Course> list = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getStudent().getId().equalsIgnoreCase(studentId)) {
                list.add(e.getCourse());
            }
        }

        return list;
    }

    public boolean isStudentEnrolled(String studentId, String courseCode) {
        // Busca aluno
        Student student = studentRegistry.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado."));

        // Busca curso
        Course course = courseCatalog.findByCode(courseCode)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado."));

        // Verifica se já está matriculado
        for (Enrollment e : enrollments) {
            if (e.getStudent().getId().equalsIgnoreCase(studentId) &&
                    e.getCourse().getCode().equalsIgnoreCase(courseCode)) {
                return true;
            }
        }
        return false;
    }

}