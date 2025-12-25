package com.artistic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.artistic.widget.R

class ArtisticWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    companion object {
        fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
            // "appwidget_text" is now defined in widget_layout.xml, so this will pass
            val views = RemoteViews(context.packageName, R.layout.widget_layout)
            views.setTextViewText(R.id.appwidget_text, MainOverride.ledText)
            
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}
