package com.example.Book_My_Show.Convertors;

import com.example.Book_My_Show.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show.Models.User;

public class UserConvertor {


    //Static is kept to avoid calling by objects
    public static User convertDtoToEntity(UserEntryDto userEntryDto){
        User user = User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName())
                .email(userEntryDto.getEmail()).mobile(userEntryDto.getMobile())
                        .address(userEntryDto.getAddress())
                .userName(userEntryDto.getUserName()).password(userEntryDto.getPassword()).build();
        return user;

    }
}
