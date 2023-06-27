package dk.shadow.transporter.gui.listener;


import com.sun.istack.internal.NotNull;
import dk.shadow.transporter.Main;
import dk.shadow.transporter.gui.enums.Downloader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ButtonListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) Main.getGui().cb.getSelectedItem();

        switch (selectedItem) {
            case "laby4":
                // Handle the "laby4" case
                System.out.println(Downloader.LABY4.getUrl());
                if (!Downloader.LABY4.pathExists()) {
                    JOptionPane.showMessageDialog(null, "Kunne ikke finde " + Downloader.LABY4.getPath(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (Downloader.LABY4.fileExists()) {
                    JOptionPane.showMessageDialog(null, "Transporter findes allerede: " + Downloader.LABY4.pathExists(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }


                break;
            case "laby3_v1_16_5":
                // Handle the "laby3_v1_16_5" case
                System.out.println(Downloader.LABY3_V1_16_5.getUrl());
                if (!Downloader.LABY3_V1_16_5.pathExists()) {
                    JOptionPane.showMessageDialog(null, "Kunne ikke finde " + Downloader.LABY3_V1_16_5.getPath(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (Downloader.LABY3_V1_16_5.fileExists()) {
                    JOptionPane.showMessageDialog(null, "Transporter findes allerede: " + Downloader.LABY3_V1_16_5.pathExists(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "laby3_v1_12_2":
                // Handle the "laby3_v1_12_2" case
                System.out.println(Downloader.LABY3_V1_12_2.getUrl());
                if (!Downloader.LABY3_V1_12_2.pathExists()) {
                    JOptionPane.showMessageDialog(null, "Kunne ikke finde " + Downloader.LABY3_V1_12_2.getPath(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (Downloader.LABY3_V1_12_2.fileExists()) {
                    JOptionPane.showMessageDialog(null, "Transporter findes allerede: " + Downloader.LABY3_V1_12_2.pathExists(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "laby3_v1_8_9":
                // Handle the "laby3_v1_8_9" case
                System.out.println(Downloader.LABY3_V1_8_9.getUrl());

                if (!Downloader.LABY3_V1_8_9.pathExists()) {
                    JOptionPane.showMessageDialog(null, "Kunne ikke finde " + Downloader.LABY3_V1_8_9.getPath(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (Downloader.LABY3_V1_8_9.fileExists()) {
                    JOptionPane.showMessageDialog(null, "Transporter findes allerede: " + Downloader.LABY3_V1_8_9.pathExists(), "DOWNLOAD ERROR", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    Downloader.LABY3_V1_8_9.download();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                // Handle the default case (if needed)
                break;
        }

    }
}
