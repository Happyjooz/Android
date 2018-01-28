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

public class Tab1Episode extends Fragment{

    ListView mListView;
    //String[] episodes = {"Ep 1 : La Menace Fantôme", "Ep 2 : L'Attaque des Clones", "Ep 3 : La Revanche des Sith", "Ep 4 : Un Nouvel Espoir", "Ep 5 : L'Empire Contre-Attaque", "Ep 6 : Le Retour du Jedi",};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment1_episode, container, false);
        mListView = (ListView) rootView.findViewById(R.id.listView);
        afficherListeEpisode();
        return rootView;
    }

    private List<Episode> genererEpisodes(){
        List<Episode> episodes = new ArrayList<Episode>();
        episodes.add(new Episode(R.mipmap.ic_ep1, "Episode 1", "La Menace Fantôme"));
        episodes.add(new Episode(R.mipmap.ic_ep2, "Episode 2", "L'Attaque des Clones"));
        episodes.add(new Episode(R.mipmap.ic_ep3, "Episode 3", "La Revanche des Sith"));
        episodes.add(new Episode(R.mipmap.ic_ep4, "Episode 4", "Un Nouvel Espoir"));
        episodes.add(new Episode(R.mipmap.ic_ep5, "Episode 5", "L'Empire Contre-Attaque"));
        episodes.add(new Episode(R.mipmap.ic_ep6, "Episode 6", "Le Retour du Jedi"));
        return episodes;
    }

    private void afficherListeEpisode(){
        List<Episode> episodes = genererEpisodes();

        EpisodeAdapter listViewAdapter = new EpisodeAdapter( getActivity(), episodes);
        mListView.setAdapter(listViewAdapter);
    }

    //private void afficherListeEpisode(){

    // ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
    //           getActivity(),
    //          android.R.layout.simple_list_item_1,
    //          episodes
    //   );
    //  mListView.setAdapter(listViewAdapter);
    // }
}
