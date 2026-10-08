package cl.duoc.primer_mvvm.ui.usuarios

import android.app.Application
import androidx.lifecycle.*
import cl.duoc.primer_mvvm.data.*
import cl.duoc.primer_mvvm.model.Usuario
import kotlinx.coroutines.flow.*

class UsuariosViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val database =
        AppDatabase.getInstance(application)
    private val repository =
        UsuarioRepository(database.usuarioDao())

    val usuarios: StateFlow<List<Usuario>> =
        repository
            .obtenerUsuarios()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
}
