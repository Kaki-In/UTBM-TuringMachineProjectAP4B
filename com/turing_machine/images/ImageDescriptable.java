package com.turing_machine.images;

import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.base_objects.CodeValue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

public interface ImageDescriptable
{
    public abstract void createImage(Graphics g2D);

    public static void drawTriangle(Graphics g2D, int x, int y, int size)
    {
        int cossize = Math.round((float) (Math.cos(Math.PI/6)*size/2));

        Polygon polygon = new Polygon();
        polygon.addPoint(x, y - 3*size/8);
        polygon.addPoint(x + cossize, y + 3*size/8);
        polygon.addPoint(x - cossize, y + 3*size/8);

        g2D.setColor(new Color(0x53ABD0));
        g2D.fillPolygon(polygon);
        g2D.drawPolygon(polygon);
    }

    public static void drawSquare(Graphics g2D, int x, int y, int size)
    {
        g2D.setColor(new Color(0xF2B211));
        g2D.fillRect(x-size/2, y-size/2, size, size);
        g2D.drawRect(x-size/2, y-size/2, size, size);
    }

    public static void drawCircle(Graphics g2D, int x, int y, int size)
    {
        g2D.setColor(new Color(0x8066AD));
        g2D.fillOval(x - size/2, y - size/2, size, size);
        g2D.drawOval(x - size/2, y - size/2, size, size);
    }
    
    public static void drawIndex(Graphics g2D, CodeIndex index, int x, int y, int size)
    {
        switch (index) {
            case CodeIndex.FIRST_BLUE_TRIANGLE:
                drawTriangle(g2D, x, y, size);
                break;

            case CodeIndex.SECOND_YELLOW_SQUARE:
                drawSquare(g2D, x, y, size);
                break;

            case CodeIndex.THIRD_PURPLE_CIRCLE:
                drawCircle(g2D, x, y, size);
                break;
        }
    }

    public static void draw1Value(Graphics g2D, int x, int y, int size)
    {
        int topx = x-size/2 + size/5;
        int topy = y-size/2;

        g2D.fillRoundRect(topx, topy, 2*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx+size/5, topy, size/5, size, size/12, size/12);
        g2D.fillRoundRect(topx, topy+4*size/5, 3*size/5, size/5, size/12, size/12);
    }

    public static void draw2Value(Graphics g2D, int x, int y, int size)
    {
        int topx = x-size/2 + size/5;
        int topy = y-size/2;

        g2D.fillRoundRect(topx, topy, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx+2*size/5, topy, size/5, 3*size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+2*size/5, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+2*size/5, size/5, 3*size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+4*size/5, 3*size/5, size/5, size/12, size/12);
    }

    public static void draw3Value(Graphics g2D, int x, int y, int size)
    {
        int topx = x-size/2 + size/5;
        int topy = y-size/2;

        g2D.fillRoundRect(topx, topy, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+2*size/5, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+4*size/5, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx+2*size/5, topy, size/5, size, size/12, size/12);
    }

    public static void draw4Value(Graphics g2D, int x, int y, int size)
    {
        int topx = x-size/2 + size/5;
        int topy = y-size/2;

        g2D.fillRoundRect(topx, topy, size/5, 3*size/5, size/12, size/12);
        g2D.fillRoundRect(topx+2*size/5, topy, size/5, size, size/12, size/12);
        g2D.fillRoundRect(topx, topy, 3*size/5, size/5, size/12, size/12);
    }

    public static void draw5Value(Graphics g2D, int x, int y, int size)
    {
        int topx = x-size/2 + size/5;
        int topy = y-size/2;

        g2D.fillRoundRect(topx, topy, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy, size/5, 3*size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+2*size/5, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx+2*size/5, topy+2*size/5, size/5, 3*size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+4*size/5, 3*size/5, size/5, size/12, size/12);
    }

    public static void draw6Value(Graphics g2D, int x, int y, int size)
    {
        int topx = x-size/2 + size/5;
        int topy = y-size/2;

        g2D.fillRoundRect(topx, topy, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy, size/5, size, size/12, size/12);
        g2D.fillRoundRect(topx, topy+2*size/5, 3*size/5, size/5, size/12, size/12);
        g2D.fillRoundRect(topx+2*size/5, topy+2*size/5, size/5, 3*size/5, size/12, size/12);
        g2D.fillRoundRect(topx, topy+4*size/5, 3*size/5, size/5, size/12, size/12);
    }

    public static void drawValue(Graphics g2D, CodeValue value, int x, int y, int size)
    {
        switch (value) {
            case CodeValue.ONE:
                draw1Value(g2D, x, y, size);
                break;

            case CodeValue.TWO:
                draw2Value(g2D, x, y, size);
                break;

            case CodeValue.THREE:
                draw3Value(g2D, x, y, size);
                break;

            case CodeValue.FOUR:
                draw4Value(g2D, x, y, size);
                break;

            case CodeValue.FIVE:
                draw5Value(g2D, x, y, size);
                break;
        }
    }

    public static void drawEquals(Graphics g2D, int x, int y, int size)
    {
        g2D.fillRoundRect(x - size/2, y-size/2+size/5, size, size/5, size/20, size/20);
        g2D.fillRoundRect(x - size/2, y+size/10, size, size/5, size/20, size/20);
    }

    public static void drawGreaterThan(Graphics g2D, int x, int y, int size)
    {
        int cossize = Math.round((float) (Math.cos(Math.PI/4)*size/2));

        g2D.drawLine(x-cossize/2, y-cossize/2, x+cossize/2, y);
        g2D.drawLine(x-cossize/2, y+cossize/2, x+cossize/2, y);
    }

    public static void drawLowerThan(Graphics g2D, int x, int y, int size)
    {
        int cossize = Math.round((float) (Math.cos(Math.PI/4)*size/2));

        g2D.drawLine(x+cossize/2, y-cossize/2, x-cossize/2, y);
        g2D.drawLine(x+cossize/2, y+cossize/2, x-cossize/2, y);
    }

    public static void drawGreaterEqualThan(Graphics g2D, int x, int y, int size)
    {
        int cossize = Math.round((float) (Math.cos(Math.PI/4)*size/2));

        drawGreaterThan(g2D, x, y, size);

        g2D.drawLine(x-cossize/2, y+size/2, x+cossize/2, size/2-cossize/2);
    }

    public static void drawLowerEqualThan(Graphics g2D, int x, int y, int size)
    {
        int cossize = Math.round((float) (Math.cos(Math.PI/4)*size/2));

        drawLowerThan(g2D, x, y, size);

        g2D.drawLine(x+cossize/2, y+size/2, x-cossize/2, size/2-cossize/2);
    }

    public static void drawPlus(Graphics g2D, int x, int y, int size)
    {
        g2D.drawLine(x-size/4, y, x+size/4, y);
        g2D.drawLine(x, y-size/4, x, y+size/4);
    }

    public static void drawMult(Graphics g2D, int x, int y, int size)
    {
        g2D.drawLine(x-size/4, y-size/4, x+size/4, y+size/4);
        g2D.drawLine(x+size/4, y-size/4, x-size/4, y+size/4);
    }

    public static void drawSeparation(Graphics g2D, int x, int y, int size)
    {
        g2D.drawLine(x, y-size/2, x, y+size/2);
    }

    public static void drawTopRightArrow(Graphics g2D, int x, int y, int size)
    {
        g2D.drawLine(x-size/2, y+size/2, x+size/2, y-size/2);

        Polygon polygon = new Polygon();
        polygon.addPoint(x+size/4, y-size/2);
        polygon.addPoint(x+size/2, y-size/2);
        polygon.addPoint(x+size/2, y-size/4);

        g2D.fillPolygon(polygon);
        g2D.drawPolygon(polygon);
    }

    public static void drawBottomRightArrow(Graphics g2D, int x, int y, int size)
    {
        g2D.drawLine(x-size/2, y-size/2, x+size/2, y+size/2);

        Polygon polygon = new Polygon();
        polygon.addPoint(x+size/4, y+size/2);
        polygon.addPoint(x+size/2, y+size/2);
        polygon.addPoint(x+size/2, y+size/4);

        g2D.fillPolygon(polygon);
        g2D.drawPolygon(polygon);
    }

    public static void drawTopDownArrows(Graphics g2D, int x, int y, int size)
    {
        drawBottomRightArrow(g2D, x, y, size);

        Color color = g2D.getColor();

        g2D.setColor(Color.WHITE);
        drawTopRightArrow(g2D, x, y, size*11/10);
        g2D.setColor(color);
        drawTopRightArrow(g2D, x, y, size);
    }

    public static void drawValueSubline(Graphics g2D, int x, int y, int size)
    {
        g2D.drawLine(x-size/2, y+size/2, x-size/2, y+size/2 + size/5);
        g2D.drawLine(x-size/2, y+size/2+size/5, x+size/2, y+size/2 + size/5);
        g2D.drawLine(x+size/2, y+size/2, x+size/2, y+size/2 + size/5);
    }

    public static void drawText(Graphics g2D, String text, int x, int y, int size)
    {
        g2D.setFont(new Font(getFontName(), Font.LAYOUT_LEFT_TO_RIGHT, size));

        g2D.drawString(text, x, y+size/2);
    }

    public static void drawPodium(Graphics g2D, int height1, int height2, int height3, int x, int y, int size)
    {
        int topx = x-size/2;
        int topy = y-3*size/8;

        g2D.fillRect(topx, topy+size/4, size/3, height1*size/4);
        g2D.fillRect(topx, topy+size/4, size/3, height1*size/4);

        g2D.fillRect(topx+size/3, topy+size/4, size/3, height2*size/4);
        g2D.fillRect(topx+size/3, topy+size/4, size/3, height2*size/4);

        g2D.fillRect(topx+2*size/3, topy+size/4, size/3, height3*size/4);
        g2D.fillRect(topx+2*size/3, topy+size/4, size/3, height3*size/4);
    }

    public static void drawBalance(Graphics g2D, int x, int y, int size)
    {
        drawText(g2D, "?", x-size/2, y, size);
    }

    public static String getFontName()
    {
        return "";
    }
}


