package gui.components;

import gui.components.data.Section;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingPanel extends CustomPanel implements MouseMotionListener, MouseListener {

    public DrawingPanel(int w, int h, int count) {
        super(w, h, count);

        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        paintSections(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        paintSections(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void paintSections(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            for (Section s : sections) {
                if (e.getX() > s.getX() && e.getX() < s.getX() + s.getWidth() && e.getY() > s.getY() && e.getY() < s.getY() + s.getHeight()) {
                    s.setActive(true);

                }
            }
        } else if (SwingUtilities.isRightMouseButton(e)) {
            for (Section s : sections) {
                if (e.getX() > s.getX() && e.getX() < s.getX() + s.getWidth() && e.getY() > s.getY() && e.getY() < s.getY() + s.getHeight())
                    s.setActive(false);
            }
        }

        repaint();
    }
}
