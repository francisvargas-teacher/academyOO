import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String id;   // ex: matrícula
    private String name;
    private String email;
    private List<Grade> allGrades = new ArrayList<Grade>();

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + " - " + name + " <" + email + ">";
    }
}
