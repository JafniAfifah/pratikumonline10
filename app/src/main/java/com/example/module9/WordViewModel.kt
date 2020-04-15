package com.example.module9

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application)  : AndroidViewModel(application){
    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init{
        val wordsDao = WordRoomDatabase.getDatabase(application,
            viewModelScope).WordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWord
    }

    fun insert(word : Word) = viewModelScope.launch{
        repository.insert(word)
    }
}