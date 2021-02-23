package nl.wendymichels.springboot.greenery.controller;

import nl.wendymichels.springboot.greenery.payload.request.LoginRequest;
import nl.wendymichels.springboot.greenery.payload.request.SetAvatarRequest;
import nl.wendymichels.springboot.greenery.payload.request.SignupRequest;
import nl.wendymichels.springboot.greenery.payload.response.JwtResponse;
import nl.wendymichels.springboot.greenery.payload.response.MessageResponse;
import nl.wendymichels.springboot.greenery.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Uitleg over CrossOrigin en CORS:
 * https://medium.com/@baphemot/understanding-cors-18ad6b478e2b
 *
 * Gebruik in Spring-boot (op controller en globally)
 * https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm
 *
 * Zoals je hieronder ziet, kun je ook op klasse-niveau een adres configureren. Iaw alle methodes hieronder, hebben
 * /api/auth voor de link staan.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authorizationService.registerUser(signUpRequest);
    }


    @PatchMapping ("/user/update")
    public ResponseEntity <MessageResponse> updateUser(@RequestBody SetAvatarRequest setAvatarRequest) {
        System.out.println(setAvatarRequest);
        return authorizationService.updateUser(setAvatarRequest);
    }


}
