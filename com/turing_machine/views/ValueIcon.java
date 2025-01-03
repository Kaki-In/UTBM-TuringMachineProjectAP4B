package com.turing_machine.views;

import com.turing_machine.base_objects.CodeValue;
import com.turing_machine.images.ImageDescriptable;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

public class ValueIcon implements Icon
{
    private final int value;
    private final int size;

    public ValueIcon(CodeValue value, int size)
    {
        this(value.toInteger(), size);
    }

    public ValueIcon(int value, int size)
    {
        this.value = value;
        this.size = size;
    }

    @Override
    public void paintIcon(Component cmpnt, Graphics grphcs, int i, int i1) {
        int middle = this.size/2-1;
        switch (this.value) {
            case 1:
                ImageDescriptable.draw1Value(grphcs, middle, middle, this.size);
                break;
            case 2:
                ImageDescriptable.draw2Value(grphcs, middle, middle, this.size);
                break;
            case 3:
                ImageDescriptable.draw3Value(grphcs, middle, middle, this.size);
                break;
            case 4:
                ImageDescriptable.draw4Value(grphcs, middle, middle, this.size);
                break;
            case 5:
                ImageDescriptable.draw5Value(grphcs, middle, middle, this.size);
                break;
            case 6:
                ImageDescriptable.draw6Value(grphcs, middle, middle, this.size);
                break;
        }
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

