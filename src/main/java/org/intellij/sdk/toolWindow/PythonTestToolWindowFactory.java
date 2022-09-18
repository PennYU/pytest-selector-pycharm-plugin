// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.toolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.CheckboxTree;
import com.intellij.ui.CheckboxTreeBase;
import com.intellij.ui.CheckedTreeNode;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ui.tree.TreeUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class PythonTestToolWindowFactory implements ToolWindowFactory {

  /**
   * Create the tool window content.
   *
   * @param project    current project
   * @param toolWindow current tool window
   */
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    CheckboxTree.CheckboxTreeCellRenderer cellRenderer = new CheckboxTree.CheckboxTreeCellRenderer(true, false) {
      @Override
      public void customizeRenderer(JTree tree,
                                    Object value,
                                    boolean selected,
                                    boolean expanded,
                                    boolean leaf,
                                    int row,
                                    boolean hasFocus) {
        if (value instanceof DefaultMutableTreeNode) {
          getCheckbox().setVisible(true);
          getTextRenderer().append("hello");
        }
      }
    };

    CheckedTreeNode root = new CheckedTreeNode(null);
    DefaultMutableTreeNode variantNode = new DefaultMutableTreeNode("hello world");
    variantNode.add(new DefaultMutableTreeNode("dependent1"));
    root.add(variantNode);
    Tree tree = new CheckboxTree(cellRenderer, root, new CheckboxTreeBase.CheckPolicy(false, true, true, false));
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.setRootVisible(false);
    TreeUtil.expandAll(tree);
    JPanel p = new JPanel();
    p.add(tree);
    Content content = contentFactory.createContent(p, "", false);
    toolWindow.getContentManager().addContent(content);

  }

}
