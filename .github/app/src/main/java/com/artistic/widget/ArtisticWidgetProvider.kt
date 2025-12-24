package com.artistic.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import android.graphics.Color
import com.artistic.widget.R

class ArtisticWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val views = RemoteViews(context.packageName, R.layout.widget_layout)
        
        // APPLY OVERRIDE CONFIGURATION
        views.setTextViewText(R.id.led_text, "ARTISTIC WIDGET PRO")
        views.setTextColor(R.id.led_text, Color.parseColor("#00ff00"))
        
        // Apply Rectangular Background
        val bgColor = "#000000"
        val opacity = 216
        views.setInt(R.id.widget_container, "setBackgroundColor", Color.argb(opacity, 
            Color.red(Color.parseColor(bgColor)),
            Color.green(Color.parseColor(bgColor)),
            Color.blue(Color.parseColor(bgColor))
        ))

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}