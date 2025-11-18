import java.util.Scanner;

public class CadastroCurso implements MenuAction {

    public String getName() {
        return "Cadastrar um novo curso";
    }

    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.println("--- Cadastro de Curso ---");

        System.out.print("Digite o nome do curso: ");
        String nomecurso = scanner.nextLine();

        System.out.print("Quantas horas? ");
        int horas = scanner.nextInt();

        scanner.nextLine();


        Course c1 = new Course("123", nomecurso, horas);

        courseCatalog.addCourse(c1);

        System.out.println("Curso cadastrado com sucesso: " + nomecurso);
    }
}