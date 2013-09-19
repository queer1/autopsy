/*
 * Autopsy Forensic Browser
 *
 * Copyright 2012 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.casemodule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;

/**
 * visual component to display progress bar and status updates while adding an
 * image in the wizard
 */
public class AddImageWizardAddingProgressVisual extends javax.swing.JPanel {

    /**
     * Returns the name of the this panel. This name will be shown on the left
     * panel of the "Add Image" wizard panel.
     *
     * @return name the name of this panel
     */
    @Override
    public String getName() {
        return "Add Data Source";
    }

    /**
     * hide the progress components and show the "done" components
     */
    void setStateFinished() {
        loadingPanel.setVisible(false);
        donePanel.setVisible(true);
        //force repaint just in case
        validate();
        repaint();
    }

    /**
     * Creates new form AddImageLoadingPanel
     */
    public AddImageWizardAddingProgressVisual() {
        initComponents();
        customizeComponents();
    }

    private void customizeComponents() {
        //done and log button are both hidden to start
        donePanel.setVisible(false);
        viewLogButton.setVisible(false);
        //match visual background of panel
        this.TextArea_CurrentDirectory.setBackground(this.getBackground());

    }

    /**
     * reset some of the visual components.
     *
     * is this ever invoked?
     */
    void resetInfoPanel() {
        viewLogButton.setVisible(false);
        progressLabel.setText("");
    }

    public JProgressBar getProgressBar() {
        return this.progressBar;
    }

    /**
     * update the progress bar and label text and color.
     *
     * @param text  the text to be shown
     * @param value the current value of the progress bar
     * @param color the color of the progress bar text
     */
    public void setProgressBarTextAndColor(String text, int value, Color color) {
        progressLabel.setText(text);
        progressLabel.setForeground(color);
        progressBar.setValue(value);
    }

    /**
     * Updates the currently processing directory
     *
     * @param dir the text to update with
     */
    public void setCurrentDirText(String dir) {
        this.TextArea_CurrentDirectory.setText(dir);
    }

    /**
     * reconfigure the components to indicate error(s) and show "view log
     * button"
     *
     *
     * @param errors   a string containing a description of the error(s)
     * @param critical true to indicate the error(s) are critical
     */
    void showErrors(final String errors, boolean critical) {
        progressBar.setValue(100); //always invoked when process completed
        if (critical) {
            statusLabel.setText("*Failed to add image (critical errors encountered). Click below to view the log.");
        } else {
            statusLabel.setText("*Data Source added (non-critical errors encountered). Click below to view the log.");
        }

        viewLogButton.setVisible(true);

        viewLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //show error dialog
                AddImageErrorsDialog dialog = new AddImageErrorsDialog(null, true);
                dialog.setErrors(errors);
                dialog.setVisible(true);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        donePanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        crDbLabel = new javax.swing.JLabel();
        viewLogButton = new javax.swing.JButton();
        loadingPanel = new javax.swing.JPanel();
        addingDataSourceLabel = new javax.swing.JLabel();
        progressLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        infoPanel = new javax.swing.JPanel();
        TextArea_CurrentDirectory = new javax.swing.JTextArea();

        org.openide.awt.Mnemonics.setLocalizedText(statusLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.statusLabel.text")); // NOI18N

        crDbLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(crDbLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.crDbLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(viewLogButton, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.viewLogButton.text")); // NOI18N

        javax.swing.GroupLayout donePanelLayout = new javax.swing.GroupLayout(donePanel);
        donePanel.setLayout(donePanelLayout);
        donePanelLayout.setHorizontalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(donePanelLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(viewLogButton))
                    .addComponent(crDbLabel)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        donePanelLayout.setVerticalGroup(
            donePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(donePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crDbLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewLogButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addingDataSourceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(addingDataSourceLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.addingDataSourceLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(progressLabel, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.progressLabel.text")); // NOI18N
        progressLabel.setPreferredSize(null);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        TextArea_CurrentDirectory.setEditable(false);
        TextArea_CurrentDirectory.setBackground(new java.awt.Color(240, 240, 240));
        TextArea_CurrentDirectory.setLineWrap(true);
        TextArea_CurrentDirectory.setRows(5);
        TextArea_CurrentDirectory.setWrapStyleWord(true);
        TextArea_CurrentDirectory.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), org.openide.util.NbBundle.getMessage(AddImageWizardAddingProgressVisual.class, "AddImageWizardAddingProgressVisual.TextArea_CurrentDirectory.border.title"))); // NOI18N
        TextArea_CurrentDirectory.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TextArea_CurrentDirectory.setFocusable(false);

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addingDataSourceLabel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loadingPanelLayout.createSequentialGroup()
                        .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loadingPanelLayout.createSequentialGroup()
                                .addComponent(progressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextArea_CurrentDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addingDataSourceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextArea_CurrentDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingPanelLayout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(loadingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(donePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextArea_CurrentDirectory;
    private javax.swing.JLabel addingDataSourceLabel;
    private javax.swing.JLabel crDbLabel;
    private javax.swing.JPanel donePanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton viewLogButton;
    // End of variables declaration//GEN-END:variables
}