package com.github.mbinic.intellijtgit.actions

import com.github.mbinic.intellijtgit.Helpers.Context
import com.github.mbinic.intellijtgit.TGit
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction

class BlameAction : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        var line = (Context.getCurrentLine(e) ?: 0) + 1
        TGit.command(e, "blame", true, filePathRequired = true, additionalParams = "/line:${line}")
    }
}
