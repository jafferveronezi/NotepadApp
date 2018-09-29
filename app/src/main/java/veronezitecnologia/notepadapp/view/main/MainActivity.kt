package veronezitecnologia.notepadapp.view.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.LinearLayout

import veronezitecnologia.notepadapp.R
import veronezitecnologia.notepadapp.model.Nota


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    private var adapter: MainListAdapter? = null

    private var containerLoading: LinearLayout? = null
    private var recyclerview: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        containerLoading = findViewById(R.id.containerLoading) as LinearLayout
        recyclerview = findViewById(R.id.recyclerview) as RecyclerView

        mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel::class.java)

        mainViewModel.notas.observe( this, notasObserver)
        mainViewModel.isLoading.observe(this, loadingObserver)

        mainViewModel.buscarTodos()

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private var loadingObserver = Observer<Boolean> {
     if(it == true) {
         containerLoading?.visibility = View.VISIBLE
     } else {
         containerLoading?.visibility = View.GONE
     }
    }

    private var notasObserver = Observer<List<Nota>> {
        preencheALista(it!!)
    }

    private fun preencheALista(notas: List<Nota>) {
        adapter = MainListAdapter(this, notas, {}, {})

        recyclerview?.adapter = adapter
        recyclerview?.layoutManager = LinearLayoutManager(this)
    }

}
