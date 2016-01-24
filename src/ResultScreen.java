import javax.swing.*;
import java.awt.*;

/**
 * Created by $SPS on 25-01-2016.
 */
public class ResultScreen extends JFrame{
    private JPanel panel1;
    private JLabel result;

    public ResultScreen(int winner)
    {
        super();

        this.result.setText("PLAYER" + winner + "WINS");
        this.setContentPane(result);
        this.setPreferredSize(new Dimension(500,500));
        this.setVisible(true);
    }
}
