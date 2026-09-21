package com.example.exercicio_1_android_studio

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercicio_1_android_studio.ui.theme.Exercicio1AndroidStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Exercicio1AndroidStudioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaJogo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// COMPOSABLE DA TELA INICIAL DO JOGO
@Composable
fun TelaJogo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        GameOver() // Se tirar o comentário, aparece a tela de game over
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            LinhaScore()
            Inimigos()
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(50.dp, Alignment.Bottom)
        ) {
            Player()
            Iniciar()
        }

    }
}

@Composable
fun LinhaScore(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "SCORE: 0050",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "LIVES: ",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            VidaImg(
                modifier = Modifier
                    .size(15.dp)
            )

            VidaImg(
                modifier = Modifier
                    .size(15.dp)
            )

            VidaImg(
                modifier = Modifier
                    .size(15.dp)
            )
        }
    }

}

@Composable
fun Inimigos(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 80.dp)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InimigosImg()

            InimigosImg()

            InimigosImg()

            InimigosImg()

        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            InimigosImg()

            InimigosImg()

            InimigosImg()
        }
    }
}

@Composable
fun Player(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        PlayerImg()
    }
}

@Composable
fun Iniciar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(bottom = 40.dp)) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.DarkGray)
        ) {
            Text(
                modifier = modifier.align(Alignment.Center),
                text = "PRESS START",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )
        }
    }
}


// COMPOSABLE DA TELA DE GAME OVER
@Composable
fun GameOver(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            InimigosImg()

            InimigosImg()

            InimigosImg()

            InimigosImg()

            InimigosImg()
        }
        Text(
            text = "GAME OVER",
            fontSize = 70.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }

}


// COMPOSABLE DE IMAGENS

// Composable da imagem da vida
@Composable
fun VidaImg(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.coracao),
        contentDescription = "Vida do Player"
    )
}

// Composable das imagens dos inimigos
@Composable
fun InimigosImg(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(70.dp),
        painter = painterResource(R.drawable.inimigo),
        contentDescription = "Inimigos"
    )
}

// Composable da imagem do player
@Composable
fun PlayerImg(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(70.dp),
        painter = painterResource(R.drawable.player),
        contentDescription = "Player"
    )
}
