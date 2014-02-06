package kg.flashlight.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * Author: Sadovykh Timofey
 * Date: 06.02.014
 */

public class FlashlightWidget extends AppWidgetProvider {
	
	private boolean initializing = true;
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) 
	{
	    ComponentName thisWidget = new ComponentName(context,
	        FlashlightWidget.class);
	    int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
	
	    // интент вызова службы
	    Intent intent = new Intent(context.getApplicationContext(),
	        FlashlightWidgetService.class);
	    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds);
	    intent.putExtra("initializing", initializing);
	    //  обновляем через службу
	    context.startService(intent);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		initializing = intent.getBooleanExtra("initializing", true);
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
	}
}
