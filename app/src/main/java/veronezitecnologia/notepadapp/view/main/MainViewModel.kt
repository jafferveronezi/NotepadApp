package veronezitecnologia.notepadapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import veronezitecnologia.notepadapp.model.Nota
import veronezitecnologia.notepadapp.repository.NotaRepository

class MainViewModel: ViewModel(){
    val notaRepository = NotaRepository()

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val isLoading:  MutableLiveData<Boolean> = MutableLiveData()
    fun buscarTodos(){
        notaRepository
                .buscarTodos(onComplete = {
                    isLoading.value = false
                    notas.value = it
                },
                        onError = {
                            isLoading.value = false
                            notas.value = arrayListOf()
                        }
                )
    }

}