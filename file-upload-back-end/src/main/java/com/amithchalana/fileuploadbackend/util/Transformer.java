package com.amithchalana.fileuploadbackend.util;

import com.amithchalana.fileuploadbackend.dto.UserDTO;
import com.amithchalana.fileuploadbackend.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Transformer {

    private final ModelMapper mapper ;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public User toUser(UserDTO userDTO){
        User user = mapper.map(userDTO, User.class);
        if (userDTO.getProfilePic() != null) {
            try {
                user.setProfilePicFromMultipartFile(userDTO.getProfilePic());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return user ;

    }

    public UserDTO toUserDTO(User userEntity){return mapper.map(userEntity,UserDTO.class);}
}
