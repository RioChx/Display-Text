package com.artistic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class ArtisticWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            // If you have a layout file named widget_layout.xml, 
            // the 'R' will now be correctly found in com.artistic.widget
            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
