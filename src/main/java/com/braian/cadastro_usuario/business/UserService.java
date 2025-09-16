package com.braian.cadastro_usuario.business;

import com.braian.cadastro_usuario.infrastructure.entities.User;
import com.braian.cadastro_usuario.infrastructure.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){
            repository.saveAndFlush(user);
    }

    public User findById(Integer id){
        return repository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public void updateUserById(Integer id, User user ){
        User userEntity = repository.findById(id).orElseThrow(()->new RuntimeException("User not found") );
        User userUpdated = User.builder()
                .id(userEntity.getId())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .build();

        repository.saveAndFlush(userUpdated);
    }


}
