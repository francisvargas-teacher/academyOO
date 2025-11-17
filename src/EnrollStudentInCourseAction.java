import java.util.Scanner;

public class EnrollStudentInCourseAction implements MenuAction {

    private EnrollmentService enrollmentService;

    public EnrollStudentInCourseAction(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Override
    public String getName() {
        return "Matricular aluno em curso";
    }

    @Override
    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {

        System.out.print("ID do aluno: ");
        String studentId = scanner.nextLine();

        System.out.print("Código do curso: ");
        String courseCode = scanner.nextLine();

        try {
            enrollmentService.enroll(studentId, courseCode);
            System.out.println("Aluno matriculado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}