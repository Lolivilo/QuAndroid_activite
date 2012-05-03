package polytechNantes.projet.olivier.version.trames;

import java.util.ArrayList;
import java.util.List;

public abstract class Trame
{
	protected String version;
	protected int idConnexion;
	protected int idTrame;
	protected String typeTrame;
	protected List<String> param;
	
	public Trame(String version, int idCo, int idTrame, String typeTrame, List<String> p)
	{
		this.version = version;
		this.idConnexion = idCo;
		this.idTrame = idTrame;
		this.typeTrame = typeTrame;
		this.param = new ArrayList<String>();
		this.param = p;
	}
	
	public String getVersion()
	{
		return this.version;
	}
	
	public int getConnexion()
	{
		return this.idConnexion;
	}
	
	public int getIdTrame()
	{
		return this.idTrame;
	}
	
	public List<String> getParam()
	{
		return this.param;
	}
	
	public String toString()
	{
		return this.version +";" + String.valueOf(this.idConnexion) + ";" + String.valueOf(this.idTrame) + this.typeTrame;
	}
}
