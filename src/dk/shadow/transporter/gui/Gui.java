package dk.shadow.transporter.gui;

import dk.shadow.transporter.gui.listener.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class Gui {
    public JComboBox<String> cb;

    public Gui(String title) {
        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel();
        JButton button = new JButton("Download");

        String[] versions = {"laby4", "laby3_v1_16_5", "laby3_v1_12_2", "laby3_v1_8_9"};
        cb = new JComboBox<>(versions);

        panel.add(cb);
        panel.add(button);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 1, 10, 10));
        panel.setPreferredSize(new Dimension(300, 150)); // Set preferred size for the panel

        button.addActionListener(new ButtonListener());

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public JComboBox<String> getCb() {
        return cb;
    }
}
