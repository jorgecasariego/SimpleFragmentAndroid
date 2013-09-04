package com.jc.simplefragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * 
 * @author jorgecasariego
 * @version 1.0
 * 
 * Fragments
 * ÀQuŽ son fragments?
 * Un fragment es un componente independiente el cual puede ser usado como una actividad. 
 * Un fragment encapsula una funcionalidad, por lo cual es facil reutilizarlo dentro de 
 * una actividad o un layout.
 * 
 * Un fragment corre dentro del contexto de una actividad pero tiene su propio ciclo de vida
 * y tipicamente su propia interfaz. Tambien es posible definir fragments con una interfaz de
 * usuario, por ejemplo headless fragments. (o fragments sin cabeza (UI) )
 * 
 * Los fragments pueden ser a–adidos a una actividad estaticamente o dinamicamente.
 * 
 * Ventajas de usar fragments
 * Los fragments hacen facil el reuso de componentes en diferentes layouts, por ejemplo:
 * podemos construir dise–os de un solo panel para telefonos(celulares) y dise–os de multiples
 * paneles para tablets. Pero los fragments no solo se limitan a tablets; por ejemplo: podemos
 * usar fragments para soportar las diferentes orientaciones de los telefonos celulares 
 * dependiendo de si estan en portrait o landscape
 *
 * Ciclo de vida de un Fragment
 * Un fragment tiene su propio ciclo de vida. Pero siempre esta conectado al ciclo de vida
 * de la actividad el cual usa ese fragment.
 * 
 * Ciclo de vida de un fragment (mientras su actividad esta corriendo)
 * Fragment is added -> onAttach() -> onCreate() -> onCreateView() -> OnActivityCreated() ->
 * onStart() -> onResume() -> Fragment is Active -> onPause() -> onStop() -> onDestroyView() ->
 * onDestroy() -> onDetach() -> Fragment is Destroy
 * 
 * Comucacion con Fragments
 * Pra incrementar el reuso de fragments ellos no deberian comunicarse directamente. Cada 
 * comunicaci—n de los fragments se debe hacer a traves de la actividad acogida. 
 * 
 * Para este ejemplo, un fragmento debe definir una interfaz como un tipo interno (OnItemSelectedListener
 * en MyListFragment) y requiere que la actividad que lo utiliza, implemente esta interfaz (OnRssItemSelected
 * en la actividad RssfeedActivity)
 */
public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rssfeed);
	}

	/**
	 * Este metodo es llamado cuando desde la clase MyListFragment se aprieta el boton
	 */
	@Override
	public void OnRssItemSelected(String link) {
		// Para chequear si el fragment es parte del layout usamos la clase FragmentManager
		DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
		if(fragment != null && fragment.isInLayout()) {
			fragment.setText(link);
		} else {
			//Si el telefono esta en modo portrait entonces iniciamos una nueva actividad
			Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_URL, link);
			startActivity(intent);
		}
	}

}
