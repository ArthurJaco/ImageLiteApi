package io.github.arthurgoat.imageliteapi.domain.service;

import io.github.arthurgoat.imageliteapi.domain.AccessToken;
import io.github.arthurgoat.imageliteapi.domain.entity.User;

public interface UserService {
    User getByEmail(String email);
    User save(User user);
    AccessToken autheticate(String email, String password);
    
}
