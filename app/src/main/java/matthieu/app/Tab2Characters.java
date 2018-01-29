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
        characters.add(new Character(R.mipmap.ic_anakin, "Anakin Skywalker", "Interprété par Hayden Christensen", "Anakin Skywalker était un Chevalier Jedi qui servit la République Galactique dans ses dernières années. Il devint par la suite le Seigneur Sith Dark Vador, second commandant de l'Empire Galactique derrière son maître, Dark Sidious.\n" +
                "Fils de Shmi Skywalker, il fut l'époux secret de la sénatrice Padmé Amidala de Naboo. Il eut deux enfants : Luke Skywalker et Leia Organa.\n"));
        characters.add(new Character(R.mipmap.ic_obiwan, "Obi-Wan Kenobi", "Interprété par Ewan McGregor","Obi-Wan Kenobi, plus tard connu sous le nom de Ben Kenobi, était un humain sensible à la Force qui fut chevalier Jedi du temps de la République Galactique. Il forma le Jedi Anakin Skywalker jusqu'à ce que celui-ci bascule du Côté Obscur et ne mette fin à l'Ordre Jedi. Du temps de l'Empire Galactique il s'exila sur Tatooine pour veiller sur le fils de Skywalker avant de devenir son mentor peu avant la bataille de Yavin. Kenobi initia Luke à la Force mais ne put poursuivre sa formation car peu de temps après il se fit tuer par Dark Vador à bord de l'Étoile de la Mort. Après sa mort, Obi-Wan demeura vivant à travers la Force et apparut à Luke sous forme de spectre pour le guider dans sa quête. "));
        characters.add(new Character(R.mipmap.ic_quigon, "Qui-Gon Jinn", "Interprété par Liam Neeson","Qui-Gon Jinn était un Maître Jedi né sur Coruscant durant le déclin de la République Galactique. Entraîné par le Comte Dooku, Qui-Gon était considéré comme un anticonformiste au sein de l'Ordre Jedi ne suivant pas toujours les adages du Code. Le Maître Jedi aurait pu siéger au Conseil Jedi s'il ne s'était pas régulièrement opposé à ses membres."));
        characters.add(new Character(R.mipmap.ic_maul, "Dark Maul", "Interprété par Ray Park","Dark Sidious eut à recours à son apprenti pour retrouver la Reine Amidala. Trouvant dans cette mission l'occasion tant attendue de se révéler aux Jedi, Dark Maul se lança sur les traces du vaisseau royal. Sa quête le mena alors sur le monde désertique de Tatooine. Il finit par attaquer l'un des protecteurs d'Amidala, le Maître Jedi Qui-Gon Jinn, avant qu'ils ne repartent pour Coruscant. Toute la rage et la haine de Maul ne purent pourtant pas venir à bout de Jinn, le Jedi préférant fuir plutôt que de continuer le combat."));
        characters.add(new Character(R.mipmap.ic_doku, "Dooku/Dark Tyranus ", "Interprété par Christopher Lee","Dooku était à bien des égards un Jedi atypique. Il considérait en effet que l'Ordre était décadent et n'était plus capable, par son pacifisme et sa mollesse, de défendre efficacement la galaxie. Ayant de plus en plus l'ambition de quitter l'Ordre pour mener son combat de son côté, il fut lentement attiré par le côté obscur, ressentant de l'arrogance et de la haine à l'égard des Jedi. C'est lors de ses nombreux voyages qu'ils rencontra un mystérieux personnage qui le prit sous son aile. Ce n'était d'autre que le Seigneur Sith Dark Sidious qui, considérant que Dooku pourrait lui être utile, décida de l'inclure dans son plan pour prendre le contrôle de la galaxie sans lui en révéler toutes les machinations."));
        characters.add(new Character(R.mipmap.ic_sidious, "Palpatine/Dark Sidious", "Interprété par Ian McDiarmid","Sheev Palpatine, aussi connu sous le nom de l'Empereur Palpatine ou Dark Sidious, était un Seigneur Noir des Sith originaire de Naboo, qui occupa le poste de Chancelier Suprême de la République Galactique avant de devenir Empereur de l'Empire Galactique après un coup d'état à la fin de la Guerre des Clones. "));
        characters.add(new Character(R.mipmap.ic_yoda, "Maître Yoda", "Voix par Frank Oz","Quand des jeunes padawans commencent les premières étapes de la formation Jedi, ils le font avec les conseils avertis de Yoda. Beaucoup des plus grands Jedi de la République galactique se sont exercés avec Yoda dans leur jeunesse. Yoda est aussi un des plus éminents membres du Conseil Jedi."));
        return characters;
    }

    private void afficherListeCharacter(){
        List<Character> characters = genererCharacters();

        CharacterAdapter listViewAdapter = new CharacterAdapter( getActivity(), characters);
        mListView.setAdapter(listViewAdapter);
    }
}
