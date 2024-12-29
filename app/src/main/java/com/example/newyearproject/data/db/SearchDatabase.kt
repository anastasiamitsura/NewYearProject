package com.example.newyearproject.data.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [Search::class], version = 1)
abstract class SearchDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}

@Entity
data class Search(
    @PrimaryKey
    val name: String,
)

@Dao
interface SearchDao {
    @Query("SELECT * FROM search")
    fun getAll(): List<Search>

    @Insert
    fun insert(query: Search)

    @Insert
    fun insertAll(queryes: List<Search>)

    @Delete
    fun delete(query: Search)
}