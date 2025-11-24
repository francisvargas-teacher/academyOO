public class Main {

public static void main(String[] args) {

AcademyApp app = new AcademyApp();

        //Serviços centrais
CourseCatalog courseCatalog = new CourseCatalog();
StudentRegistry studentRegistry = new StudentRegistry();

        //matriculas
EnrollmentService enrollmentService = new EnrollmentService(studentRegistry, courseCatalog);
      
app.registerAction(new EnrollStudentInCourseAction(enrollmentService));
app.registerAction(new ListStudentCoursesAction(enrollmentService));

       
        // Inicia o sistema
app.start();

    }
}