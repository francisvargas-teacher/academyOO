import java.util.Scanner;
import java.util.Collection;

public class ListStudentsAction implements MenuAction {

    @Override
    public String getName() {
        return "Listar Todos os Alunos";
    }

    @Override
    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.println("\n--- Lista de Alunos Cadastrados ---");
        
        // Pega a Collection de alunos do Registry (parâmetro)
        Collection<Student> students = studentRegistry.findAll();
        
        if (students.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado no sistema.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------");
    }
}