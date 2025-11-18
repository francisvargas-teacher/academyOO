import java.util.List;
import java.util.Scanner;

// Lista os cursos em que um aluno está matriculado
public class ListStudentCoursesAction implements MenuAction {

    private EnrollmentService enrollmentService; // serviço de matrículas

    public ListStudentCoursesAction(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Override
    public String getName() {
        return "Listar cursos de um aluno";
    }

    @Override
    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {

        System.out.print("ID do aluno: ");
        String studentId = scanner.nextLine();

        // busca todos os cursos do aluno
        List<Course> courses = enrollmentService.getCoursesByStudent(studentId);

        if (courses.isEmpty()) {
            System.out.println("Este aluno não está matriculado em nenhum curso.");
            return;
        }

        // imprime os cursos encontrados
        System.out.println("Cursos do aluno:");
        for (Course c : courses) {
            System.out.println("- " + c);
        }
    }
}