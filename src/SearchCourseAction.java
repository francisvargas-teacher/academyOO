import java.util.List;
import java.util.Scanner;

public class SearchCourseAction implements MenuAction {

    private final CourseCatalog courseCatalog;

    public SearchCourseAction(CourseCatalog catalog) {
        this.courseCatalog = catalog;
    }

    @Override
    public void execute(Scanner sc, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.print("Digite parte do nome do curso: ");
        sc.nextLine(); // limpa buffer
        String keyword = sc.nextLine().toLowerCase();

        List<Course> cursos = courseCatalog.findAll();

        System.out.println("\n--- Resultados ---");

        cursos.stream()
            .filter(c -> c.getName().toLowerCase().contains(keyword))
            .forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
    }

    @Override
    public String getName() {
        return "Buscar cursos por palavra-chave";
    }

}
    