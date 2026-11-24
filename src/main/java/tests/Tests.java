package tests;

import Feeds.AssessmentFeed;

import java.util.List;

public abstract class Tests {
    protected final AssessmentFeed sys;
    private final String name;
    private String CIDs;
    private String studentname;
    private String studenttype;
    private int PROGRAM_MARK;
    private int FUNCTIONALITY_MARK;
    private int VERIFICATION_MARK;
    private int DESIGN_MARK;
    private int EXPLANATION_MARK;
    private String EXPLAINED_NOTSUCCESSFULLY; // 现在在哪个 bay

    // Encapsulation: 只给子类 super 使用
    protected Tests(String name, String CIDs, String studentname,String studenttype, int PROGRAM_MARK, int FUNCTIONALITY_MARK,int VERIFICATION_MARK,int DESIGN_MARK,int EXPLANATION_MARK) {
        this.name = name;
        this.CIDs = CIDs;
        this.studentname = studentname;
        this.studenttype = studenttype;
        this.PROGRAM_MARK = PROGRAM_MARK;
        this.FUNCTIONALITY_MARK = FUNCTIONALITY_MARK;
        this.VERIFICATION_MARK = VERIFICATION_MARK;
        this.DESIGN_MARK = DESIGN_MARK;
        this.EXPLANATION_MARK = EXPLANATION_MARK;
    }

    public abstract List<String> getCIDs();
    public abstract String getstudentname(String cid);
    public abstract String getstudenttype(String cid);
    public String getName() { return name; }
    public int getPROGRAM_MARK() { return PROGRAM_MARK; }
    public int getFUNCTIONALITY_MARK() { return FUNCTIONALITY_MARK; }
    public int getVERIFICATION_MARK() { return VERIFICATION_MARK; }
    public int getDESIGN_MARK() { return DESIGN_MARK; }
    public int getEXPLANATION_MARK() { return EXPLANATION_MARK; }
    public abstract void update();        // 每个周期做的事
    public abstract boolean isEXPLAINED_NOTSUCCESSFULLY();  // true → turn red
    public abstract String getText();

    @Override
    public String toString() {
        return getText().replaceAll("<[^>]+>", " ").replaceAll("\\s+", " ").trim();   // 正则去掉 <标签>
    }


}
