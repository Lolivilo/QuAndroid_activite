package polytechNantes.projet.olivier.version.reception;


import java.util.LinkedList;
import java.util.Queue;

import polytechNantes.projet.olivier.typeTrame.ServiceRequest;

/** FifoMacro
 * Stocke, sous forme de file, toutes les requetes Macro de "INIT" a "EXIT"
 * @author olivier
 *
 */
public class FifoMacro
{
	private Queue<ServiceRequest> fifo;
	
	public FifoMacro()
	{
		this.fifo = new LinkedList<ServiceRequest>();
	}
	
	public void push(ServiceRequest req)
	{
		this.fifo.add(req);
	}
	
	public ServiceRequest pop()
	{
		return( this.fifo.remove() );
	}
	
	public Queue<ServiceRequest> getFifo()
	{
		return this.fifo;
	}
}
