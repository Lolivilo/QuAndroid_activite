package polytechNantes.projet.olivier.version;

import java.util.ArrayList;
import java.util.Iterator;

import polytechNantes.projet.olivier.generation.ElementBuilder;
import polytechNantes.projet.olivier.version.reception.FifoMacro;
import polytechNantes.projet.olivier.version.reception.ServiceReceiver;
import polytechNantes.projet.olivier.version.trames.TrameAction;
import polytechNantes.projet.olivier.emission.ServiceSender;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class QuestionnaireAndroidActivity extends Activity
{
	LinearLayout global;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.global = new LinearLayout(this);
        this.global.setId(1);
        this.global.setOrientation(LinearLayout.VERTICAL);
        
        
        // Creation de la fifo
        FifoMacro fifo = new FifoMacro();
        
        // Creation de la reception
        ServiceReceiver receiver = new ServiceReceiver(fifo);
        for(int i = 0 ; i < 9 ; i++)	// Boucle infinie (en attente) plus tard
        {
        	receiver.receiveTrame(i);
        	receiver.analyze();
        }

        Log.w("COMBIEN", Integer.toString(fifo.getFifo().size()));
        
     // Creation du sender d'informations
        ServiceSender sender = new ServiceSender();
        
        // Creation du builder d ui
        ElementBuilder builder = new ElementBuilder(fifo, this, this.global, sender);
        
        
        Iterator i = fifo.getFifo().iterator();
        while(i.hasNext())
        {
        	builder.create(null);
        }
        
        setContentView(this.global);
        
        Log.w("TAILLE", String.valueOf(View.MeasureSpec.getSize(View.MeasureSpec.EXACTLY)));
        Log.w("Abruti", String.valueOf(this.global.getMeasuredHeight()));
    }
}