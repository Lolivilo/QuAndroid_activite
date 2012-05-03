package polytechNantes.projet.olivier.version.reception;

import java.util.ArrayList;
import java.util.List;

import polytechNantes.projet.olivier.typeTrame.MacroRequestClassic;
import polytechNantes.projet.olivier.typeTrame.MacroRequestRealTime;
import polytechNantes.projet.olivier.typeTrame.ServiceRequest;
import polytechNantes.projet.olivier.typeTrame.StateRequest;
import polytechNantes.projet.olivier.version.trames.Trame;
import polytechNantes.projet.olivier.version.trames.TrameAction;
import polytechNantes.projet.olivier.version.trames.TrameRequest;

/** ServiceSender
 * Recoit un objet Trame et l'analyse
 * En fonction de son analyse, détermine le type d'action a effectuer (stocker, réaliser, demander un état...)
 * @author olivier
 *
 */
public class ServiceReceiver
{
	private Trame trame;
	private FifoMacro fifo;
	
	public ServiceReceiver(FifoMacro f)
	{
		this.fifo = f;
	}
	
	
	public void receiveTrame(int nb)
	{
		// Ici, on simule l arrivee d une trame en creeant un nouvel objet Trame
		if(nb == 0)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("PANEL");
			paramTrame.add("1");
			paramTrame.add("2");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 1, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 1)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("PANEL");
			paramTrame.add("1");
			paramTrame.add("3");
			paramTrame.add("50");
			paramTrame.add("H");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 2, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 2)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("PANEL");
			paramTrame.add("1");
			paramTrame.add("4");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 3, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 3)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("LABEL");
			paramTrame.add("2");
			paramTrame.add("5");
			paramTrame.add("Comment jugez-vous la qualité de votre expérience 3D ?");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 4, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 4)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("LABEL");
			paramTrame.add("31");
			paramTrame.add("6");
			paramTrame.add("Sensation de profondeur dans la scène :");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 5, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 5)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("RADIOBUTTON");
			paramTrame.add("31");
			paramTrame.add("7");
			paramTrame.add("5");
			paramTrame.add("Bluffante !");
			paramTrame.add("Classique");
			paramTrame.add("Nulle");
			paramTrame.add("");
			paramTrame.add("");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 6, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 6)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("LABEL");
			paramTrame.add("32");
			paramTrame.add("8");
			paramTrame.add("Qualité de l'image :");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 7, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 7)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("RADIOBUTTON");
			paramTrame.add("32");
			paramTrame.add("9");
			paramTrame.add("3");
			paramTrame.add("Excellente");
			paramTrame.add("Moyenne");
			paramTrame.add("Mauvaise");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 8, "ACTION", paramTrame);
			this.trame = trame;
		}
		
		if(nb == 8)
		{
			List<String> paramTrame = new ArrayList<String>();
			paramTrame.add("MACRO");
			paramTrame.add("BUTTON");
			paramTrame.add("32");
			paramTrame.add("10");
			paramTrame.add("Valider");
			TrameAction trame = new TrameAction("SubVis-1.0.0", 3, 9, "ACTION", paramTrame);
			this.trame = trame;
		}
	}
	
	
	public void analyze()
	{
		if(this.trame instanceof TrameAction)	// On teste quelle instance de Trame nous est envoye (ACK, REQ, MACRO...)
		{
			/*
			if( Integer.parseInt(this.trame.getParam().get(1)) == 0)	// Le second parametre defini si c'est en temps reel ou non
			{
				ServiceRequest aStocker = new MacroRequestClassic(this.trame, this.fifo);
			}
			else
			{
				ServiceRequest aTraiter = new MacroRequestRealTime(this.trame);
			}*/
			ServiceRequest aStocker = new MacroRequestClassic(this.trame, this.fifo);
		}
		
		if(this.trame instanceof TrameRequest)
		{
			//ServiceRequest aTraiter = new StateRequest(this.trame, this);
		}
	}
}
