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
package com.example.androiddevchallenge.data

object Data {
    private const val shortMantras = "https://images.pexels.com/photos/4515858/pexels-photo-4515858.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val natureMeditations =
        "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val stressAndAnxiety =
        "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val selfMessage = "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?cs=srgb&dl=pexels-scott-webb-1029604.jpg&fm=jpg"
    private const val overhelmed = "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?cs=srgb&dl=pexels-ruvim-3560044.jpg&fm=jpg"
    private const val nightlyWindDown =
        "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val inversions =
        "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val quickYoga =
        "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val stretching =
        "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val tabata = "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"

    private const val hiit =
        "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val prenaturalYoga = "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val meditate =
        "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val withKids =
        "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val aromatherapy =
        "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val onTheGo = "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val withPets = "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"
    private const val highStress =
        "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=360&w=640"

    val list = listOf(
        ItemData(shortMantras, "Short mantras", Type.Favorite),
        ItemData(natureMeditations, "Nature Meditations", Type.Favorite),
        ItemData(stressAndAnxiety, "Stress and anxiety", Type.Favorite),
        ItemData(selfMessage, "Self message", Type.Favorite),
        ItemData(overhelmed, "Overhelmed", Type.Favorite),
        ItemData(nightlyWindDown, "Nightly wind down", Type.Favorite),
        ItemData(inversions, "Inversions", Type.Body),
        ItemData(quickYoga, "Quick yoga", Type.Body),
        ItemData(stretching, "Stretching", Type.Body),
        ItemData(tabata, "Tabata", Type.Body),
        ItemData(hiit, "HIIT", Type.Body),
        ItemData(prenaturalYoga, "Pre-natal yoga", Type.Body),
        ItemData(meditate, "Meditate", Type.Mind),
        ItemData(withKids, "With kids", Type.Mind),
        ItemData(aromatherapy, "Aromatherapy", Type.Mind),
        ItemData(onTheGo, "On the go", Type.Mind),
        ItemData(withPets, "With pets", Type.Mind),
        ItemData(highStress, "High stress", Type.Mind),
    )

    val favorite = list.filter { it.type == Type.Favorite }
//        .map { it.copy(photoUrl ="https://images.pexels.com/photos/5489194/pexels-photo-5489194.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" ) }
    val body = list.filter { it.type == Type.Body }
    val mind = list.filter { it.type == Type.Mind }
}

enum class Type {
    Favorite,
    Body,
    Mind,
}

data class ItemData(val photoUrl: String, val title: String, val type: Type)
