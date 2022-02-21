package com.github.mbinic.intellijtgit.Helpers

import com.github.mbinic.intellijtgit.settings.AppSettingsState
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import java.nio.file.Files
import java.nio.file.Paths

class Context {
    companion object Helper {
        const val defaultTortoiseGitProcPath = "C:\\Program Files\\TortoiseGit\\bin\\TortoiseGitProc.exe"

        fun getCurrentLine(e: AnActionEvent): Int? {
            var editor = e.dataContext.getData(CommonDataKeys.EDITOR)
            return editor?.caretModel?.currentCaret?.logicalPosition?.line
        }

        fun getTortoiseGitPath(): String? {
            var path = AppSettingsState.instance.tortoiseGitProcPath
            if (path == null || path.isBlank()) {
                path = defaultTortoiseGitProcPath
            }
            return path
        }

        fun getWorkingPath(e: AnActionEvent, preferFilePath: Boolean, filePathRequired: Boolean): String? {
            var path: String? = null
            if (preferFilePath) {
                path = getWorkingFile(e)
            }

            if (filePathRequired) {
                return path
            }

            return path
                ?: getRootGitFolder(getProjectFolder(e))
                ?: getRootGitFolder(getWorkingFileFolder(e))
        }

        private fun getProjectFolder(e: AnActionEvent): String? {
            if (e.project?.projectFile == null) {
                return null
            }
            return e.project?.basePath
        }

        private fun getWorkingFileFolder(e: AnActionEvent): String? {
            return getWorkingVirtualFile(e)?.parent?.path
        }

        private fun getWorkingFile(e: AnActionEvent): String? {
            return getWorkingVirtualFile(e)?.path
        }

        private fun getWorkingVirtualFile(e: AnActionEvent): VirtualFile? {
            var project: Project = e.project ?: return null
            var doc = FileEditorManager.getInstance(project).selectedTextEditor?.document ?: return null
            return FileDocumentManager.getInstance().getFile(doc)
        }

        private fun getRootGitFolder(currentFolder: String?): String? {
            if (currentFolder == null) {
                return null;
            }

            var current = Paths.get(currentFolder)
            while (Files.notExists(current.resolve(".git"))) {
                var parent = current.parent
                if (parent == null || current.equals(parent)){
                    current = null;
                    break;
                }
                current = parent;
            }
            return current?.toString()
        }
    }
}