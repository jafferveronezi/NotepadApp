package veronezitecnologia.notepadapp.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import veronezitecnologia.notepadapp.R
import veronezitecnologia.notepadapp.model.Nota

class MainListAdapter(
        val context: Context,
        val notas: List<Nota>,
        val listener: (Nota) -> Unit,
        val listenerDelete: (Nota) -> Unit) : RecyclerView.Adapter<MainListAdapter.NotaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.nota_item, parent, false)

        return NotaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota = notas[position]
        holder?.let {
            holder.bindView(nota, listener, listenerDelete)
        }
    }

    override fun getItemCount(): Int {
        return notas.size
    }

    class NotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitulo: TextView? = itemView.findViewById(R.id.tvTitulo) as TextView
        var tvDescricao: TextView? = itemView.findViewById(R.id.tvDescricao) as TextView

        fun bindView(nota: Nota,
                     listener: (Nota) -> Unit,
                     listenerDelete: (Nota) -> Unit) = with(itemView) {
            tvTitulo?.text = nota.titulo
            tvDescricao?.text = nota.descricao

            /*ivDelete.setOnClickListener {
                listenerDelete(jogo)
            }*/
            setOnClickListener { listener(nota) }
        }
    }
}