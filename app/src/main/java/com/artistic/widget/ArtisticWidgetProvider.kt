package com.artistic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class ArtisticWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        for (id in ids) {
            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            // Pulling the text directly from the Drag & Drop Override [cite: 2025-12-13]
            views.setTextViewText(R.id.widget_text, MainControlRegistry.dragItemText)
            manager.updateAppWidget(id, views)
        }
    }
}
