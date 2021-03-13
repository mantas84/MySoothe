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
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.screens.home.Home
import com.example.androiddevchallenge.screens.login.Login
import com.example.androiddevchallenge.screens.welcome.Welcome

object Navigation {

    private const val welcome = "welcome"
    private const val login = "login"
    private const val home = "home"

    @Composable
    fun navigationComposable(navController: NavHostController) {
        NavHost(navController, startDestination = welcome) {
            composable(welcome) {
                Welcome(
                    onLoginClick = {
                        navController.navigate(login)
                    }
                )
            }
            composable(login) {
                Login(
                    onLoginClick = {
                        navController.navigate(home)
                    }
                )
            }
            composable(home) { Home() }
        }
    }
}
