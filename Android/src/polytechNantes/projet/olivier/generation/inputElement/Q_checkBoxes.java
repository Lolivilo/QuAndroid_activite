package polytechNantes.projet.olivier.generation.inputElement;

import android.widget.LinearLayout;
import polytechNantes.projet.olivier.generation.ElementBuilder;

public class Q_checkBoxes
{
	private Q_checkBox[] checkBoxGroup;
	private int taille;
	private int qId;
	
	
	public Q_checkBoxes(ElementBuilder b)
	{
		this.taille = Integer.parseInt(b.getParam().get(4));
		this.checkBoxGroup = new Q_checkBox[this.taille];
		
		this.qId = b.getIdWidget();
		
		
		for(int i = 0 ; i < this.taille ; i++)
		{
			Q_checkBox cb = new Q_checkBox(b, i);
			this.checkBoxGroup[i] = cb;
			((LinearLayout) b.getGlobal().findViewById( b.getIdParent() )).addView(cb);	// Puis on bind
		}
		
		
	}
}
