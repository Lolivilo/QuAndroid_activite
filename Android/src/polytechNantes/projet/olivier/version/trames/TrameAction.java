package polytechNantes.projet.olivier.version.trames;

import java.util.ArrayList;
import java.util.List;

public class TrameAction extends Trame
{
	
	
	
	public TrameAction(String version, int idCo, int idTrame, String typeTrame, List<String> p)
	{
		super(version, idCo, idTrame, typeTrame, p);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		return super.toString() + ";" + this.param.toString();
	}
}