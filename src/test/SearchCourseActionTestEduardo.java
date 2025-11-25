import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import actions.SearchCourseAction;
import models.Course;
import repositories.CourseCatalog;

public class SearchCourseActionTestEduardo {

    @Test
    void deveFiltrarCursoPorPalavraChave() {
        CourseCatalog catalog = new CourseCatalog();

        catalog.addCourse(new Course("Java Básico"));
        catalog.addCourse(new Course("Python para iniciantes"));
        catalog.addCourse(new Course("Java Avançado"));

        String entradaUsuario = "\nJava"; // Simula digitação
        System.setIn(new ByteArrayInputStream(entradaUsuario.getBytes()));

        SearchCourseAction action = new SearchCourseAction(catalog);
        Scanner sc = new Scanner(System.in);

        action.execute(sc);

        List<Course> cursos = catalog.getAllCourses();

        assertEquals(3, cursos.size());
        assertTrue(cursos.get(0).getName().contains("Java"));
    }
}
