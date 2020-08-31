package com.deadely.itl_en.repository

import android.util.Log
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.model.User
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.utils.DataState
import com.deadely.itl_en.utils.mapToUser
import com.deadely.itl_en.utils.mapToUserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository
@Inject constructor(val api: IRestDBService, val ud: UserDao) {

    suspend fun getUserByIdFromApi(id: String): Flow<DataState<User>> = flow {
        try {
            emit(DataState.Loading)
            val currentUserApi = api.getUserById(id)
            emit(DataState.Success(currentUserApi))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }

    suspend fun getUserByEmailFromApi(email: String): Flow<DataState<List<User>>> = flow {
        try {
            emit(DataState.Loading)
            val emailData = "{\"email\":\"$email\"}"
            Log.e("repository", "getUserByEmailFromApi: $emailData")
            val currentUserFromApi = api.getUserByEmail(emailData)
            emit(DataState.Success(currentUserFromApi))
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }
    }

    //db

    suspend fun getActiveUser(): User? {
        return ud.getAllUsers()[0].mapToUser()
    }

    suspend fun addUser(user: User) {
        ud.addUser(user.mapToUserEntity())
    }

    suspend fun updateUser(user: User) {
        ud.updateUser(user.mapToUserEntity())
    }

    suspend fun deleteUser(user: User) {
        ud.deleteUser(user.mapToUserEntity())
    }

}