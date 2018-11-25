package com.mahdi.phonebookmaster.config;

import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.Role;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.ContactRepository;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Component
public class CmdLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public CmdLineRunner(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;

        this.contactRepository = contactRepository;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        Flux<User> people = Flux.just(
                new User(new ObjectId(), "ali", "110",
                        "Developer",
                        Arrays.asList("ROLE_ADMIN"), true, new Date())
        );

        return args -> {
            this.userRepository.deleteAll().thenMany(userRepository.saveAll(people)).blockLast();
        };
    }

    @Override
    public void run(String... args) throws Exception {
//        roleInit();
//        userInit();
//        contactInit();
        initFirst();
        System.out.println("Finished CmdLineRunner");
    }

    private void initFirst() {

    }

    private void contactInit() {
        Flux<Contact> contactFlux = Flux.just(
                new Contact("mahdi", "hp", "88477474", "09339466943", "mahdihp@gmail.com")
        );
        this.contactRepository.deleteAll()
                .thenMany(contactRepository.saveAll(contactFlux)).blockLast();
    }

    private void roleInit() {
      /*  Flux<Privilege> add_edit_delete_adduser = Flux.just(
                new Privilege("CREATE"),
                new Privilege("READ"),
                new Privilege("UPDATE"),
                new Privilege("DELETE")
        );
        this.privilegeRepository.deleteAll()
                .thenMany(privilegeRepository.saveAll(add_edit_delete_adduser)).blockFirst();


        List<Privilege> list_admin = add_edit_delete_adduser.collectList().block();
//
        Flux<Role> adminRole = Flux.just(
                new Role(list_admin, "Admin"),
                new Role(list_admin, "User"),
                new Role(list_admin, "Guest")
        );
        this.roleRepository.deleteAll()
                .thenMany(roleRepository.saveAll(adminRole)).blockFirst();

        //----------------------------------------------------------
        Mono<Long> count = userRepository.findAll().count();
        System.out.println("User Count ..." + count.block());
        if (count.block() <= 0) {
            System.out.println(count.block());
            Flux<User> people = Flux.just(
                    new User(new ObjectId(),"ali", "110", "Mahdihp", Arrays.asList("ROLE_ADMIN"), true)
            );
            this.userRepository.deleteAll()
                    .thenMany(userRepository.saveAll(people)).blockLast();
            System.out.println("Inserted User...");
        }
*/
        System.out.println("Role Inserted...");
    }

    private void userInit() {
       /* Mono<Long> count = userRepository.findAll().count();
        System.out.println("User Count ..." + count.block());
        if (count.block() <= 0) {
            System.out.println(count.block());
            Flux<User> people = Flux.just(
                    new User(new ObjectId(), "ali", "110", "Mahdihp", Arrays.asList("ROLE_ADMIN"), true)
            );
            this.userRepository.deleteAll()
                    .thenMany(userRepository.saveAll(people)).blockLast();
            System.out.println("Inserted User...");
        }*/
    }
}