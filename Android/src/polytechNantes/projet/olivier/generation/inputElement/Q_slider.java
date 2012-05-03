package polytechNantes.projet.olivier.generation.inputElement;

import android.content.Context;
import android.widget.LinearLayout;
import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.generation.InputElement;


public class Q_slider extends android.widget.SeekBar implements InputElement
{
	private String id;
	
	
	public Q_slider(ElementBuilder b)
	{
		super(b.getActivity());
		this.setMax(100);
		
		((LinearLayout) b.getGlobal().findViewById( b.getIdParent() )).addView(this);	// Puis on bind
	}

	
	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

}
