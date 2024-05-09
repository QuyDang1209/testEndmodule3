package Model;

public class Students {
    private int studentID;
    private String name;
    private String classes;

    public Students(int studentID, String name, String classes) {
        this.studentID = studentID;
        this.name = name;
        this.classes = classes;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
