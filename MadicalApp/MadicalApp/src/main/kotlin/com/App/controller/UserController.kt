package com.App.controller

import com.App.model.User
import com.App.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class UserController(private var userRepository: UserRepository) //call repository hear
{
    //(1) GET ALL USERS DATA
    @GetMapping("/getUsers")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(this.userRepository.findAll())
    }

    //(2) GET USER DARA BY ID
    @GetMapping("/getUser/{id}")
    fun getUsers(@PathVariable id: Long): ResponseEntity<User>
    {
        return ResponseEntity.ok(this.userRepository.findById(id).orElse(null))
    }

    //(3) POST ONE USER DATA
    @PostMapping("/addUser")
    fun AddUser(@RequestBody user: User): ResponseEntity<User>
    {
        return ResponseEntity.ok(this.userRepository.save(user))
    }

    //(4) POST ALL USER DATA (LIST OF USERS)
    @PostMapping("/addUsers")
    fun AddAllUsers(@RequestBody users : List<User>): ResponseEntity<List<User>>
    {
        return ResponseEntity.ok(this.userRepository.saveAll(users))
    }

    //(5) UPDATE USER DATA BY ID
    @PutMapping("/updat/{id}")
    fun updatUserbyID(@PathVariable id :Long, @RequestBody user: User):ResponseEntity<User>
    {
        var oldUserData =this.userRepository.findById(id).orElse(null)
        oldUserData.id = user.id
        oldUserData.name =user.name
        oldUserData.designation=user.designation
        oldUserData.email=user.email
        oldUserData.password=user.password
        return ResponseEntity.ok(this.userRepository.save(user))
    }

    //(6) DELET USER BY ID
    @DeleteMapping("/Delet/{id}")
    fun deletByID(@PathVariable id: Long): String
    {
        this.userRepository.deleteById(id)
        return "Deleted User with ID  : $id"
    }

    //(7) DELET ALL
    @DeleteMapping("/DeletAll")
    fun deletAll(): String
    {
        this.userRepository.deleteAll()
        return "All DATA DELETED"
    }
}