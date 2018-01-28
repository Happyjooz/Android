package matthieu.app;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //On supprime la notification de la liste de notification
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(TabActivity.ID_NOTIFICATION);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            //onclick qui définit la fonction qu'on appelle lorsqu'on appuie sur le FAB
            public void onClick(View view) {
                goBack();
            }
        });
    }


    public void goBack(){
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }
}

