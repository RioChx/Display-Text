package com.artistic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class ArtisticWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, manager: AppWidgetManager, ids: IntArray) {
        for (id in ids) {
            // R is now correctly found because the package name matches
            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            manager.updateAppWidget(id, views)
        }
    }
}
