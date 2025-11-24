import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class test_gradeService {
    GradeService gradeService = new GradeService();
    Course curso = new Course("1","Test",20);
    Student aluno = new Student("1","TestAluno","teste@teste");
    @Test
    void criar_Nota_corretamente() {
        Grade nota1 = gradeService.SetGrade(10,curso,aluno);
    }
    @Test
    void Coletar_media_notas(){
        Grade nota1 = gradeService.SetGrade(10,curso,aluno);
        Assertions.assertEquals(1,gradeService.mediaNotas(curso));
    }
    @Test
    void Coletar_notas_aluno(){
        Grade nota1 = gradeService.SetGrade(10,curso,aluno);
        ArrayList<Double> array1 = gradeService.getGradesAlunoCurso(curso,aluno);
        Assertions.assertEquals(List.of(1.0),array1);
    }

}
