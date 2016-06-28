package main.com.iontrading.anvil.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jameswillby on 17/04/2016.
 */
public class BasicLogAnalyserGUI implements LogAnalyserGUI {

    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        JFrame f = new JFrame("Basic Log Analyser");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.add(new TextDemo());
        f.pack();
        f.setVisible(true);

    }

    class TextDemo extends JPanel implements ActionListener {
        private final static String newline = "\n";
        protected JTextField configField;
        protected JTextField componentField;
        protected JTextArea textArea;

        public TextDemo() {
            super(new GridBagLayout());

            configField = new JTextField(80);
            configField.addActionListener(this);

            componentField = new JTextField(80);
            componentField.addActionListener(this);

            textArea = new JTextArea(5, 20);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            //Add Components to this panel.
            GridBagConstraints c = new GridBagConstraints();
            c.gridwidth = GridBagConstraints.REMAINDER;

            c.fill = GridBagConstraints.HORIZONTAL;
            add(configField, c);
            add(componentField, c);

            c.fill = GridBagConstraints.BOTH;
            c.weightx = 1.0;
            c.weighty = 1.0;
            add(scrollPane, c);
        }

        public void actionPerformed(ActionEvent evt) {
            String text = componentField.getText();
            textArea.append(text + newline);
            componentField.selectAll();

            //Make sure the new text is visible, even if there
            //was a selection in the text area.
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }

}
