import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by $SPS on 25-01-2016.
 */
public class Welcome extends JFrame implements ActionListener{
    private JPanel panel1;
    private JButton play;
    private JButton exit;
    private JTextField message;

    public Welcome()
    {

        this.play.setActionCommand("play");
        this.exit.setActionCommand("exit");
        this.play.addActionListener(this);
        this.exit.addActionListener(this);
        this.setContentPane(panel1);
        this.panel1.setPreferredSize(new Dimension(400, 400));
        this.setPreferredSize(new Dimension(400,400));
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttonPressed = (JButton)e.getSource();
        if(buttonPressed.getActionCommand()=="play"){

            this.setVisible(false);
            new GameConsole();

        }
        else{

            System.exit(0);

        }

    }
}
