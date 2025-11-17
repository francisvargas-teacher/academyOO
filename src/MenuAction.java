import java.util.Scanner;

public interface MenuAction {

    String getName();

    void execute(Scanner scanner,
                 CourseCatalog courseCatalog,
                 StudentRegistry studentRegistry);
}