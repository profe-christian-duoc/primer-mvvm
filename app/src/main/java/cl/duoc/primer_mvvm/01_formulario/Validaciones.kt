package cl.duoc.primer_mvvm.`01_formulario`

fun validarNombre(nombre: String): Boolean {
    return nombre.isNotBlank()
}
fun validarApellido(apellido: String): Boolean {
    return apellido.isNotBlank()
}
fun validarCorreo(correo: String): Boolean {
    return correo.isNotBlank() &&
            correo.contains("@") &&
            correo.endsWith(".cl")
}
fun validarPassword(password: String): Boolean {
    return password.length >= 8
}
fun passwordsCoinciden(password: String, repetirPassword: String): Boolean {
    return password == repetirPassword
}