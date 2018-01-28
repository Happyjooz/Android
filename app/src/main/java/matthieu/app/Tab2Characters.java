package matthieu.app;

/**
 * Created by Matthieu on 25/01/2018.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Tab2Characters extends Fragment {

    ListView mListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment2_characters, container, false);
        mListView = (ListView) rootView.findViewById(R.id.listView1);
        afficherListeCharacter();
        return rootView;
    }

    private List<Character> genererCharacters(){
        List<Character> characters = new ArrayList<Character>();
        characters.add(new Character(R.mipmap.ic_anakin, "Anakin Skywalker", "Interprété par Jake Lloyd/Hayden Christensen"));
        characters.add(new Character(R.mipmap.ic_obiwan, "Obi-Wan Kenobi", "Interprété par Ewan McGregor/Alec Guiness"));
        characters.add(new Character(R.mipmap.ic_quigon, "Qui-Gon Jinn", "Interprété par Liam Neeson"));
        characters.add(new Character(R.mipmap.ic_maul, "Dark Maul", "Interprété par Ray Park"));
        characters.add(new Character(R.mipmap.ic_doku, "Dooku/Dark Tyranus ", "Interprété par Christopher Lee"));
        characters.add(new Character(R.mipmap.ic_sidious, "Palpatine/Dark Sidious", "Interprété par Ian McDiarmid"));
        characters.add(new Character(R.mipmap.ic_yoda, "Maître Yoda", "Voix par Frank Oz"));
        return characters;
    }

    private void afficherListeCharacter(){
        List<Character> characters = genererCharacters();

        CharacterAdapter listViewAdapter = new CharacterAdapter( getActivity(), characters);
        mListView.setAdapter(listViewAdapter);
    }
}
