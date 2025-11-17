public class Course {

    private final String code;
    private String name;
    private int workloadHours;

    public Course(String code, String name, int workloadHours) {
        this.code = code;
        this.name = name;
        this.workloadHours = workloadHours;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getWorkloadHours() {
        return workloadHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkloadHours(int workloadHours) {
        this.workloadHours = workloadHours;
    }

    @Override
    public String toString() {
        return code + " - " + name + " (" + workloadHours + "h)";
    }
}
