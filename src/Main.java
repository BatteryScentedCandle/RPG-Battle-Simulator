import javax.swing.*;

public class Main extends JFrame {
    private JPanel panel1;

    public Main(){
        setTitle("RPG BATTLE SIMULATOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
