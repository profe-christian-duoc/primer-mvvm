package cl.duoc.primer_mvvm.`01_formulario`

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*

@Composable
fun RegistroScreen(modifier: Modifier = Modifier) {

    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repetirPassword by remember { mutableStateOf("") }
    var aceptaTerminos by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fechaNacimiento,
            onValueChange = { fechaNacimiento = it },
            label = { Text("Fecha de nacimiento") },
            placeholder = { Text("DD/MM/AAAA") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = repetirPassword,
            onValueChange = { repetirPassword = it },
            label = { Text("Repetir contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = aceptaTerminos,
                onCheckedChange = {
                    aceptaTerminos = it
                }
            )

            Text("Acepto los términos y condiciones")
        }

        Button(
            onClick = {
                println("Nombre: $nombre")
                println("Apellido: $apellido")
                println("Fecha: $fechaNacimiento")
                println("Correo: $correo")
                println("Contraseña: $password")
                println("Términos: $aceptaTerminos")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }
    }
}