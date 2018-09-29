package veronezitecnologia.notepadapp.repository

import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import veronezitecnologia.notepadapp.api.getNotaAPI
import veronezitecnologia.notepadapp.model.Nota

class NotaRepository {

    fun buscarTodos (
            onComplete: (List<Nota>?) -> Unit,
            onError: (Throwable?) -> Unit
    ) {
        getNotaAPI()
                .buscarTodos()
                .enqueue(object : Callback<List<Nota>> {
                    override fun onFailure(call: Call<List<Nota>>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<List<Nota>>?, response: Response<List<Nota>>?) {
                        onComplete(response?.body())
                    }

                })

    }

}