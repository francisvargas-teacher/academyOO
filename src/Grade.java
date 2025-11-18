import java.util.ArrayList;
import java.util.List;

public class Grade{
    private double nota;
    private Course curso;
    private Student aluno;

    public String lancarNota(Course curso, Student aluno, double nota){
        this.curso = curso;
        this.aluno = aluno;
        this.nota = nota;

        return "Notas lançadas com sucesso!\nCurso: "+this.curso+"\nAluno: "+this.aluno+"\nNota: "+this.nota;
    }//end func lancarNota

    public Course getCurso() {
        return curso;
    }
    public Student getAluno() {
        return aluno;
    }

    public double getNotas() {
        return nota;
    }
}//end class
