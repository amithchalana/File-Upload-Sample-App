package com.amithchalana.fileuploadbackend.service.custom.impl;

import com.amithchalana.fileuploadbackend.dto.UserDTO;
import com.amithchalana.fileuploadbackend.entity.User;
import com.amithchalana.fileuploadbackend.repository.UserRepository;
import com.amithchalana.fileuploadbackend.service.custom.UserService;
import com.amithchalana.fileuploadbackend.util.Transformer;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository ;

    private final Transformer transformer ;

    public UserServiceImpl(UserRepository userRepository, Transformer transformer) {
        this.userRepository = userRepository;
        this.transformer = transformer;
    }


    @Transactional
    @Override
    public void CreateNewUser(UserDTO userDTO) {

        User user = transformer.toUser(userDTO);
        try {
            System.out.println(userDTO.getProfilePic()== null);
            System.out.println(transformer.toUser(userDTO).getProfilePic() == null);
            userRepository.save(transformer.toUser(userDTO));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    @Override
    public UserDTO getUserAccountDetails(String username) {
        return userRepository.findById(username).map(transformer:: toUserDTO).get();
    }
}
