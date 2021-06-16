package com.example.demo.registration;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/signup")
    public String register(@RequestBody RegistrationRequest request ){

        return registrationService.register(request);
       // return"it works";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginRequest request){
        System.out.println(request.getEmail());

        return null;
    }

    @PostMapping(value = "/edit")
    public String updateUser(@RequestBody UpdateUserRequest userRequest){
        System.out.println(userRequest.getFirstName());
        return null;

    }
}
