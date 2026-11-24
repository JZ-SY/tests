import model.Manager;
import ui.GridFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    private static int ticks = 0;

    public static void main(String[] args) {
        Manager manager = new Manager();
        GridFrame frame = new GridFrame(manager, 1, 3);


        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticks++;
                manager.updateAll();
                frame.refresh();
                if (ticks % 10 == 0) manager.report(ticks);
            }
        });
        timer.start();
    }

}
