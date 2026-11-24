package ui;

import model.Manager;
import tests.Tests;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class GridFrame extends JFrame {
    private final Manager manager;
    private final JPanel[] panels;
    private final JLabel[] labels;

    public GridFrame(Manager manager, int rows, int cols) {
        super("Tests");
        this.manager = manager;
        int n = rows * cols;
        panels = new JPanel[n];
        labels = new JLabel[n];

        JPanel grid = new JPanel(new GridLayout(rows, cols, 5, 5));   // 必写：网格（行, 列, 横间距, 纵间距）
        setLayout(new BorderLayout());
        add(grid, BorderLayout.CENTER);
        add(buildButtons(), BorderLayout.NORTH);

        for (int i = 0; i < n; i++) {
            panels[i] = new JPanel(new BorderLayout());
            labels[i] = new JLabel("", SwingConstants.CENTER);
            panels[i].add(labels[i], BorderLayout.CENTER);
            panels[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            grid.add(panels[i]);
        }
        setSize(900, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        refresh();
    }

    public void refresh() {
        for (int i = 0; i < panels.length; i++) {
            if (i < manager.size()) {
                Tests t = manager.get(i);
                labels[i].setText(t.getText());
                panels[i].setBackground(t.EXPLAINED_NOTSUCCESSFULLY() ? Color.RED : Color.WHITE);

            } else {
                labels[i].setText("");
                panels[i].setBackground(Color.LIGHT_GRAY);
            }
        }
        repaint();

    private JPanel buildButtons() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton reportBtn = new JButton("Report now");
        reportBtn.addActionListener(e -> manager.report(-1));
        JButton resetBtn = new JButton("Reset all to 0");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override public void actionPerformed(java.awt.event.ActionEvent e) {
                manager.resetAll(0);
                refresh();
            }
        });
        JButton undoBtn = new JButton("Undo shape");
        bar.add(reportBtn); bar.add(resetBtn); bar.add(undoBtn);
        return bar;
    }
}

