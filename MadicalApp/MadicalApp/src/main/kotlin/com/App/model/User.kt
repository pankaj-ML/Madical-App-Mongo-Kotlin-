package com.App.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document("USER")
class User {

    @Id
    var id: Long? =null
    var name: String? =null
    var designation: String? =null
    var email: String? =null
    var password: String? =null

    constructor()
}