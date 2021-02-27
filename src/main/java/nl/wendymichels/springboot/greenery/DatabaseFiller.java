package nl.wendymichels.springboot.greenery;

import nl.wendymichels.springboot.greenery.payload.request.SignupRequest;
import nl.wendymichels.springboot.greenery.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseFiller implements CommandLineRunner {

    private final AuthorizationService authorizationService;

    @Autowired
    public DatabaseFiller(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        Set<String> rollen = new HashSet<>();
        rollen.add("admin");

        SignupRequest admin = new SignupRequest();
        admin.setUsername("admin");
        admin.setEmail("admin@admin.nl");
        admin.setPassword("123456");
        admin.setAvatar("https://www.imgworlds.com/wp-content/uploads/2015/12/18-CONTACTUS-HEADER.jpg");
        admin.setRole(rollen);
        authorizationService.registerUser(admin);

        SignupRequest mod = new SignupRequest();
        mod.setUsername("mod");
        mod.setEmail("mod@mod.nl");
        mod.setPassword("123456");
        mod.setAvatar("https://www.imgworlds.com/wp-content/uploads/2015/12/18-CONTACTUS-HEADER.jpg");
        rollen.remove("admin");
        rollen.add("mod");
        mod.setRole(rollen);
        authorizationService.registerUser(mod);


        SignupRequest user = new SignupRequest();
        user.setUsername("user");
        user.setEmail("user@user.nl");
        user.setPassword("123456");
        user.setAvatar("https://www.imgworlds.com/wp-content/uploads/2015/12/18-CONTACTUS-HEADER.jpg");
        rollen.remove("mod");
        rollen.add("user");
        user.setRole(rollen);
        authorizationService.registerUser(user);

        SignupRequest superuser = new SignupRequest();
        superuser.setUsername("superuser");
        superuser.setEmail("super@user.nl");
        superuser.setPassword("123456");
        superuser.setAvatar("https://www.imgworlds.com/wp-content/uploads/2015/12/18-CONTACTUS-HEADER.jpg");
        rollen.add("mod");
        rollen.add("admin");
        superuser.setRole(rollen);
        authorizationService.registerUser(superuser);

    }
}