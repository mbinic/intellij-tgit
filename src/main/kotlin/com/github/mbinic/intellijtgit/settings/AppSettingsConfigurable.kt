package com.github.mbinic.intellijtgit.settings

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import javax.swing.JComponent

class AppSettingsConfigurable : Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null

    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String? {
        return "TortoiseGit Actions"
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return mySettingsComponent!!.preferredFocusedComponent
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        return mySettingsComponent!!.getTortoiseGitProcPath() != AppSettingsState.instance.tortoiseGitProcPath
    }

    override fun apply() {
        AppSettingsState.instance.tortoiseGitProcPath = mySettingsComponent!!.getTortoiseGitProcPath()
    }

    override fun reset() {
        mySettingsComponent!!.setTortoiseGitProcPath(AppSettingsState.instance.tortoiseGitProcPath)
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}