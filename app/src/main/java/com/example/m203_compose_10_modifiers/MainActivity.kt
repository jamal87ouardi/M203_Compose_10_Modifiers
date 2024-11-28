package com.example.m203_compose_10_modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m203_compose_10_modifiers.ui.theme.M203_Compose_10_ModifiersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_Compose_10_ModifiersTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var inputText by remember { mutableStateOf("") }
    var displayText by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Champ de saisie de texte
        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Entrez du texte") },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Blue, RoundedCornerShape(20.dp))


        )

        // Bouton pour valider
        Button(
            onClick = { displayText = inputText },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Afficher")
        }

        // Texte affiché après clic
        Text(
            text = displayText
        )
    }
}