package polytechNantes.projet.olivier.generation;

import java.util.List;

import android.app.Activity;
import android.widget.LinearLayout;

public abstract class Element
{
	public static final int HAUTEUR = 450;
	public static final int LARGEUR = 800;
	
	
	protected ElementBuilder builder;
	protected boolean isCreated;
	
	public Element(ElementBuilder b)
	{
		this.builder = b;
		this.isCreated = false;
	}
	
	
	public abstract void create();
	
	public boolean isCreated()
	{
		return this.isCreated;
	}
	
// Getters
	public Activity getAct()
	{
		return this.builder.getActivity();
	}
	
	public LinearLayout getGlobal()
	{
		return this.builder.getGlobal();
	}
	
	public List<String> getParam()
	{
		return this.builder.getParam();
	}
	
	public int getIdWidget()
	{
		return this.builder.getIdWidget();
	}
	
	public int getIdParent()
	{
		return this.builder.getIdParent();
	}
}
