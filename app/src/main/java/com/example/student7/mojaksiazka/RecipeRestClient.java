package com.example.student7.mojaksiazka;


import com.example.student7.mojaksiazka.data.EmailAndPassword;
import com.example.student7.mojaksiazka.data.Recipe;
import com.example.student7.mojaksiazka.data.RecipeList;
import com.example.student7.mojaksiazka.data.User;


import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;

import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;

import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


@Rest(rootUrl = "http://pegaz.wzr.ug.edu.pl:8080/rest", converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-Dreamfactory-Application-Name"})
public interface RecipeRestClient extends RestClientHeaders {

    @Get("/db/recipes")
    RecipeList getRecipeList();

    @Post("/db/recipes")
    @RequiresHeader({"X-Dreamfactory-Session-Token","X-Dreamfactory-Application-Name" })
    void addRecipeList (Recipe recipe);


    @Post("/user/session")
    User login(EmailAndPassword emailAndPassword);
}