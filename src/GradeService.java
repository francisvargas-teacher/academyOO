import java.util.ArrayList;
import java.util.List;

public class GradeService {

    private ArrayList<Grade> notas = new ArrayList<Grade>();

    public double mediaNotas(Course curso){
        int count = 0;
        double soma = 0;

        for(Grade nota1:notas){
            if(nota1.getCurso() == curso){
                for(int i = 0; nota1.getNotas().size() > i; i++){
                    soma = soma + nota1.getNotas();
                    count++;
                }
            }
        }
    }

    public void SetGrade(Grade nota){
        notas.add(nota);
    }



}//end class
