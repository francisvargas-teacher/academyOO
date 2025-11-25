import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRegistry {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (findById(student.getId()).isPresent()) {
            throw new IllegalArgumentException("Aluno com ID já existente: " + student.getId());
        }
        students.add(student);
    }

    public Optional<Student> findById(String id) {
        return students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public void removeStudent(Student s) {
        if (findById(s.getId()).isPresent()) {
            students.remove(s);
        }else{
            System.out.println("Aluno já foi removido");
        }

    }
}
