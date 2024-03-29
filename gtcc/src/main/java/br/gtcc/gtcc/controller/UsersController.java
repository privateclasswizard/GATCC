/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gtcc.gtcc.controller;

import br.gtcc.gtcc.model.nitriteid.Users;
import br.gtcc.gtcc.controller.UsersController;

import br.gtcc.gtcc.services.impl.nitritedb.UserServices;

import org.dizitart.no2.collection.NitriteId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.gtcc.gtcc.services.spec.UserInterface;

/**
 *
 * @author mrbee
 * 
 * Controller da esntidade Users, criação de rotas  
 */

@CrossOrigin
@RestController
@RequestMapping("coordenacao/tcc/v1")
public class UsersController {
    
    @SuppressWarnings("rawtypes")
    @Autowired
    public UserInterface usersInterface;
    
    // @Autowired
    // UserServices service;
    
    @PostMapping("/usuario")
    public ResponseEntity<Users> createUser(@RequestParam(required = true) Users users){

        //Users createdUsers = service.createUsers(users);
        
        @SuppressWarnings("unchecked")
        Users createdUsers = (Users) usersInterface.createUsers(users);

        if (createdUsers != null) {
        
            return new ResponseEntity<>(createdUsers, HttpStatus.OK);
        
        } else {
        
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        } 
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Users> deleteUsers(@PathVariable long id){
       
        //Users deletedUsers =  service.deleteUsers(users);
    
        @SuppressWarnings("unchecked")
        Users deletedUsers =(Users)  usersInterface.deleteUsers(id);  

        if (deletedUsers != null) {
        
            return new ResponseEntity<>(deletedUsers, HttpStatus.OK);
        
        } else {
        
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        } 

    }
    
    @PutMapping("/usuario/{id}")
    public ResponseEntity<Users> updateUsers(@RequestParam(required = true) Users users){
        
        //Users updatedUser =  service.updateUsers(users);
 
        @SuppressWarnings("unchecked")
        Users updatedUser = (Users)  usersInterface.updateUsers(users);

        if (updatedUser != null) {
        
            return new ResponseEntity<>( updatedUser, HttpStatus.OK);
        
        } else {
        
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        } 
    
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<List<Users>> getAllUsers(){
        
        // List<Users> list = service.getAllUsers();
        List<Users> list = usersInterface.getAllUsers();
        return new ResponseEntity<>( list , HttpStatus.OK);
    
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id){
        
        //Users foundUsers = service.getUsers(user);

        @SuppressWarnings("unchecked")
        Users foundUsers = (Users) usersInterface.getUsers(id);
        

        if (foundUsers != null) {
        
            return new ResponseEntity<>(foundUsers, HttpStatus.OK);
        
        } else {
        
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        }
 

    }
    
}
