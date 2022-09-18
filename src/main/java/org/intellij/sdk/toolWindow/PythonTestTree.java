package org.intellij.sdk.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.CheckboxTree;
import com.intellij.ui.CheckedTreeNode;
import com.intellij.util.ui.tree.TreeUtil;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.util.Set;

public class PythonTestTree extends CheckboxTree {

    private static final Key<Set<VirtualFile>> PYTHON_TEST_PROJECT_DIRS = Key.create("images.files.or.directories");
    PythonTestTree(CheckboxTreeCellRenderer renderer, CheckedTreeNode root) {
        super(renderer, root);
        this.setRootVisible(false);
        this.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        TreeUtil.expandAll(this);
    }
    public static PythonTestTreeNode createTree(Project project) {
        PythonTestTreeNode root = new PythonTestTreeNode("");
        Set<VirtualFile> files = project.getUserData(PYTHON_TEST_PROJECT_DIRS);
        if (files == null) {
            PythonTestTreeNode node = new PythonTestTreeNode("empty!!!");
            root.add(node);
        } else {
            for (VirtualFile file : files) {
                PythonTestTreeNode node = new PythonTestTreeNode(file.getName());
                root.add(node);
            }
        }
        return root;
    }
}
