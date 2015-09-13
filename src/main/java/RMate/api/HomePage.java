package RMate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by User on 2015/09/13.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Excellent Home Page 2";
    }


}
