public class Grade{
    private double nota;
    private Course curso;
    private Student aluno;

    public Grade(double nota, Course curso, Student aluno){
        this.nota = nota;
        this.curso = curso;
        this.aluno = aluno;
    }

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
    public double getNota() {
        return nota;
    }
}//end class
