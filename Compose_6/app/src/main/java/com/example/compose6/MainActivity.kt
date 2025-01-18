package com.example.compose6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListadoSignos(listaDeSignos = listaDeSignos)
        }
    }
}

// Modelo de datos para los signos
data class Signo(
    val nombre: String,
    val titulo: String,
    val descripcion: String,
    val imagen: Int
)

@Composable
fun ListadoSignos(listaDeSignos: List<Signo>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(listaDeSignos) { signoActual ->
            TarjetaSigno(signo = signoActual)
        }
    }
}

@Composable
fun TarjetaSigno(signo: Signo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        // Título del signo
        Text(
            text = signo.nombre,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        // Imagen del signo
        Image(
            painter = painterResource(id = signo.imagen),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        // Subtítulo
        Text(
            text = signo.titulo,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        // Descripción
        Text(
            text = signo.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

// Lista de signos zodiacales con sus imágenes, títulos y descripciones
val listaDeSignos = listOf(
    Signo(
        nombre = "Aries",
        titulo = "Aries (21 de marzo-20 de abril)",
        descripcion = "Los nacidos bajo el signo de Aries suelen ser personas energéticas y apasionadas.",
        imagen = R.drawable.aries
    ),
    Signo(
        nombre = "Tauro",
        titulo = "Tauro (21 de abril-21 de mayo)",
        descripcion = "Este es un signo amoroso, al que le gusta ser romántico y práctico.",
        imagen = R.drawable.tauro
    ),
    Signo(
        nombre = "Géminis",
        titulo = "Géminis (22 de mayo-21 de junio)",
        descripcion = "La inteligencia es una de sus cualidades más conocidas y admiradas.",
        imagen = R.drawable.geminis
    ),
    Signo(
        nombre = "Cáncer",
        titulo = "Cáncer (22 de junio-22 de julio)",
        descripcion = "Son personas hogareñas, románticas y muy apasionadas.",
        imagen = R.drawable.cancer
    ),
    Signo(
        nombre = "Leo",
        titulo = "Leo (23 de julio-23 de agosto)",
        descripcion = "Les gusta ser líderes, apoyándose en sus ideas y convicciones.",
        imagen = R.drawable.leo
    ),
    Signo(
        nombre = "Virgo",
        titulo = "Virgo (24 de agosto-23 de septiembre)",
        descripcion = "Personas de carácter fuerte, con ideas firmes y claras.",
        imagen = R.drawable.virgo
    ),
    Signo(
        nombre = "Libra",
        titulo = "Libra (24 de septiembre-23 de octubre)",
        descripcion = "El equilibrio siempre está presente en su vida.",
        imagen = R.drawable.libra
    ),
    Signo(
        nombre = "Escorpión",
        titulo = "Escorpión (24 de octubre-22 de noviembre)",
        descripcion = "De mente calculadora, con carácter fuerte y decisivo.",
        imagen = R.drawable.escorpion
    ),
    Signo(
        nombre = "Sagitario",
        titulo = "Sagitario (23 de noviembre-21 de diciembre)",
        descripcion = "Suelen ser desordenados pero llenos de energía y pasión.",
        imagen = R.drawable.sagitario
    ),
    Signo(
        nombre = "Capricornio",
        titulo = "Capricornio (22 de diciembre-20 de enero)",
        descripcion = "Prácticos, con una habilidad nata para encontrar soluciones.",
        imagen = R.drawable.capricornio
    ),
    Signo(
        nombre = "Acuario",
        titulo = "Acuario (21 de enero-18 de febrero)",
        descripcion = "Amorosos, cariñosos y muy sensibles en sus relaciones.",
        imagen = R.drawable.acuario
    ),
    Signo(
        nombre = "Piscis",
        titulo = "Piscis (19 de febrero-20 de marzo)",
        descripcion = "La honestidad es una de sus mejores cualidades.",
        imagen = R.drawable.piscis
    )
)