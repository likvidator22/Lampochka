package kg.flashlight.widget;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends Activity 
{
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_about);
        
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setClickable(true);
        String text = "Аффтора ищем <a href='http://vk.com/timon270395'>тута!</a>";
        textView.setText(Html.fromHtml(text));
    }
}
