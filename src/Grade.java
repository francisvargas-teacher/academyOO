import java.util.ArrayList;
import java.util.List;

public class Grade{
    private List<> notas = new ArrayList<>();
    private Course curso;
    private Student aluno;

    public String lancarNota(Course curso, Student aluno, double nota){
        this.curso = curso;
        this.aluno = aluno;
        this.notas.add(nota);

        return "Notas lançadas com sucesso!\nCurso: "+this.curso+"\nAluno: "+this.aluno+"\nNota: "+this.nota;
    }//end func lancarNota


}//end class
