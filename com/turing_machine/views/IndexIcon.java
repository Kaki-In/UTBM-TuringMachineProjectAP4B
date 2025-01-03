package com.turing_machine.views;

import com.turing_machine.base_objects.CodeIndex;
import com.turing_machine.images.ImageDescriptable;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class IndexIcon implements Icon
{
    private final CodeIndex index;
    private final int size;

    public IndexIcon(CodeIndex index, int size)
    {
        this.index = index;
        this.size = size;
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        int middle = this.size/2-1;

        ImageDescriptable.drawIndex(grphcs, this.index, middle, middle, this.size);
    }

    @Override
    public int getIconWidth() {
        return this.size;
    }

    @Override
    public int getIconHeight() {
        return this.size;
    }
}

