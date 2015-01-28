package com.example.student7.mojaksiazka.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registration {
    public String first_name;
    public String last_name;
    public String email;
    public String new_password;
}