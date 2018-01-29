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
        episodes.add(new Episode(R.mipmap.ic_ep1, "Episode 1", "La Menace Fantôme", "La République Galactique est en pleine ébullition. La taxation des routes commerciales reliant les systèmes éloignés provoque la discorde.   \n" +
                "Pour régler la question, la cupide Fédération du Commerce et ses redoutables vaisseaux de guerre imposent un blocus à la petite planète Naboo.   \n" +
                "Face à ce dangereux engrenage, alors que le Congrès de la République s'enlise dans des débats sans fin, le Chancelier Suprême charge en secret deux Chevaliers Jedi, gardiens de la paix et de la justice dans la galaxie, de résoudre le conflit…"));

        episodes.add(new Episode(R.mipmap.ic_ep2, "Episode 2", "L'Attaque des Clones", "L'agitation règne au Sénat Galactique. Des milliers de systèmes solaires ont annoncé leur intention de quitter la République.\n" +
                "Confrontés à ce mouvement séparatiste mené par le mystérieux Comte Dooku, les chevaliers Jedi, en nombre limité, ont du mal à maintenir la paix et l’ordre dans la galaxie.\n" +
                "La sénatrice Amidala, ancienne reine de Naboo, revient au Sénat Galactique pour participer à un vote crucial sur la création d'une Armée de la République pour aider les Jedi débordés…\n"));

        episodes.add(new Episode(R.mipmap.ic_ep3, "Episode 3", "La Revanche des Sith","C'est la guerre ! La République croule sous les attaques de l'impitoyable Sith, le Comte Dooku. Il y a des héros dans les deux camps. Le Mal est partout.\n" +
                "Avec une audace stupéfiante, le Général Grievous, diabolique chef droïde, est entré dans la capitale pour enlever le Chancelier Suprême Palpatine, chef suprême du Sénat Galactique.\n" +
                "Alors que l'Armée Droïde Séparatiste tente de quitter la capitale assiégée avec son précieux otage, deux Chevaliers Jedi mènent une mission désespérée pour secourir le chancelier captif…\n"));

        episodes.add(new Episode(R.mipmap.ic_ep4, "Episode 4", "Un Nouvel Espoir", "C'est une époque de guerre civile. À bord de vaisseaux spatiaux opérant à partir d'une base cachée, les rebelles ont emporté leur première victoire sur le maléfique Empire Galactique. \n" +
                "Au cours de la bataille, des espions rebelles ont réussi à dérober les plans secrets de l'arme absolue de l'Empire : l'Étoile de la Mort, une station spatiale blindée dotée d'un équipement assez puissant pour annihiler une planète tout entière.\n" +
                "Poursuivie par des sbires sinistres de l'Empire, la princesse Leia file vers sa base dans son vaisseau cosmique, porteuse des plans volés à l'ennemi qui pourront sauver son peuple et restaurer la liberté dans la galaxie…\n"));

        episodes.add(new Episode(R.mipmap.ic_ep5, "Episode 5", "L'Empire Contre-Attaque", "Le temps du péril a commencé pour la rébellion. Malgré la destruction de l'Étoile de la Mort, l'armée Impériale a chassé les rebelles de leur base cachée et les poursuit à travers la galaxie. \n" +
                "Après avoir échappé à la redoutable escadrille cosmique de l'Empire, un groupe de résistants mené par Luke Skywalker a établi une nouvelle base secrète sur Hoth, la lointaine planète des glaces. \n" +
                "Dark Vador, le maléfique, hanté par l'idée de retrouver le jeune Luke, lance des milliers de sondes téléguidées aux confins de l'espace…\n"));

        episodes.add(new Episode(R.mipmap.ic_ep6, "Episode 6", "Le Retour du Jedi", "Luke Skywalker est retourné parmi les siens sur la planète Tatooine pour tenter d'arracher son ami Han Solo aux griffes de l'ignoble Jabba Desilijic Tiure. \n" +
                "Luke ne peut pas savoir que l'Empire Galactique a commencé à construire en secret une nouvelle station spatiale blindée bien plus puissante et terrifiante que l'Étoile de la Mort.\n" +
                "Quand cette arme absolue sera achevée, ce sera la fin du petit groupe de résistants qui luttent pour ramener la liberté dans la galaxie…\n"));
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
