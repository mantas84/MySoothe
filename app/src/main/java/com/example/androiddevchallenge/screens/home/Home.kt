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
package com.example.androiddevchallenge.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Data
import com.example.androiddevchallenge.data.ItemData
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.surface) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            scaffold()
        }
    }
}

@Composable
fun HomeContent() {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
    ) {
        search()
        CategoryTitle("Favorite collections")
        Spacer(modifier = Modifier.height(8.dp))
        categoryItems2Rows(Data.favorite)
        Spacer(modifier = Modifier.height(8.dp))
        CategoryTitle("Align your body")
        Spacer(modifier = Modifier.height(8.dp))
        categoryItemsCircle(Data.body)
        Spacer(modifier = Modifier.height(8.dp))
        CategoryTitle("Align your mind")
        Spacer(modifier = Modifier.height(8.dp))
        categoryItemsCircle(Data.mind)
    }
}

@Composable
fun search() {
    var text by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 56.dp, 16.dp, 0.dp)
            .height(56.dp),
        value = text,
        leadingIcon = {
            Image(
                modifier = Modifier.size(18.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(R.drawable.ic_baseline_search_24),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = MaterialTheme.colors.surface
        ),
        textStyle = MaterialTheme.typography.body1,
        onValueChange = { text = it },
        label = {
            Text(
                modifier = Modifier.paddingFromBaseline(16.dp, 0.dp),
                text = "Search",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        }
    )
}

@Composable
fun CategoryTitle(text: String) {
    val capsText = text.map { it.toUpperCase() }.joinToString(separator = "")
    Text(
        modifier = Modifier
            .padding(8.dp, 0.dp)
            .paddingFromBaseline(40.dp),
        text = capsText,
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun categoryItemsCircle(list: List<ItemData>) {
    LazyRow(
        content = {
            item {
                Spacer(modifier = Modifier.size(12.dp))
            }
            items(list) {
                ItemCircle(it)
            }
            item {
                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    )
}

@Composable
fun categoryItems2Rows(list: List<ItemData>) {
    val even = list.filterIndexed { index, _ -> index.rem(2) == 0 }
    val odd = list.filterIndexed { index, _ -> index.rem(2) != 0 }
    val pairs = even.mapIndexed { index, itemData -> Pair(itemData, odd.getOrNull(index)) }
    LazyRow(
        content = {
            item {
                Spacer(modifier = Modifier.size(8.dp))
            }
            items(pairs) { pair ->
                Spacer(modifier = Modifier.size(8.dp))
                Column(
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                ) {
                    ItemColumn(pair.first)
                    Spacer(modifier = Modifier.size(8.dp))
                    pair.second?.let { ItemColumn(it) }
                }
            }
            item {
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    )
}

@Composable
fun ItemCircle(item: ItemData) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CoilImage(
            modifier = Modifier
                .padding(4.dp, 0.dp)
                .size(88.dp)
                .clip(CircleShape),
            data = item.photoUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            error = {
                imageLoadingError()
            },
            fadeIn = true
        )
        Text(
            modifier = Modifier
                .paddingFromBaseline(24.dp)
                .width(96.dp),
            text = item.title,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun imageLoadingError() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null
    )
}

@Composable
fun ItemColumn(item: ItemData) {
    Row(
        modifier = Modifier
            .size(192.dp, 56.dp)
            .background(MaterialTheme.colors.surface),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CoilImage(
            modifier = Modifier
                .size(56.dp)
                .clipToBounds(),
            data = item.photoUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            fadeIn = true,
            error = {
                imageLoadingError()
            }
        )
        Text(
            modifier = Modifier.padding(16.dp, 0.dp, 8.dp, 0.dp),
            text = item.title,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun scaffold() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { HomeScreenNav() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_baseline_play_arrow_24),
                    contentDescription = "play"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,

    ) {
        HomeContent()
    }
}

@Composable
private fun HomeScreenNav() {

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp,
        modifier = Modifier.height(56.dp),
    ) {

        BottomNavigationItem(
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    painterResource(id = R.drawable.ic_baseline_spa_24),
                    contentDescription = null,
                    Modifier.size(18.dp)
                )
            },
            label = { Text("Home", style = MaterialTheme.typography.caption) }
        )

        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    painterResource(id = R.drawable.ic_baseline_account_circle_24),
                    contentDescription = null,
                    Modifier.size(18.dp)
                )
            },
            label = { Text("Profile", style = MaterialTheme.typography.caption) }
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Home()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
