package com.rebecca.walmartapp

class User {
    private val firstname : String;
    private val lastname : String;
    private val email : String;
    private val password : String;

    constructor(firstname: String, lastname: String, email: String, password: String) {
        this.firstname = firstname
        this.lastname = lastname
        this.email = email
        this.password = password
    }
}