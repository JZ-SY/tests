package tests;

import java.io.ObjectInputFilter;

public abstract class Independent_test extends Tests {
    public Independent_test(String name) {
        super(studentname, CIDs, studenttype);

    @Override public boolean isWarning() { return value > 15; }
    @Override public String getText() {
        return String.format("<html><b>%s</b><br>Level: %d</html>", getName(), value);
    }
    public ObjectInputFilter.Status tryReset(int newValue) {
        if (newValue < 0) return Status.OUT_OF_RANGE;
        if (isWarning())  return Status.BUSY;
        value = newValue; return Status.OK;
    }
}