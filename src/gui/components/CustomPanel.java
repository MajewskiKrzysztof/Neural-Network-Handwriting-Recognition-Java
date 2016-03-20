package gui.components;

import gui.components.data.Section;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomPanel extends JPanel {

    protected ArrayList<Section> sections;
    private int width;
    private int height;
    private int count;

    public CustomPanel(int w, int h, int count) {
        super();
        this.width = w;
        this.height = h;
        this.count = count;

        setPreferredSize(new Dimension(w, h));
        setBackground(Color.WHITE);

        generateSections();
    }

    private void generateSections() {
        sections = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                sections.add(new Section(i * (width / count), j * (height / count), width / count, height / count));
            }
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        generateSections(g);
        drawSections(g);

    }

    private void generateSections(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);

        for (Section s : sections) {
            g.drawLine(0, s.getY(), width, s.getY());
            g.drawLine(s.getX(), 0, s.getX(), height);
        }
    }

    private void drawSections(Graphics g) {
        g.setColor(Color.BLACK);
        for (Section s : sections) {
            if (s.isActive()) {
                g.fillRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
            }
        }
    }

    public ArrayList<Integer> getPixels() {
        ArrayList<Integer> pixels = new ArrayList<>();
        for (Section s : sections) {
            if (s.isActive())
                pixels.add(1);
            else
                pixels.add(0);
        }

        return pixels;
    }

    public void clear() {
        for (Section s : sections) {
            s.setActive(false);
        }

        repaint();
    }

    public void drawLetter(ArrayList<Integer> pixels) {
        for (int i = 0; i < pixels.size(); i++) {
            if (pixels.get(i) == 1)
                sections.get(i).setActive(true);
            else
                sections.get(i).setActive(false);
        }

        repaint();
    }

    public ArrayList<Section> getSections() {
        return sections;
    }
}
