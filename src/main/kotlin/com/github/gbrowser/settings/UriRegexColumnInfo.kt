package com.github.gbrowser.settings

import com.intellij.util.ui.ColumnInfo
import org.jetbrains.annotations.NotNull
import java.awt.Component
import javax.swing.BorderFactory
import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer
import javax.swing.table.TableCellRenderer


class UriRegexColumnInfo : ColumnInfo<GBrowserHeadersOverwrite, String>("URI Regex") {

    override fun valueOf(item: GBrowserHeadersOverwrite): String {
        return item.uriRegex
    }

    override fun getColumnClass(): Class<*> {
        return String::class.java
    }

    override fun isCellEditable(item: GBrowserHeadersOverwrite?): Boolean {
        return true
    }

    override fun setValue(item: GBrowserHeadersOverwrite, value: String) {
        item.uriRegex = value
    }

    override fun getRenderer(item: GBrowserHeadersOverwrite): TableCellRenderer {
        return object : DefaultTableCellRenderer() {

            override fun getTableCellRendererComponent(@NotNull table: JTable,
                                                       value: Any,
                                                       isSelected: Boolean,
                                                       hasFocus: Boolean,
                                                       row: Int,
                                                       column: Int): Component {
                val renderer: Component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                    row, column)
                border = BorderFactory.createEmptyBorder(2, 2, 2, 2)
                text = item.uriRegex
                return renderer
            }
        }

    }
}
