import java.util.Scanner;

public class ListarCursos implements MenuAction {

    @Override
    public String getName() {
        return "Listar Cursos Cadastrados";
    }

    @Override
    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.println("--- LISTA DE CURSOS CADASTRADOS ---");

        courseCatalog.findAll();

    }
}
