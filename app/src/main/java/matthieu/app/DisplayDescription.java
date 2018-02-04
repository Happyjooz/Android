package matthieu.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class DisplayDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_description);
        // Get the Intent that started this activity and extract the string
        Animation yolo = AnimationUtils.loadAnimation(this, R.anim.animationfile);

        Intent intent = getIntent();
        String message = intent.getStringExtra("Synopsis");

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(message);
        textView.startAnimation(yolo);

    }
}
