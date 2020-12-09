package com.deadely.piegallery

import com.deadely.piegallery.database.PhotoDao
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.network.RestService
import com.deadely.piegallery.utils.mapToEntity
import com.deadely.piegallery.utils.mapToModelList
import javax.inject.Inject

class Repository @Inject constructor(private val api: RestService, private val pd: PhotoDao) {

    fun getPhotosList(page: Int, perPage: Int, orderBy: String = "LATEST") = api.getPhotos(page, perPage, orderBy)

    fun addToFavorite(photo: Photo) {
        pd.addFavoritePhoto(photo.mapToEntity())
    }

    fun deleteFromFavorite(photo: Photo) {
        pd.deleteFavoritePhoto(photo.mapToEntity())
    }

    fun getFavorites(): List<Photo> {
        return pd.getAllFavorites().mapToModelList()
    }
}
