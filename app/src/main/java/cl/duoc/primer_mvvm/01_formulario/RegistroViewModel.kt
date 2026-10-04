package cl.duoc.primer_mvvm.`01_formulario`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RegistroViewModel : ViewModel() {

    // Variables
    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")
    var correo by mutableStateOf("")
    var password by mutableStateOf("")
    var repetirPassword by mutableStateOf("")
    var aceptaTerminos by mutableStateOf(false)

    // Estados de error
    var errorNombre by mutableStateOf(false)
    var errorApellido by mutableStateOf(false)
    var errorCorreo by mutableStateOf(false)
    var errorPassword by mutableStateOf(false)
    var errorRepetirPassword by mutableStateOf(false)
    var errorTerminos by mutableStateOf(false)

    // Acción del formulario
    fun registrar() {
        errorNombre = !validarNombre(nombre)
        errorApellido = !validarApellido(apellido)
        errorCorreo = !validarCorreo(correo)
        errorPassword = !validarPassword(password)
        errorRepetirPassword =
            !passwordsCoinciden(password, repetirPassword)
        errorTerminos = !aceptaTerminos

        val formularioValido =
            !errorNombre &&
                    !errorApellido &&
                    !errorCorreo &&
                    !errorPassword &&
                    !errorRepetirPassword &&
                    !errorTerminos

        if (formularioValido) println("Usuario registrado correctamente")
    }
}