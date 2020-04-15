package com.example.module9

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {
    val allWord: LiveData<List<Word>>=wordDao.getAlphabetizedWord()
            suspend fun insert(word: Word) {
                wordDao.insert(word)
            }
    )
}