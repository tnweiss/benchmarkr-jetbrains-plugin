package com.github.benchmarkr.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;

import org.jetbrains.annotations.NotNull;

/**
 * Initialize remote elk indices and dashboards
 */
public class BenchmarkrInitElkAction extends AnAction {
  private static final Logger log = Logger.getInstance(BenchmarkrActionsGroup.class);
  public static final String DESCRIPTION = "Initialize ELK indices and dashboards";
  public static final String TEXT = DESCRIPTION;

  @Override
  public void update(@NotNull AnActionEvent event) {
    Presentation presentation = event.getPresentation();
    presentation.setDescription(DESCRIPTION);
    presentation.setText(TEXT);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    log.info("Initializing remote ELK indices and dashboards");

    // create the background task
    Task.Backgroundable backgroundable =
        new BenchmarkrInitElkBackgroundable(e.getProject());

    // run the task in the background
    ApplicationManager.getApplication().invokeLater(() ->
        ProgressManager.getInstance().run(backgroundable));
  }
}
