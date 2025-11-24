package academyoo.actions;

import academyoo.core.MenuAction;
import academyoo.core.Student;
import academyoo.core.StudentRegistry;
import academyoo.core.CourseCatalog;
import java.util.Scanner;
import java.util.Collection;

public class ListStudentsAction implements MenuAction {

    @Override
    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.println("\n--- Lista de Alunos Cadastrados ---");
        
        // Pega a Collection de alunos do Registry (parâmetro)
        Collection<Student> students = studentRegistry.getStudents();
        
        if (students.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado no sistema.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-------------------------------------");
    }

    @Override
    public String name() {
        return "Listar Todos os Alunos";
    }
}