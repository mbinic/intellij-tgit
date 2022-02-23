# TortoiseGit actions for IntelliJ-based IDEs

![Build](https://github.com/mbinic/intellij-tgit/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/18671.svg)](https://plugins.jetbrains.com/plugin/18671)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/18671.svg)](https://plugins.jetbrains.com/plugin/18671)

## Introduction

<!-- Plugin description -->

**Launch common TortoiseGit dialogs using intuitive shortcuts**

### Repo-scoped shortcuts:
* **G**it **C**ommit - `Ctrl+G, Ctrl+C`</li>
* **G**it **F**etch - `Ctrl+G, Ctrl+F`</li>
* **G**it **L**og - `Ctrl+G, Ctrl+L`</li>
* **G**it **M**erge - `Ctrl+G, Ctrl+M`</li>
* **G**it **P**ull - `Ctrl+G, Ctrl+P`</li>
* **G**it P**u**sh - `Ctrl+G, Ctrl+U`</li>
* **G**it **R**ebase - `Ctrl+G, Ctrl+R`</li>
* **G**it Re**v**ert - `Ctrl+G, Ctrl+V`</li>
* **G**it Stash-L**i**st - `Ctrl+G, Ctrl+I`</li>
* **G**it Stash-P**o**p - `Ctrl+G, Ctrl+O`</li>
* **G**it Stash-S**a**ve - `Ctrl+G, Ctrl+A`</li>
* **G**it **S**witch - `Ctrl+G, Ctrl+S`</li>
* **G**it S**y**nc - `Ctrl+S, Ctrl+Y`</li>
* **G**it Clea**n**up - `Ctrl+G, Ctrl+N`</li>
* **G**it Repository **D**iff - `Ctrl+G, Ctrl+D`</li>

### Current file-scoped shortcuts:
* **G**it R**e**solve - `Ctrl+G, Ctrl+E`</li>
* **G**it File **L**og - `Ctrl+Shift+Alt+G, Ctrl+Shift+Alt+L`</li>
* **G**it File **B**lame - `Ctrl+Shift+Alt+G, Ctrl+Shift+Alt+B`</li>
* **G**it File **D**iff - `Ctrl+Shift+Alt+G, Ctrl+Shift+Alt+D`</li>

### Shortcut Conflicts
Since the default shortcuts will make `Ctrl+G` (Go To Line) inaccessible, you can change them, or just change the one for "Go To Line" to be e.g. `Ctrl+G, Ctrl+G`.

### More Actions
Bisect commands are also available, but with no preset shortcuts. You can reach them from the TortoiseGit menu, or search for `TGit` in the `Shift Shift` palette.

### Optional Configuration
If you've installed TortoiseGit in a custom location, you can specify the path to `TortoiseGitProc.exe` under `Settings/Preferences` > `Tools` > `TortoiseGit Actions`.


<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  `Settings/Preferences` > `Plugins` > `Marketplace` > `Search for "intellij-tgit"` >
  `Install Plugin`
  
- Manually:

  Download the [latest release](https://github.com/mbinic/intellij-tgit/releases/latest) and install it manually using
  `Settings/Preferences` > `Plugins` > `⚙️` > `Install plugin from disk...`

---

Plugin based on the [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template).

**Here's to productivity!**
