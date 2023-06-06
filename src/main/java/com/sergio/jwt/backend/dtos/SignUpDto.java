package com.sergio.jwt.backend.dtos;

public record SignUpDto (String firstName, String surName, String lastName, String phone, char[] password) { }
