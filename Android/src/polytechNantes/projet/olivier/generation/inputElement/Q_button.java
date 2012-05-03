package polytechNantes.projet.olivier.generation.inputElement;

import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.generation.InputElement;
import android.widget.LinearLayout;


public class Q_button extends android.widget.Button implements InputElement
{
	private String qId;
	
	
	public Q_button(ElementBuilder b)
	{
		// Creation de l'objet Button
		super(b.getActivity());
		this.setId(b.getIdWidget());
		this.setText(b.getParam().get(4));
		// En ajoutant un ID personnalisé
		this.qId = "b1";
		
		((LinearLayout) b.getGlobal().findViewById( b.getIdParent() )).addView(this);
	}


	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}
