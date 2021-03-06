package com.github.benchmarkr.settings.input;

import com.github.benchmarkr.settings.BenchmarkrSettingsState;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.panel.ComponentPanelBuilder;
import com.intellij.util.ui.UI;

public class BenchmarkrExecutableInput {
  private static final String TITLE = "Benchmarkr Binary";
  private static final String DESCRIPTION = "";
  private static final String LABEL = "Benchmarkr executable:";

  private final TextFieldWithBrowseButton benchmarkrExecutable;

  public BenchmarkrExecutableInput(BenchmarkrSettingsState state) {
    benchmarkrExecutable = new TextFieldWithBrowseButton();

    benchmarkrExecutable.addBrowseFolderListener(TITLE, DESCRIPTION, null,
        FileChooserDescriptorFactory.createSingleFileOrExecutableAppDescriptor());

    benchmarkrExecutable.setText(state.getBenchmarkrExecutablePath());
  }

  public ComponentPanelBuilder getComponentBuilder() {
    return UI.PanelFactory
        .panel(benchmarkrExecutable)
        .withLabel(LABEL);
  }

  public String getText() {
    return benchmarkrExecutable.getText();
  }
}
