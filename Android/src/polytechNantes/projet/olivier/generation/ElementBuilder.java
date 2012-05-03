package polytechNantes.projet.olivier.generation;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import polytechNantes.projet.olivier.typeTrame.MacroRequestClassic;
import polytechNantes.projet.olivier.typeTrame.ServiceRequest;
import polytechNantes.projet.olivier.version.reception.FifoMacro;
import polytechNantes.projet.olivier.emission.ServiceSender;
import polytechNantes.projet.olivier.generation.inputElement.Q_button;
import polytechNantes.projet.olivier.generation.inputElement.Q_checkBox;
import polytechNantes.projet.olivier.generation.inputElement.Q_checkBoxes;
import polytechNantes.projet.olivier.generation.inputElement.Q_label;
import polytechNantes.projet.olivier.generation.inputElement.Q_radioGroup;
import polytechNantes.projet.olivier.generation.inputElement.Q_slider;
import polytechNantes.projet.olivier.generation.layoutElement.Q_panel;

public class ElementBuilder
{
	// Constantes représentant la taille de l'écran (pas trouvé comment récupérer les tailles...)
	public static final int HAUTEUR = 450;
	public static final int LARGEUR = 800;
	
	
	private FifoMacro fifo;
	private LinearLayout global;
	private Activity act;
	private List<String> current;
	private Element enConstruction;
	private ServiceSender sender;
	
	public ElementBuilder(FifoMacro f, Activity a, LinearLayout g, ServiceSender s)
	{
		this.fifo = f;
		this.act = a;
		this.global = g;
		this.sender = s;
		this.enConstruction = null;
	}
	
	
	public void create(ServiceRequest urgent)
	{
		this.current = ((MacroRequestClassic) this.fifo.pop()).getParam();	// On dépile la file et on garde les parametres de la trame

		if(this.getTypeWidget().equals("PANEL"))			// Si c'est une demande de création d'un Panel
		{
			Q_panel p = new Q_panel(this);
		}
		
		if(this.getTypeWidget().equals("BUTTON"))			// Si c'est une demande de création de bouton
		{
			Q_button b = new Q_button(this);
		}
		
		if(this.getTypeWidget().equals("LABEL"))			// Si c'est une demande de création de Label
		{
			Q_label l = new Q_label(this);
		}

		if(this.getTypeWidget().equals("RADIOBUTTON"))		// Si c'est une demande de création de RadioButton
		{
			Q_radioGroup r = new Q_radioGroup(this);
		}
		
		if(this.getTypeWidget().equals("CHECKBOX"))
		{
			Q_checkBoxes cb = new Q_checkBoxes(this);
		}
		
		if(this.getTypeWidget().equals("SLIDER"))
		{
			Q_slider s = new Q_slider(this);
		}
	}
	
	
	public String getTypeWidget()
	{
		return(this.current.get(1));
	}
	
	public int getIdParent()
	{
		return(Integer.parseInt(this.current.get(2)));
	}
	
	
	public int getIdWidget()
	{
		return(Integer.parseInt(this.current.get(3)));
	}


// Getters
	public FifoMacro getFifo()
	{
		return this.fifo;
	}
	
	
	public Activity getActivity()
	{
		return this.act;
	}
	
	
	public LinearLayout getGlobal()
	{
		return this.global;
	}
	
	
	public List<String> getParam()
	{
		return this.current;
	}
}
