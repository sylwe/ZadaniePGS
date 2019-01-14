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
public class AdminController {

    @Autowired
    UsersRepo usersRepo;

    @RequestMapping("/")
    String hello(){
        return "Hello!";
    }
    @RequestMapping("/admin/hello")
    String helloAdmin(){
        return "Hello admin!";
    }

//    Wyświetlanie wszystkich użytkowników

//    @RequestMapping(value = "/admin/user/getall", method = RequestMethod.GET, produces="application/json")
    @GetMapping("/admin/user/getall")
    public Page<Users> getUser(Pageable pageable)throws Exception{
        return usersRepo.findAll(pageable);
    }
//    Dodawanie użytkowników

    @PostMapping("/admin/user/add")
    Users addUser(@RequestBody Users addUser) throws Exception{
        return usersRepo.save(addUser);
    }

//  Usuwanie usera

    @DeleteMapping("/admin/user/{id}")
    void deleteUser(@PathVariable Long id) {
        usersRepo.deleteById(id);
    }

//    Dodawanie zajęć
    @Autowired
    LessonsRepo lessonsRepo;

    @PostMapping("/admin/lesson/add")
    Lessons addLesson(@RequestBody Lessons addLesson) {
        return lessonsRepo.save(addLesson);
    }

//    Usuwanie zajęć
    @DeleteMapping("/admin/lesson/{id}")
    void deleteLesson(@PathVariable Long id){
        lessonsRepo.deleteById(id);
    }
//    Wyświetlanie zajęć
    @GetMapping("/admin/lessons/getall")
    public Page<Lessons> getTitle(Pageable pageable){
      return lessonsRepo.findAll(pageable);
    }
    @GetMapping("/student/lessons/{id}")
    public Optional<Lessons> getTitle(@PathVariable Long id){
        return lessonsRepo.findById(id);
    }

}
