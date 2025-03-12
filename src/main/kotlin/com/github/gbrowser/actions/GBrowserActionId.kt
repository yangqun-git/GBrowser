package com.github.gbrowser.actions

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.Separator
import org.jetbrains.annotations.NonNls

object GBrowserActionId {

  const val GBROWSER_ADD_TAB_ID: @NonNls String = "GBrowserAddTabAction"
  private const val GBROWSER_BACKWARD_ID: @NonNls String = "GBrowserBackwardAction"
  private const val GBROWSER_CLOSE_TAB_ID: @NonNls String = "GBrowserCloseTabAction"
  private const val GBROWSER_FORWARD_ID: @NonNls String = "GBrowserForwardAction"
  private const val GBROWSER_OPEN_IN_ID: @NonNls String = "GBrowserOpenInAction"
  private const val GBROWSER_TOGGLE_TOOLBAR_ID: @NonNls String = "GBrowserToggleToolbarAction"
  private const val GBROWSER_HOME_ID: @NonNls String = "GBrowserHomeAction"

  fun toAction(id: String): AnAction = ActionManager.getInstance().getAction(id)

  fun titleActions(): MutableList<AnAction> = mutableListOf(toAction(GBROWSER_ADD_TAB_ID), toAction(GBROWSER_TOGGLE_TOOLBAR_ID))

  fun allActions(): MutableList<AnAction> {
    val titleActions = mutableListOf<AnAction>()

    titleActions.addAll(BROWSER)
    titleActions.add(Separator.create())
    titleActions.add(Separator.create())
    titleActions.add(Separator.create())
    titleActions.add(Separator.create())
    titleActions.addAll(TABS)
    titleActions.add(Separator.create())
    titleActions.add(Separator.create())
    return titleActions
  }

  private val TABS: List<AnAction> = listOf(GBROWSER_ADD_TAB_ID, GBROWSER_CLOSE_TAB_ID).map {
    ActionManager.getInstance().getAction(it)
  }

  private val BROWSER: List<AnAction> =
    listOf(GBROWSER_HOME_ID, GBROWSER_OPEN_IN_ID).map {
      ActionManager.getInstance().getAction(it)
    }

  val LEFT: List<AnAction> = listOf(GBROWSER_BACKWARD_ID, GBROWSER_FORWARD_ID, GBROWSER_HOME_ID).map {
    ActionManager.getInstance().getAction(it)
  }

}