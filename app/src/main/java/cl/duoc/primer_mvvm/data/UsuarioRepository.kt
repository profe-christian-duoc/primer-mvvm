package cl.duoc.primer_mvvm.data

import cl.duoc.primer_mvvm.model.Usuario
import kotlinx.coroutines.flow.Flow


// DEFINIMOS EL COMO LO VAMOS A HACER
class UsuarioRepository(private val usuarioDao: UsuarioDao) {
    suspend fun guardar(usuario: Usuario){
        usuarioDao.insertar(usuario)
    }
    fun obtenerUsuarios(): Flow<List<Usuario>>{
        return usuarioDao.obtenerUsuarios()
    }
}
