import java.util.ArrayList;
import java.util.List;

public class GradeService {

    private ArrayList<Grade> notas = new ArrayList<Grade>();

    public double mediaNotas(Course curso){
        double soma = 0;
        int i;
        for(i = 0;i < notas.size();i++){
            if(notas.get(i).getCurso().equals(curso)){
                soma+=notas.get(i).getNota();
            }
        }
        return soma/i;
    }

    public Grade SetGrade(double nota, Course curso, Student aluno){
        Grade grade_temp = new Grade(nota, curso, aluno);
        notas.add(grade_temp);
        return grade_temp;
    }

}//end class
