package com.example.exercicio_1_android_studio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
                    LinhaScore(modifier = Modifier.padding(innerPadding))
                    Inimigos()
                }
            }
        }
    }
}

@Composable
fun LinhaScore(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize()
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
            .padding(top = 130.dp)
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


// COMPOSABLE DE IMAGENS
@Composable
fun VidaImg(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.coracao),
        contentDescription = "Android Enemy"
    )
}

@Composable
fun InimigosImg(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(70.dp),
        painter = painterResource(R.drawable.inimigo),
        contentDescription = "Android Enemy"
    )
}
