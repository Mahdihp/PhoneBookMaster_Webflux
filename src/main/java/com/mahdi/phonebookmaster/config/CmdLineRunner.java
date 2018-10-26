package com.mahdi.phonebookmaster.config;

import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.Role;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.ContactRepository;
import com.mahdi.phonebookmaster.repository.PrivilegeRepository;
import com.mahdi.phonebookmaster.repository.RoleRepository;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


@Component
public class CmdLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public CmdLineRunner(UserRepository userRepository, RoleRepository roleRepository, PrivilegeRepository privilegeRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        roleInit();
        userInit();
        contactInit();

    }

    private void contactInit() {
        Flux<Contact> contactFlux = Flux.just(
          new Contact("mahdi","hp","88477474","09339466943","mahdihp@gmail.com")
        );
        this.contactRepository.deleteAll()
                .thenMany(contactRepository.saveAll(contactFlux)).blockLast();
    }

    private void roleInit() {
        Flux<Privilege> add_edit_delete_adduser = Flux.just(
                new Privilege("ADD,EDIT,DELETE,ADDUSER")
        );
        this.privilegeRepository.deleteAll()
                .thenReturn(privilegeRepository.saveAll(add_edit_delete_adduser).blockLast());


        List<Privilege> list_admin = Arrays.asList(add_edit_delete_adduser.blockFirst());
//
        Flux<Role> adminRole = Flux.just(new Role(list_admin, "Admin"));
        this.roleRepository.deleteAll().thenReturn(roleRepository.saveAll(adminRole).blockFirst());

        System.out.println("Role Inserted...");
    }

    private void userInit() {
        Mono<Long> count = userRepository.findAll().count();
        System.out.println("User Count ..." + count.block());
        if (count.block() <= 0) {
            System.out.println(count.block());
            Flux<User> people = Flux.just(
                    new User("ali", "110", "Mahdihp")
            );
            this.userRepository.deleteAll()
                    .thenMany(userRepository.saveAll(people)).blockLast();
            System.out.println("Inserted User...");
        }
    }
}