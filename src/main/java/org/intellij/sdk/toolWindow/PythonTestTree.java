package org.intellij.sdk.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.ui.CheckboxTree;
import com.intellij.ui.CheckedTreeNode;

public class PythonTestTree extends CheckboxTree {
    private Project project;
    PythonTestTree(Project project, CheckboxTreeCellRenderer renderer, CheckedTreeNode root) {
        super(renderer, root);
        this.project = project;
    }
}
