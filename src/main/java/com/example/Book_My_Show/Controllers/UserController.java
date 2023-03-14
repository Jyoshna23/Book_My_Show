package com.example.Book_My_Show.Controllers;

import com.example.Book_My_Show.EntryDTOs.UserEntryDto;
import com.example.Book_My_Show.Models.User;
import com.example.Book_My_Show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){

        try{
            String result = userService.addUser(userEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch(Exception e){
            String response = "User not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/get_userName")
    public String getUserName(@RequestParam("id") int id){
        return userService.getUserName(id);
    }


    @PutMapping("update_password")
    public String updatePassword(@RequestParam("id") int id,@RequestParam("password") String password){
        return userService.updatePassword(id,password);
    }

    @PutMapping("update_userName_password")
    public String updatePassword(@RequestParam("id") int id,@RequestParam("userName") String userName,@RequestParam("password") String password){
        return userService.updatePassword(id,userName,password);
    }
}
