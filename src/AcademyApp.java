import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcademyApp {

    private final List<MenuAction> actions = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // "Estado" compartilhado pelas features
    private final CourseCatalog courseCatalog = new CourseCatalog();
    private final StudentRegistry studentRegistry = new StudentRegistry();

    public AcademyApp() {
        // Aqui você pode registrar 1 ou 2 ações de exemplo
        // e os alunos registram as deles depois:
        // registerAction(new ListCoursesAction());

        // Adicionado: ação para listar os cursos de um aluno
        registerAction(new ListStudentCoursesAction(
                new EnrollmentService(courseCatalog, studentRegistry)
        ));
    }

    public void registerAction(MenuAction action) {
        actions.add(action);
    }

    public void start() {
        int option;
        do {
            System.out.println("=== AcademyOO ===");
            for (int i = 0; i < actions.size(); i++) {
                System.out.printf("%d - %s%n", i + 1, actions.get(i).getName());
            }
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                option = -1;
            }

            if (option > 0 && option <= actions.size()) {
                MenuAction action = actions.get(option - 1);
                action.execute(scanner, courseCatalog, studentRegistry);
            }
        } while (option != 0);

        System.out.println("Encerrando AcademyOO...");
    }
}