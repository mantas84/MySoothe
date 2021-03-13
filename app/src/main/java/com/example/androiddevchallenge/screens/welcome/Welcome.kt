/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome(onLoginClick: () -> Unit = {}) {
    val isLightTheme = MaterialTheme.colors.isLight

    val background = if (isLightTheme) {
        painterResource(R.drawable.ic_light_welcome)
    } else {
        painterResource(R.drawable.ic_dark_welcome)
    }

    Surface(color = MaterialTheme.colors.surface) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                painter = background,
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp, 0.dp)
        ) {
            WelcomeContent(onLoginClick)
        }
    }
}

@Composable
fun WelcomeContent(onClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        logo()
        Spacer(modifier = Modifier.size(32.dp))
        WelcomeButton("Sign Up", MaterialTheme.colors.primary, {})
        Spacer(modifier = Modifier.size(8.dp))
        WelcomeButton("Log in", MaterialTheme.colors.secondary, onClick)
    }
}

@Composable
fun WelcomeButton(text: String, background: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth(),
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        colors = buttonColors(backgroundColor = background)
    ) {
        val fontStyle = MaterialTheme.typography.button
        val capsText = text.map { it.toUpperCase() }.joinToString(separator = "")
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp),
            color = MaterialTheme.colors.onPrimary,
            style = fontStyle,
            text = capsText
        )
    }
}

@Composable
fun logo() {
    val isLightTheme = MaterialTheme.colors.isLight
    val logo = if (isLightTheme) {
        painterResource(R.drawable.ic_light_logo)
    } else {
        painterResource(R.drawable.ic_dark_logo)
    }
    Image(painter = logo, contentDescription = null)
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome()
    }
}
