package veronezitecnologia.notepadapp.api

import retrofit2.Call
import retrofit2.http.*
import veronezitecnologia.notepadapp.model.Nota

interface NotaAPI {
    @GET ("/nota")
    fun buscarTodos(): Call<List<Nota>>

    @GET("/nota/titulo/{titulo}")
    fun buscarPorTitulo(@Path("titulo") titulo: String): Call<List<Nota>>

    @POST("/nota")
    fun salvar(@Body nota: Nota): Call<Nota>

    @DELETE("/nota/{id}")
    fun apagar(@Path("id") id: String): Call<Void>


}