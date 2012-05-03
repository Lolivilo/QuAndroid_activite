package polytechNantes.projet.olivier.typeTrame;

import java.util.List;

import polytechNantes.projet.olivier.version.reception.FifoMacro;
import polytechNantes.projet.olivier.version.trames.Trame;
import polytechNantes.projet.olivier.version.trames.TrameAction;

public class MacroRequestClassic extends MacroRequest
{
	private FifoMacro fifo;
	
	
	public MacroRequestClassic(Trame t, FifoMacro f)
	{
		this.trame = t;
		f.push(this);
	}
	
	
	public List<String> getParam()
	{
		return ((TrameAction)this.trame).getParam();
	}
	
	
	public String toString()
	{
		return this.trame.toString();
	}
}
