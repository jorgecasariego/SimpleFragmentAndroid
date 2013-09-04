package com.jc.simplefragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Para este ejemplo, un fragmento debe definir una interfaz como un tipo interno (OnItemSelectedListener)
 * y requiere que la actividad que lo utiliza, implemente esta interfaz (RssfeedActivity)
 * 
 * @author jorgecasariego
 *
 */
public class MyListFragment extends Fragment{

	private OnItemSelectedListener listener;

	/**
	 * EL metodo onCreateView() es llamado por Android una vez que el fragmento debe
	 * crear su interfaz de usuario
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rsslist_overview, container, false);
		
		Button button = (Button)view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateDetail();
			}

			
		});
		
		return view;
	}
	
	public interface OnItemSelectedListener{
		public void OnRssItemSelected(String link);
	}
	
	//Esta actividad es llamada una vez que  el fragmento es asociado con la actividad
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		/**
		 * instanceof
		 * instanceof sirve para chequear el tipo de un objeto.
		 * Ya que Java es un lenguaje orientado a objetos, podemos probar si un objeto
		 * es de un tipo especifico. Por ejemplo: Una instancia de una clase especifica
		 */
		if(activity instanceof OnItemSelectedListener) {
			listener = (OnItemSelectedListener) activity;
		} else {
			throw new ClassCastException(activity.toString() + " must implemenet MyListFragment.OnItemSelectedListener");
		}
		
	}
	
	
	@Override
	public void onDetach() {
		super.onDetach();
		listener = null;
	}
	
	//Podria ser lanzada desde la actividad
	private void updateDetail() {
		// Creamos un string, solo para test
		String newTime = String.valueOf(System.currentTimeMillis());
		
		//Informamos a la actividad acerca de los cambios
		//basados en la definici—n de la interfaz
		listener.OnRssItemSelected(newTime);
		
	}
	
	
}
