package polytechNantes.projet.olivier.generation.inputElement;

import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.generation.InputElement;
import android.content.Context;


public class Q_checkBox extends android.widget.CheckBox implements InputElement
{

	public Q_checkBox(ElementBuilder b, int position)
	{
		super(b.getActivity());
		this.setText(b.getParam().get(5 + position));
		this.setChecked(false);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

}
