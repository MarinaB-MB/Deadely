package com.deadely.piegallery

import com.deadely.piegallery.database.PhotoDao
import com.deadely.piegallery.database.PhotoEntity
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.network.RestService
import com.deadely.piegallery.utils.mapToEntity
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(private val api: RestService, private val pd: PhotoDao) {

    fun getPhotosList(page: Int, perPage: Int, orderBy: String = "LATEST") = api.getPhotos(page, perPage, orderBy)

    fun addToFavorite(photo: Photo) {
        pd.addFavoritePhoto(photo.mapToEntity())
    }

    fun deleteFromFavorite(photo: Photo) {
        pd.deleteFavoritePhoto(photo.mapToEntity())
    }

    fun getFavorites(): Single<List<PhotoEntity>> = pd.getAllFavorites()
}
