package com.example.jpa_exercise_entity.dao;

import com.example.jpa_exercise_entity.model.AppUser;

public interface AppUserDAO {

    AppUser findById (int id);
    AppUser save (AppUser appUser);
    AppUser delete (AppUser appUser);
}
