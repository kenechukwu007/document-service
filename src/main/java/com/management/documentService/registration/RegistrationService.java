package com.management.documentService.registration;

import com.management.documentService.appuser.AppUser;
import com.management.documentService.appuser.AppUserRole;
import com.management.documentService.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private AppUserService appUserService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        AppUser user = new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        );
        return appUserService.signUpUser(user);

    }
}
