package com.github.gbrowser.settings

import com.intellij.util.ui.ColumnInfo
import org.jetbrains.annotations.NotNull
import java.awt.Component
import javax.swing.BorderFactory
import javax.swing.JTable
import javax.swing.table.DefaultTableCellRenderer
import javax.swing.table.TableCellRenderer


class WebUrlColumnInfo : ColumnInfo<GBrowserBookmarks, String>("") {

    override fun valueOf(item: GBrowserBookmarks): String {
        return item.webUrl
    }

    override fun getColumnClass(): Class<*> {
        return String::class.java
    }

    override fun isCellEditable(item: GBrowserBookmarks?): Boolean {
        return true
    }

    override fun setValue(item: GBrowserBookmarks, value: String) {
        item.webUrl = value
    }

    override fun getRenderer(item: GBrowserBookmarks): TableCellRenderer {
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
                text = item.webUrl
                return renderer
            }
        }

    }
}
