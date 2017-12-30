package com.nikita;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class Window extends JFrame {

    private JFileChooser f = new JFileChooser();
    private JPanel mainPanel = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JFrame frame = new JFrame();

    public Window() {

        JMenu file = new JMenu("Файл");

        JMenuItem newVote = new JMenuItem("Создать новое голосование");
        JMenuItem openVote = new JMenuItem("Открыть голосование");
        JMenuItem saveVote = new JMenuItem("Сохранить голосование");
        JMenuItem exit = new JMenuItem("Выйти");

        file.add(newVote);
        file.add(openVote);
        file.add(saveVote);
        file.add(exit);

        JLabel hello = new JLabel("Добро пожаловать в программу голосований.");
        Font font = new Font(null, Font.BOLD, 18);
        hello.setFont(font);

        menuBar.add(file);
        mainPanel.add(hello);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setTitle("Vote");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(760, 400));
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(menuBar);
        frame.add(mainPanel);
        listeners(newVote, openVote, saveVote, exit);
        frame.setVisible(true);
    }

    public void listeners(JMenuItem newVote, JMenuItem openVote, JMenuItem saveVote, JMenuItem exit) {
        newVote.addActionListener(e -> newVote());

        openVote.addActionListener((ActionEvent e) -> {
            f.showOpenDialog(null);
            File file2 = f.getSelectedFile();
            System.out.println(file2.toString());
        });

        saveVote.addActionListener(e -> {

        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

    }

    private void newVote() {
        String s = (String) JOptionPane.showInputDialog(this, "Введите название голосования:",
                "Название голосования", JOptionPane.PLAIN_MESSAGE);
        if (s != null)
            frame.setTitle("Vote | Name: " + s);
        mainPanel.removeAll();
        mainPanel.setBorder(BorderFactory.createEtchedBorder());
        settings();
    }

    private void settings() {
        JLabel label = new JLabel("Заполните поля: ");
        JLabel labelOne = new JLabel("Имя первого: ");
        JLabel labelTwo = new JLabel("Имя второго: ");
        JButton add = new JButton("Добавить");
        JButton begin = new JButton("Начать");

        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();

        JTextField textFieldOne = new JTextField(20);
        JTextField textFieldTwo = new JTextField(20);

        box1.add(labelOne);
        box1.add(textFieldOne);

        box2.add(labelTwo);
        box2.add(textFieldTwo);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));

        mainPanel.add(label);
        mainPanel.add(box1);
        mainPanel.add(box2);
        mainPanel.add(add);
        mainPanel.add(begin);

        begin.addActionListener(e -> {
            JFrame frame = new JFrame();
            frame.setVisible(true);
        });

    }
}
