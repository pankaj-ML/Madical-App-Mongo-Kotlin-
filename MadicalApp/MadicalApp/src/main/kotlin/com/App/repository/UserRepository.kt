package com.App.repository

import com.App.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User,Long>{

}