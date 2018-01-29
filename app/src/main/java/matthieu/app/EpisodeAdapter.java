package matthieu.app;

/**
 * Created by Matthieu on 25/01/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EpisodeAdapter extends ArrayAdapter<Episode>{

    public EpisodeAdapter(Context context, List<Episode> episodes) {
    super(context, 0, episodes);
}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_episode,parent, false);
        }

        EpisodeViewHolder viewHolder = (EpisodeViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EpisodeViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }


        //getItem(position) va récupérer l'item [position] de la List<Episode> episodes
        Episode episode = getItem(position);
        viewHolder.pseudo.setText(episode.getPseudo());
        viewHolder.text.setText(episode.getText());
        viewHolder.avatar.setImageResource(episode.getImage());

        View.OnClickListener myhandler1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), DisplayDescription.class);
                int position = (Integer) v.getTag();
                String descript = getItem(position).getDesc();
                myIntent.putExtra("Synopsis", descript);
                v.getContext().startActivity(myIntent);
            }
        };
        Button btn = (Button)convertView.findViewById(R.id.button4);
        btn.setTag(position);
        btn.setOnClickListener(myhandler1);


        return convertView;
    }

    private class EpisodeViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;

    }
}