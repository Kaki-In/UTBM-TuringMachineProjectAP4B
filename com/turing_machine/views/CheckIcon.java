package com.turing_machine.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.Icon;

public class CheckIcon implements Icon
{
    private Boolean checked;

    public CheckIcon(Boolean checked)
    {
        this.checked = checked;
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        if (this.checked == null)
        {
            // empty box
            grphcs.setColor(Color.BLACK);
            grphcs.fillRect(0, 0, 30, 30);

            grphcs.setColor(Color.WHITE);
            grphcs.fillRect(1, 1, 28, 28);
        } else if (this.checked) {
            grphcs.setColor(Color.RED);
            grphcs.fillRect(0, 0, 30, 30);
            grphcs.setColor(Color.GREEN);
            grphcs.fillRect(1, 1, 28, 28);

            grphcs.setColor(Color.WHITE);
            Polygon p = new Polygon();
            p.addPoint(7, 12);
            p.addPoint(10, 20);
            p.addPoint(20, 5);
            p.addPoint(25, 10);
            p.addPoint(10, 25);
            p.addPoint(5, 15);

            grphcs.fillPolygon(p);
        } else {
            grphcs.setColor(Color.GREEN);
            grphcs.fillRect(0, 0, 30, 30);
            grphcs.setColor(Color.RED);
            grphcs.fillRect(1, 1, 28, 28);

            grphcs.setColor(Color.WHITE);
            Polygon p = new Polygon();
            p.addPoint(10, 5);
            p.addPoint(15, 10);
            p.addPoint(20, 5);
            p.addPoint(25, 10);
            p.addPoint(20, 15);
            p.addPoint(25, 20);
            p.addPoint(20, 25);
            p.addPoint(15, 20);
            p.addPoint(10, 25);
            p.addPoint(5, 20);
            p.addPoint(10, 15);
            p.addPoint(5, 10);
            
            grphcs.fillPolygon(p);
        }
    }

    @Override
    public int getIconWidth() {
        return 30;
    }

    @Override
    public int getIconHeight() {
        return 30;
    }

    public void setChecked(Boolean checked)
    {
        this.checked = checked;
    }
}

