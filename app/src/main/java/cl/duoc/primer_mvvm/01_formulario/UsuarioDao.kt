package cl.duoc.primer_mvvm.`01_formulario`
import androidx.room3.Dao
import androidx.room3.Insert

// Configuramos el QUÉ VAMOS A HACER
@Dao
interface UsuarioDao {

    @Insert
    suspend fun insertar(usuario: Usuario)

}