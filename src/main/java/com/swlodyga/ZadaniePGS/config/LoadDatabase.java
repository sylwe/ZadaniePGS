//package com.swlodyga.ZadaniePGS.config;
//
//import com.swlodyga.ZadaniePGS.database.UsersRepo;
//import com.swlodyga.ZadaniePGS.model.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//
//@Component
//class LoadDatabase {
//
//    private UsersRepo usersRepo;
//
//    @Autowired
//    public LoadDatabase(UsersRepo usersRepo){
//        this.usersRepo = usersRepo;
//    }
//
//    public void run() {
//        usersRepo.save(new Users(1L, "Bilbo Baggins", "bilbo", "bilbo", 2, "java", 2342, "user"));
//    }
//}
