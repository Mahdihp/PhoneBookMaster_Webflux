package com.mahdi.phonebookmaster;

import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.Role;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.PrivilegeRepository;
import com.mahdi.phonebookmaster.repository.RoleRepository;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class PhoneBookMasterApplication  {

//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private PrivilegeRepository privilegeRepository;


    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(PhoneBookMasterApplication.class);
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run(args);

    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        roleInit();
//        userInit();
//    }
//
//    private void roleInit() {
//        Flux<Privilege> add_edit_delete_adduser = Flux.just(
//                new Privilege("ADD,EDIT,DELETE,ADDUSER")
//        );
//        this.privilegeRepository.deleteAll()
//                .thenMany(this.privilegeRepository.saveAll(add_edit_delete_adduser));
//
//
//        List<Privilege> list_admin = Arrays.asList(add_edit_delete_adduser.blockFirst());
//
//        Flux<Role> adminRole = Flux.just(new Role(list_admin, "Admin"));
//        this.roleRepository.deleteAll()
//                .thenMany(this.roleRepository.saveAll(adminRole));
//
//        System.out.println("Role Inserted...");
//    }
//
//    private void userInit() {
//        Mono<Long> count = userRepository.findAll().count();
//        System.out.println("User Count ..." + count.block());
//        if (count.block() <= 0) {
//            System.out.println(count.block());
//            Flux<User> people = Flux.just(
//                    new User("ali", "110", "Mahdihp")
//            );
//            this.userRepository.deleteAll()
//                    .thenMany(userRepository.saveAll(people)).blockLast();
//            System.out.println("Inserted User...");
//        }
//    }
}
