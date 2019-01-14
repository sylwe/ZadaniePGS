package com.swlodyga.ZadaniePGS.controller;

import com.swlodyga.ZadaniePGS.database.LessonsRepo;
import com.swlodyga.ZadaniePGS.database.UsersRepo;
import com.swlodyga.ZadaniePGS.model.Lessons;
import com.swlodyga.ZadaniePGS.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UsersRepo usersRepo;

    @RequestMapping("/student")
    public String hello(){
        return "Hello Word";
    }

//    Informacje o użytkowniku

    @GetMapping("/student/{id}")
    public Optional<Users> showUser (@PathVariable Long id) {
        return usersRepo.findById(id);
    }

//  Edytowanie informacji o sobie

    @PutMapping("/student/{id}")
    Users replaceUser (@RequestBody Users newUser, @PathVariable Long id) {

    return usersRepo.findById(id)
            .map(users -> {
                users.setUsername(newUser.getUsername());
                users.setEmail(newUser.getEmail());
                users.setPassword(newUser.getPassword());
                return usersRepo.save(users);
            })
            .orElseGet(() -> {
                newUser.setId(id);
                return usersRepo.save(newUser);
            });
    }

    @Autowired
    LessonsRepo lessonsRepo;

    //    Wyświetlanie zajęć
    @GetMapping("/student/lessons/getall")
    public Page<Lessons> getTitle(Pageable pageable){
        return lessonsRepo.findAll(pageable);
    }
//Wpisywanie się na zajęcia
    @PutMapping("/student/lesson/{id}")
    Lessons editLesson(@RequestBody Lessons editLesson, @PathVariable Long id){
        return lessonsRepo.findById(id)
                .map(lessons -> {
                    lessons.setUserPresence(editLesson.getUserPresence());
                    return lessonsRepo.save(lessons);
                })
                .orElseGet(() -> {
                    editLesson.setId(id);
                    return lessonsRepo.save(editLesson);
                });

    }


}



