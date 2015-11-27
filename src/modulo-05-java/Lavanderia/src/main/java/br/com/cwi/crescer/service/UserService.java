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

    public List<UserDto> find(){
        List<UserDto> list = new ArrayList<UserDto>();

        for (Users user : this.userDao.find()){
            UserDto dto = new UserDto();
            dto.setUsername(user.getUsername());
            Authorities auth = this.authDao.findByUsername(user.getUsername());
            dto.setAuth(auth.getAuthoritiesId().getAuthority());
            list.add(dto);
        }

        return list;
    }

    public List<UserDto> findByName(String name) {
        List<UserDto> list = new ArrayList<UserDto>();

        for (Users user : this.userDao.findByName(name)){
            UserDto dto = new UserDto();
            dto.setUsername(user.getUsername());
            Authorities auth = this.authDao.findByUsername(user.getUsername());
            dto.setAuth(auth.getAuthoritiesId().getAuthority());
            list.add(dto);
        }

        return list;
    }

    public UserDto findByUsername(String id) {
        Users user = this.userDao.findByUsername(id);
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        return dto;
    }

    public void update(UserDto dto) {
        Users user = this.userDao.findByUsername(dto.getUsername());
        Authorities auth = this.authDao.findByUsername(dto.getUsername());
        user.setPassword(Criptografia.criptografar(dto.getPassword()));

        this.userDao.update(user);
        this.authUpdate(auth, dto);
    }

    public void remove(UserDto dto){
        Users user = this.userDao.findByUsername(dto.getUsername());
        user.setEnabled(false);
        this.userDao.update(user);
    }

    private void authUpdate(Authorities authority, UserDto dto){
        authority.setAuthoritiesId(new AuthoritiesId(dto.getUsername(), dto.getRole().toString()));
        this.authDao.update(authority);
    }
}
