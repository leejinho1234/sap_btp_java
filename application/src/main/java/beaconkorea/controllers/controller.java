package beaconkorea.controllers;

import beaconkorea.DTO.TestDto;

import beaconkorea.DTO.UserDto;
import beaconkorea.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import beaconkorea.service.excelSerivce;

@Controller
public class controller implements WebMvcConfigurer {

    @Autowired
    userService userService;

    @RequestMapping("/")
    public String home() {
        return "excel";
    }

    @RequestMapping("/home")
    public ModelAndView index(){
        ModelAndView  mv = new ModelAndView();
        mv.setViewName("excel");
        return mv;
    }

    //회원가입 폼
    @RequestMapping("/signup")
    public ModelAndView SignUp(){
        ModelAndView  mv = new ModelAndView();
        mv.setViewName("SignUp");
        return mv;
    }

    //모든 유저 확인
    @RequestMapping("/getAllUser")
    public String getAllUser(){
        List<UserDto> userDtoList = userService.getAllUser();
        System.out.println(userDtoList);
        return "SignUp";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@RequestParam("id") String id, @RequestParam("pw") String pw) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setPw(pw);

        userService.createUser(userDto);
        return "SignUp";
    }

    //엑셀파일 임포트
    @PostMapping("/home/test")
    public String homeTest(TestDto param) throws IOException, ParseException {
        excelSerivce ex = new excelSerivce();
        ex.excelSer(param);

        return "excel";
    }





}
