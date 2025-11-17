import java.util.Scanner;
import java.util.*;


public class CadastroCurso implements MenuAction {
    Scanner scanner = new Scanner(System.in);

    public String getName() {
        System.out.println("ola");
        return "ola";
    }


    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.println("Digite seu curso");
        String nomecurso = scanner.nextLine();
        System.out.println("Quantas horas?");
        int horas = scanner.nextInt();
        Course c1 = new Course("123", nomecurso,horas );

        CourseCatalog coursecatalog = new CourseCatalog();
        coursecatalog.addCourse(c1);
    }


}
