package cl.duoc.primer_mvvm.`01_formulario`

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegistroScreen(
    modifier: Modifier = Modifier,
    viewModel: RegistroViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Crear cuenta",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = {
                viewModel.nombre = it
            },
            label = {
                Text("Nombre")
            },
            isError = viewModel.errorNombre,
            supportingText = {
                if (viewModel.errorNombre) {
                    Text("El nombre es obligatorio")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.apellido,
            onValueChange = {
                viewModel.apellido = it
            },
            label = {
                Text("Apellido")
            },
            isError = viewModel.errorApellido,
            supportingText = {
                if (viewModel.errorApellido) {
                    Text("El apellido es obligatorio")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.correo,
            onValueChange = {
                viewModel.correo = it
            },
            label = {
                Text("Correo")
            },
            isError = viewModel.errorCorreo,
            supportingText = {
                if (viewModel.errorCorreo) {
                    Text("Ingrese un correo válido terminado en .cl")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {
                viewModel.password = it
            },
            label = {
                Text("Contraseña")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = viewModel.errorPassword,
            supportingText = {
                if (viewModel.errorPassword) {
                    Text("Debe contener al menos 8 caracteres")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = viewModel.repetirPassword,
            onValueChange = {
                viewModel.repetirPassword = it
            },
            label = {
                Text("Repetir contraseña")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = viewModel.errorRepetirPassword,
            supportingText = {
                if (viewModel.errorRepetirPassword) {
                    Text("Las contraseñas no coinciden")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = viewModel.aceptaTerminos,
                onCheckedChange = {
                    viewModel.aceptaTerminos = it
                }
            )

            Text("Acepto los términos y condiciones")
        }

        if (viewModel.errorTerminos) {
            Text(
                text = "Debe aceptar los términos y condiciones",
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(
            onClick = {
                viewModel.registrar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }
    }
}