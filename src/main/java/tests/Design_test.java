package tests;

public abstract class Design_test extends Tests {
    public Design_test(String name) {
        super(name);
    }

    @Override
    public void update() {
        value += 2;
        if (value > 20) value = 0;
    }

    @Override
    public String getText() {
        return String.format("<html><b>%s</b><br>Level: %d</html>", getName(), value);
    }
}
