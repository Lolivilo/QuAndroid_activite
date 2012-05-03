package polytechNantes.projet.olivier.generation.inputElement;

import android.widget.LinearLayout;
import android.widget.TextView;
import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.generation.InputElement;

public class Q_label extends android.widget.TextView implements InputElement
{
	public Q_label(ElementBuilder b)
	{
		super(b.getActivity());
		TextView txt = new TextView(b.getActivity());				// Instanciation d'un nouveau TextView
		txt.setId(b.getIdWidget());							// On lui donne l'id récupéré dans les paramètres
		txt.setText(b.getParam().get(4));					// Et le texte récupéré dans les paramètres
		
		((LinearLayout) b.getGlobal().findViewById( b.getIdParent() )).addView(txt);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}
