package tests;

public abstract class Assisted_test extends Tests {
    public static int FINALA;
    public Assisted_test(String name, int CIDs, String studenttype, String studentname) { super(name); }
    public FINALA tryReset(int sys.getResult().getFUNCTIONALITY_MARK, int sys.getResult ) {
        FINALA = 0.4*tests.getFUNCTIONALITY_MARK()+0.6*tests.getVERIFICATION_MARK();
    }

    @Override public void update()       { value += 2; if (value > 20) value = 0; }   // 不同规则
    @Override public String getText() {
        return String.format("<html><b>%s</b><br>Level: %d</html>", getName(), value);
    }
}



