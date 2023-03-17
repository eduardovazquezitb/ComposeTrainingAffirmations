/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations.data
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(1, R.string.affirmation1, R.drawable.image1, R.string.description1,R.string.to1, R.string.subject1, R.string.phone1),
            Affirmation(2, R.string.affirmation2, R.drawable.image2, R.string.description2,R.string.to2, R.string.subject2, R.string.phone2),
            Affirmation(3, R.string.affirmation3, R.drawable.image3, R.string.description3,R.string.to3, R.string.subject3, R.string.phone3),
            Affirmation(4, R.string.affirmation4, R.drawable.image4, R.string.description4,R.string.to4, R.string.subject4, R.string.phone4),
            Affirmation(5, R.string.affirmation5, R.drawable.image5, R.string.description5,R.string.to5, R.string.subject5, R.string.phone5),
            Affirmation(6, R.string.affirmation6, R.drawable.image6, R.string.description6,R.string.to6, R.string.subject6, R.string.phone6),
            Affirmation(7, R.string.affirmation7, R.drawable.image7, R.string.description7,R.string.to7, R.string.subject7, R.string.phone7),
            Affirmation(8, R.string.affirmation8, R.drawable.image8, R.string.description8,R.string.to8, R.string.subject8, R.string.phone8),
            Affirmation(9, R.string.affirmation9, R.drawable.image9, R.string.description9,R.string.to9, R.string.subject9, R.string.phone9),
            Affirmation(10, R.string.affirmation10, R.drawable.image10, R.string.description10,R.string.to10, R.string.subject10, R.string.phone10),)
    }

    fun loadAffirmation(id: Int) : Affirmation? {
        val affirmationList = loadAffirmations()
        for(i in 0 .. affirmationList.size-1){
            if(affirmationList[i].id == id)
                return affirmationList[i]
        }
        return null
    }
}
