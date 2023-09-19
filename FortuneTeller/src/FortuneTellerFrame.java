import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FortuneTellerFrame extends JFrame {
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JTextArea fortuneArea;

    JScrollPane fortuneScroll;

    JLabel titleLbl;

    ImageIcon fortuneIcon;

    JButton readBtn;
    JButton quitBtn;

    String[] fortunes = {
            "You will explode.",
            "You will find love.",
            "You will eat a giant meatball.",
            "You will succumb to polio.",
            "You will fail a math test.",
            "You will do something cool.",
            "You will face a deadly foe.",
            "You will have a reasonably good day.",
            "You will slip on a banana peel.",
            "You will hug a gorilla.",
            "You will be you.",
            "You will read another fortune."
    };
    int lastFortune = -1;

    public FortuneTellerFrame() {
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        setTitle("Fortune Teller");
        setSize((int)(screenSize.width * .75), (int)(screenSize.height * .75));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createTopPanel() {
        topPnl = new JPanel();
        fortuneIcon = new ImageIcon("src/fortuneicon.jpg");
        titleLbl = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));

        topPnl.add(titleLbl);
        add(topPnl, BorderLayout.NORTH);
    }

    private void createMiddlePanel() {
        middlePnl = new JPanel();
        fortuneArea = new JTextArea(14, 48);
        fortuneArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        fortuneScroll = new JScrollPane(fortuneArea);

        middlePnl.add(fortuneScroll);
        add(middlePnl, BorderLayout.CENTER);
    }

    private void createBottomPanel() {
        bottomPnl = new JPanel();
        readBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");
        readBtn.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        quitBtn.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));

        readBtn.addActionListener(((ActionEvent ea) -> tellFortune()));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(readBtn);
        bottomPnl.add(quitBtn);
        add(bottomPnl, BorderLayout.SOUTH);
    }

    private void tellFortune() {
        int rdm;
        do {
            rdm = (int)Math.floor(Math.random() * 12);
        } while (rdm == lastFortune);
        lastFortune = rdm;

        fortuneArea.append(fortunes[rdm] + "\n");
    }
}
