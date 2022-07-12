package beaconkorea.controllers;

import beaconkorea.DTO.TestDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class controller implements WebMvcConfigurer {

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

    @RequestMapping("/signup")
    public ModelAndView SignUp(){
        ModelAndView  mv = new ModelAndView();
        mv.setViewName("SignUp");
        return mv;
    }


    @PostMapping("/home/test")
    public String homeTest(TestDto param) throws IOException, ParseException {
        excelSerivce ex = new excelSerivce();
        ex.excelSer(param);

        return "excel";
    }





}
