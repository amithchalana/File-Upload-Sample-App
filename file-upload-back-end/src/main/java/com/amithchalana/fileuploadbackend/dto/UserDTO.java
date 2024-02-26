package com.amithchalana.fileuploadbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String fullName;
    private String username ;
    private String password ;
    private MultipartFile profilePic;


}
