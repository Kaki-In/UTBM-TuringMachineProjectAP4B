
import com.turing_machine.handlers.MainPlatform;
import com.turing_machine.views.MainFrame;

public class Main
{
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            displayFrame();
        });
    }

    public static void displayFrame()
    {
        MainPlatform platform = new MainPlatform();

        MainFrame frame = new MainFrame(platform.getState());

        frame.getFrame().setVisible(true);
    }


}


