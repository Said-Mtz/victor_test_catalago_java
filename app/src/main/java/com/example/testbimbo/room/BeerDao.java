package com.example.testbimbo.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserAll(List<BeerEntity> beerListRoom);

    @Query("SELECT * FROM tbl_beer")
    List<BeerEntity> getBeerListRoom();

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun saveFavorite(beer: BeerEntity)
//
//    @Update
//    fun update(beer: BeerEntity)
//
//    @Query("SELECT * FROM tbl_beer")
//    fun getAllBeer(): List<BeerEntity>
}
