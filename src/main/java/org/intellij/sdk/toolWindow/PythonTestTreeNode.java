package org.intellij.sdk.toolWindow;

import com.intellij.ui.CheckedTreeNode;

public class PythonTestTreeNode extends CheckedTreeNode {
    String name;
    PythonTestTreeNode(String name) {
        this.name = name;
    }
}
