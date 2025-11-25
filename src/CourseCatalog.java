import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseCatalog {

    private final List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        // Regra simples: não permitir código duplicado
        if (findByCode(course.getCode()).isPresent()) {
            throw new IllegalArgumentException("Curso com código já existente: " + course.getCode());
        }
        courses.add(course);
    }
    public void removeCourse(Course course){
        if (findByCode(course.getCode()).isPresent()) {
            courses.remove(course);
            System.out.println("Removido");
        }else{
            System.out.println("Curso já foi removido anteriormente");
        }

    }

    public Optional<Course> findByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }
}
