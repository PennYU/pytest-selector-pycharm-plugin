package org.intellij.sdk.toolWindow;

import com.intellij.ui.CheckboxTree;

import javax.swing.*;

public class PythonTestTreeCellRenderer extends CheckboxTree.CheckboxTreeCellRenderer {
    @Override
    public void customizeRenderer(JTree tree,
                                  Object value,
                                  boolean selected,
                                  boolean expanded,
                                  boolean leaf,
                                  int row,
                                  boolean hasFocus) {
        if (value instanceof PythonTestTreeNode) {
            PythonTestTreeNode node = (PythonTestTreeNode)value;
            getCheckbox().setVisible(true);
            getTextRenderer().append(node.name);
        } else {
            getTextRenderer().append("hello");
        }
    }
}
