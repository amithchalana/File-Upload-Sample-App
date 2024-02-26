package com.amithchalana.fileuploadbackend.api;

import com.amithchalana.fileuploadbackend.dto.UserDTO;
import com.amithchalana.fileuploadbackend.service.custom.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService ;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/create")
    public void createUserAccount(@RequestParam("fullName") String fullName,
                                  @RequestParam("userName") String userName,
                                  @RequestParam("password") String password,
                                  @RequestParam(value = "profilePic") MultipartFile profilePic) {

        UserDTO userDTO = new UserDTO(fullName,userName,password,profilePic);
        userDTO.setProfilePic(profilePic);
        System.out.println("size : "+profilePic.getSize());
        System.out.println("Null test  "+userDTO.getProfilePic().getSize() );
        userService.CreateNewUser(userDTO);
//        System.out.println(getUserAccountDetails(userName).getProfilePic().getSize());


    }



    public UserDTO getUserAccountDetails(String username) {
        return userService.getUserAccountDetails(username);
    }




}
