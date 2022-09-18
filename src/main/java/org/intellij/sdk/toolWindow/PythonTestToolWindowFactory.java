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
    PythonTestTreeCellRenderer renderer = new PythonTestTreeCellRenderer();
    PythonTestTreeNode root = PythonTestTree.createTree(project);
    PythonTestTree tree = new PythonTestTree(renderer, root);
    JPanel p = new JPanel();
    p.add(tree);
    Content content = contentFactory.createContent(p, "", false);
    toolWindow.getContentManager().addContent(content);
  }
}
