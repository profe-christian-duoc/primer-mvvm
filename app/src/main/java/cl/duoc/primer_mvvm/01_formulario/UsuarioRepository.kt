package cl.duoc.primer_mvvm.`01_formulario`


// DEFINIMOS EL COMO LO VAMOS A HACER
class UsuarioRepository(private val usuarioDao: UsuarioDao) {
    suspend fun guardar(usuario: Usuario){
        usuarioDao.insertar(usuario)
    }
}
