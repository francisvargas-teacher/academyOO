import java.util.ArrayList;

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
    public ArrayList<Double> getGradesAlunoCurso(Course curso, Student aluno){
        ArrayList<Double> TodasNotas = new ArrayList<Double>();
        for(int i = 0;i < notas.size();i++){
            if(notas.get(i).getCurso().equals(curso) &&  notas.get(i).getAluno().equals(aluno)){
                TodasNotas.add(notas.get(i).getNota());
            }
        }
        return TodasNotas;
    }

}//end class
