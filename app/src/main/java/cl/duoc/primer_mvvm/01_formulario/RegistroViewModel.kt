package cl.duoc.primer_mvvm.`01_formulario`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistroViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegistroUiState())
    val uiState: StateFlow<RegistroUiState> = _uiState.asStateFlow()

    fun cambiarNombre(nuevoNombre: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(nombre = nuevoNombre)
        }
    }

    fun cambiarApellido(nuevoApellido: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(apellido = nuevoApellido)
        }
    }

    fun cambiarCorreo(nuevoCorreo: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(correo = nuevoCorreo)
        }
    }

    fun cambiarPassword(nuevoPassword: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(password = nuevoPassword)
        }
    }

    fun cambiarRepetirPassword(nuevoRepetirPassword: String) {
        _uiState.update { estadoActual ->
            estadoActual.copy(repetirPassword = nuevoRepetirPassword)
        }
    }

    fun cambiarTerminos(nuevoTerminos: Boolean) {
        _uiState.update { estadoActual ->
            estadoActual.copy(aceptaTerminos = nuevoTerminos)
        }
    }

    // Acción del formulario
    fun registrar() {
        val estado = _uiState.value
        val errorNombre = !validarNombre(estado.nombre)
        val errorApellido = !validarApellido(estado.apellido)
        val errorCorreo = !validarCorreo(estado.correo)
        val errorPassword = !validarPassword(estado.password)
        val errorRepetirPassword =
            !passwordsCoinciden(estado.password, estado.repetirPassword)
        val errorTerminos = !estado.aceptaTerminos

        _uiState.update { estadoActual ->
            estadoActual.copy(
                errorNombre = errorNombre,
                errorApellido = errorApellido,
                errorCorreo = errorCorreo,
                errorPassword = errorPassword,
                errorRepetirPassword = errorRepetirPassword,
                errorTerminos = errorTerminos,
            )
        }

        val formularioValido =
            !errorNombre &&
                    !errorApellido &&
                    !errorCorreo &&
                    !errorPassword &&
                    !errorRepetirPassword &&
                    !errorTerminos

        if (formularioValido) {
            println("Usuario registrado correctamente")
            _uiState.value = RegistroUiState()
        }

    }
}