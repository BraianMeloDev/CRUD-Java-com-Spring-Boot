package com.braian.cadastro_usuario.controller;


import com.braian.cadastro_usuario.business.UserService;
import com.braian.cadastro_usuario.infrastructure.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return  ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> findById(@RequestBody Integer id){
        return  ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam Integer id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateById(@RequestParam Integer id,
                                           @RequestBody User user){
        userService.updateUserById(id, user);
        return ResponseEntity.ok().build();

    }

}
