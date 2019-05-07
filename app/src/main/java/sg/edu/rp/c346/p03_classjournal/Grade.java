package sg.edu.rp.c346.p03_classjournal;

public class Grade {
    String grade;
    String moduleCode;
    int wk;

    public Grade(String grade, String moduleCode, int wk) {
        this.grade = grade;
        this.moduleCode = moduleCode;
        this.wk = wk;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getWk() {
        return wk;
    }

    public void setWk(int wk) {
        this.wk = wk;
    }
}
