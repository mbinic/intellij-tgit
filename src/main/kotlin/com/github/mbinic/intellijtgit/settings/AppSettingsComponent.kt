package com.github.mbinic.intellijtgit.settings;

import com.github.mbinic.intellijtgit.Helpers.Context
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel

class AppSettingsComponent {
    var btnDefault: JButton
    val panel: JPanel
    private val tortoiseGitProcPath = JBTextField()

    init {
        btnDefault = JButton("Use Default")
        btnDefault.addActionListener {
            setTortoiseGitProcPath(Context.defaultTortoiseGitProcPath)
        }

        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(
                JBLabel("Path to TortoiseGitProc.exe: "),
                tortoiseGitProcPath, 1, true
            )
            .addComponent(btnDefault, 1)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    val preferredFocusedComponent: JComponent
        get() = tortoiseGitProcPath

    fun getTortoiseGitProcPath(): String {
        return tortoiseGitProcPath.text
    }

    fun setTortoiseGitProcPath(newText: String) {
        tortoiseGitProcPath.text = newText
    }
}