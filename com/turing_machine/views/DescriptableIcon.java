package com.turing_machine.views;

import com.turing_machine.images.ImageDescriptable;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

class DescriptableIcon implements Icon
{

    private final int width;

    private final int height;

    private final ImageDescriptable descriptor;

    public DescriptableIcon(int width, int height, ImageDescriptable descriptor) {
        this.width = width;
        this.height = height;

        this.descriptor = descriptor;
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        this.descriptor.createImage(grphcs);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}

