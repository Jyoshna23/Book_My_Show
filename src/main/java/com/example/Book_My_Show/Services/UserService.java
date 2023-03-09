package com.example.Book_My_Show.Services;

import com.example.Book_My_Show.Convertors.UserConvertor;
import com.example.Book_My_Show.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntryDto userEntryDto){
        User user = UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(user);

        return "User added Successfully ";
    }
}
