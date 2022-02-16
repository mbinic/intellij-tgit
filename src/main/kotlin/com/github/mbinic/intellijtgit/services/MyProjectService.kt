package com.github.mbinic.intellijtgit.services

import com.intellij.openapi.project.Project
import com.github.mbinic.intellijtgit.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
