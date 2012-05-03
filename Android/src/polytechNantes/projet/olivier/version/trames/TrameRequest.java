package polytechNantes.projet.olivier.version.trames;

import java.util.ArrayList;
import java.util.List;

public class TrameRequest extends Trame
{
	private int idWidget;
	
	public TrameRequest(String version, int idCo, int idTrame,
			String typeTrame, List<String> p)
	{
		super(version, idCo, idTrame, typeTrame, p);
		this.idWidget = Integer.parseInt(this.param.get(1));
	}

	
	public int getIdWidget()
	{
		return this.idWidget;
	}
	
	public String toString()
	{
		return super.toString() + ";" + String.valueOf(this.idWidget);
	}
}
