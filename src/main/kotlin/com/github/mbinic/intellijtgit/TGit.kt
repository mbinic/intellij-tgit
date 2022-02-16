package com.github.mbinic.intellijtgit

import com.github.mbinic.intellijtgit.Helpers.Context
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class TGit {
    companion object Launcher {

        fun command(e: AnActionEvent, command: String, withFilePath: Boolean = false, filePathRequired: Boolean = false, additionalParams: String? = null) {
            var path = Context.getWorkingPath(e, withFilePath, filePathRequired)
            if (path == null) {
                var openObject = "file"
                if (!filePathRequired)
                    openObject += " or folder"
                Messages.showErrorDialog("The '${command}' command requires an existing $openObject to be open.", "No $openObject open")
                return
            }

            var launcherPath = Context.getTortoiseGitPath()
            var cmd = "\"${launcherPath}\" /command:${command} /path:\"${path}\""
            if (additionalParams != null) {
                cmd += " $additionalParams"
            }

            try {
                Runtime.getRuntime().exec(cmd)
            } catch (ex: Exception) {
                ex.printStackTrace()
                Messages.showErrorDialog("${cmd}\n\n${ex.message}", "Error executing command line")
            }
        }
    }
}