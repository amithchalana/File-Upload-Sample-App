package com.amithchalana.fileuploadbackend.service.custom;

import com.amithchalana.fileuploadbackend.dto.UserDTO;
import com.amithchalana.fileuploadbackend.service.SuperService;

public interface UserService extends SuperService {

    void CreateNewUser(UserDTO userDTO);
    UserDTO getUserAccountDetails(String username);
}
