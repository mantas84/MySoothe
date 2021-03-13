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
package com.example.androiddevchallenge.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.screens.welcome.WelcomeButton
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Login(onLoginClick: () -> Unit = {}) {
    val isLightTheme = MaterialTheme.colors.isLight

    val background = if (isLightTheme) {
        painterResource(R.drawable.ic_light_login)
    } else {
        painterResource(R.drawable.ic_dark_login)
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
            LoginContent(onLoginClick)
        }
    }
}

@Composable
fun LoginContent(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginTitle("log in")
        Spacer(modifier = Modifier.size(32.dp))
        InputField("Email address")
        Spacer(modifier = Modifier.size(8.dp))
        InputField("Password")
        Spacer(modifier = Modifier.size(8.dp))
        WelcomeButton("Log in", MaterialTheme.colors.primary, onLoginClick)
        NoAccount("Don't have an account?", "Sign up")
    }
}

@Composable
fun LoginTitle(text: String) {
    val capsText = text.map { it.toUpperCase() }.joinToString(separator = "")
    Text(
        text = capsText,
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun NoAccount(text: String, text2: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {
        Text(
            text = text,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = text2,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1.copy(textDecoration = TextDecoration.Underline)
        )
    }
}

@Composable
fun InputField(label: String) {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = text,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = MaterialTheme.colors.surface
        ),
        textStyle = MaterialTheme.typography.body1,
        onValueChange = { text = it },
        label = {
            Text(
                modifier = Modifier.paddingFromBaseline(16.dp),
                text = label,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Login()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Login()
    }
}
