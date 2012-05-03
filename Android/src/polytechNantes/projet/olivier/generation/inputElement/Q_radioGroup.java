package polytechNantes.projet.olivier.generation.inputElement;

import android.widget.LinearLayout;
import android.widget.RadioButton;
import polytechNantes.projet.olivier.generation.ElementBuilder;


public class Q_radioGroup extends android.widget.RadioGroup
{
	public Q_radioGroup(ElementBuilder b)
	{
		super(b.getActivity());
		
		this.setId(b.getIdWidget());						// On lui donne l'id récupéré dans les paramètres
		for(int i = 0 ; i < Integer.parseInt(b.getParam().get(4)) ; i++)
		{
			RadioButton rb = new RadioButton(b.getActivity());		// On crée les RadioButton
			rb.setText(b.getParam().get(5 + i));			// Avec les libellés correspondants
			this.addView(rb);									// Et on les ajoute au RadioGroup
		}
		
		((LinearLayout) b.getGlobal().findViewById( b.getIdParent() )).addView(this);	// Puis on bind
	}
}
