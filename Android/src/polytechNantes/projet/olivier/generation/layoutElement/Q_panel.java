package polytechNantes.projet.olivier.generation.layoutElement;

import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.generation.InputElement;


public class Q_panel extends android.widget.LinearLayout
{
	public static final int HAUTEUR = 440;
	public static final int LARGEUR = 800;
	
	
	public Q_panel(ElementBuilder b)
	{
		super(b.getActivity());
		this.setId(b.getIdWidget());
		this.setOrientation(LinearLayout.VERTICAL);
		
		if(b.getParam().size() > 4)									// S'il y a plus de 4 paramètres, c'est une demande split
		{
			if(b.getParam().get(5) == "H")							// On regarde l'orientation du split dans les paramètres
			{
				this.setOrientation(LinearLayout.HORIZONTAL);
			}
			
			// Sous panel 1
			LinearLayout l2 = new LinearLayout(b.getActivity());				// Instanciation du premier sous panel
			l2.setId( Integer.parseInt(b.getParam().get(3)) * 10 + 1);	// Id = le parent * 10 + 1 (ex : ss panel 1 de père 3 devient 31)
			l2.setOrientation(LinearLayout.VERTICAL);						// Orientation verticale par défaut
			if(b.getParam().get(5) == "V")
			{
				l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, HAUTEUR * Integer.parseInt(b.getParam().get(4)) / 100));
			}
			else
			{
				l2.setLayoutParams(new LinearLayout.LayoutParams(LARGEUR * Integer.parseInt(b.getParam().get(4)) / 100, LayoutParams.WRAP_CONTENT));	// !! GERER LE CAS OU C'EST UN SPLIT VERTICAL !!!
			}
			this.addView(l2);												// Bind avec le layout parent
			
			// Sous panel 2
			LinearLayout l3 = new LinearLayout(b.getActivity());
			l3.setId( Integer.parseInt(b.getParam().get(3)) * 10 + 2);
			l3.setOrientation(LinearLayout.VERTICAL);
			if(b.getParam().get(5) == "V")
			{
				l3.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, HAUTEUR * (100 - Integer.parseInt(b.getParam().get(4))) / 100));
			}
			else
			{
				l3.setLayoutParams(new LinearLayout.LayoutParams(LARGEUR * (100 - Integer.parseInt(b.getParam().get(4))) / 100, LayoutParams.WRAP_CONTENT));	// !! GERER LE CAS OU C'EST UN SPLIT VERTICAL !!!
			}
			this.addView(l3);
		}
		
		// On recherche l'élement dans lequel on veut rajouter le nouvel élement, et on bind
		((LinearLayout) b.getGlobal().findViewById( b.getIdParent() )).addView(this);	

	}
}
