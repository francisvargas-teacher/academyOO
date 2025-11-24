
import java.util.Scanner;

public class CreateStudentAction implements MenuAction {

    @Override
    public String getName() {
        return "Cadastrar Novo Aluno";
    }

    @Override
    public void execute(Scanner scanner, CourseCatalog courseCatalog, StudentRegistry studentRegistry) {
        System.out.println("\n--- Cadastro de Novo Aluno ---");
        
        System.out.print("Digite o ID (Matrícula): ");
        String id = scanner.nextLine(); 

        System.out.print("Digite o Nome do Aluno: ");
        String name = scanner.nextLine();
        
        System.out.print("Digite o Email: ");
        String email = scanner.nextLine();
        
        try {
            Student newStudent = new Student(id, name, email);
            
            // Usamos o parâmetro studentRegistry para salvar
            studentRegistry.addStudent(newStudent);
            
            System.out.println(" Aluno " + name + " cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println(" Erro ao cadastrar aluno: " + e.getMessage());
        }
    }
}