package matthieu.app;

/**
 * Created by Matthieu on 25/01/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CharacterAdapter extends ArrayAdapter<Character>{

    public CharacterAdapter(Context context, List<Character> characters) {
        super(context, 0, characters);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_character,parent, false);
        }

        CharacterViewHolder viewHolder = (CharacterViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CharacterViewHolder();
            viewHolder.pseudo1 = (TextView) convertView.findViewById(R.id.pseudo1);
            viewHolder.text1 = (TextView) convertView.findViewById(R.id.text1);
            viewHolder.avatar1 = (ImageView) convertView.findViewById(R.id.avatar1);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Character> characters
        Character character = getItem(position);
        viewHolder.pseudo1.setText(character.getPseudo());
        viewHolder.text1.setText(character.getText());
        viewHolder.avatar1.setImageResource(character.getImage());

        return convertView;
    }

    private class CharacterViewHolder{
        public TextView pseudo1;
        public TextView text1;
        public ImageView avatar1;

    }
}