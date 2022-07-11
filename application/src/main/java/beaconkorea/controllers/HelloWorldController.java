package beaconkorea.controllers;

import beaconkorea.DTO.TestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import beaconkorea.models.HelloWorldResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOError;
import java.io.IOException;
import java.text.ParseException;
import beaconkorea.service.excelSerivce;

/*
@RestController
@RequestMapping( "/hello" )
public class HelloWorldController
{
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<HelloWorldResponse> getHello( @RequestParam( defaultValue = "world" ) final String name )
    {
        logger.info("I am running!");
        return ResponseEntity.ok(new HelloWorldResponse(name));
    }
}
 */

@Controller
public class HelloWorldController implements WebMvcConfigurer {
    @RequestMapping("/home")
    public ModelAndView index(){
        ModelAndView  mv = new ModelAndView();
        mv.setViewName("excel");
        return mv;
    }
    @PostMapping("/home/test")
    public String homeTest(TestDto param) throws IOException, ParseException {
        excelSerivce ex = new excelSerivce();
        ex.excelSer(param);

        return "excel";
    }

}
