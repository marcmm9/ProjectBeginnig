package src.main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame(); //neues Frame erstellen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x beendet das Programm und minimiert es nicht nur
        frame.setResizable(false); //Fenster lässt sich nicht in der Größe ändern
        frame.setTitle("Der Anfang"); //Titel des Fensters

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
