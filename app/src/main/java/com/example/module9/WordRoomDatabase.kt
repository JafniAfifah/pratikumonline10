package com.example.module9

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false))
public abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao() : WordDao

    companion object{
        //Singleton prevents multiple instances of database opening at the same times
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(
            context: Context,
            viewModelScope: CoroutineScope
        ) {
            val tempIntance = INSTANCE
            if (tempIntance !=null){
                return tempIntance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance

            }
        }
    }
}