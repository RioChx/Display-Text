package com.artistic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class ArtisticWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        for (id in ids) {
            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            // Displays the text defined in your Main Override [cite: 2025-12-13]
            views.setTextViewText(R.id.widget_text, MainControlRegistry.ledText)
            manager.updateAppWidget(id, views)
        }
    }
}
