package com.amithchalana.fileuploadbackend.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;

import java.sql.Blob ;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Column(name = "full_name" , nullable = false)
    private String fullName ;
    @Id
    private String username ;
    @Column(nullable = false)
    private String password ;


    @Lob
    @Column(name = "profilePic" , columnDefinition = "MEDIUMBLOB")
    private byte[] profilePic ;
//    private Blob profilePic ;


    public void setProfilePicFromMultipartFile(MultipartFile file) throws IOException {
        this.profilePic = file.getBytes() ;
    }


}
