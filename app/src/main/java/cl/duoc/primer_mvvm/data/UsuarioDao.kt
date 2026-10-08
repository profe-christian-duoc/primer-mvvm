package cl.duoc.primer_mvvm.data
import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query
import cl.duoc.primer_mvvm.model.Usuario
import kotlinx.coroutines.flow.Flow

// Configuramos el QUÉ VAMOS A HACER
@Dao
interface UsuarioDao {

    @Insert
    suspend fun insertar(usuario: Usuario)

    @Query("SELECT * FROM usuarios")
    fun obtenerUsuarios(): Flow<List<Usuario>>
}