package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.AuthoritiesDao;
import br.com.cwi.crescer.dao.UserDao;
import br.com.cwi.crescer.domain.Authorities;
import br.com.cwi.crescer.domain.AuthoritiesId;
import br.com.cwi.crescer.domain.Users;
import br.com.cwi.crescer.dto.UserDto;

@Service
public class UserService {
	
    private UserDao userDao;
    private AuthoritiesDao authDao;

    @Autowired
    public UserService(UserDao userDao, AuthoritiesDao authDao){
        this.userDao = userDao;
        this.authDao = authDao;
    }

    public void inserir(UserDto dto){
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setPassword(Criptografia.criptografar(dto.getPassword()));
        user.setEnabled(true);
        Authorities auth = new Authorities();
        auth.setAuthoritiesId(new AuthoritiesId(dto.getUsername(), dto.getRole().toString()));
        this.userDao.add(user);
        this.authDao.add(auth);
    }
}
