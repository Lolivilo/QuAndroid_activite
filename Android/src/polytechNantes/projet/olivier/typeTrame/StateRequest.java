package polytechNantes.projet.olivier.typeTrame;

import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.version.trames.Trame;
import polytechNantes.projet.olivier.version.trames.TrameRequest;

public class StateRequest extends ServiceRequest
{
	private TrameRequest trame;
	private ElementBuilder builder;
	
	
	public StateRequest(Trame t, ElementBuilder b)
	{
		this.trame = (TrameRequest) t;
		this.builder = b;
	}
}
