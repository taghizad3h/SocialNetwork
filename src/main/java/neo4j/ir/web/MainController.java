package neo4j.ir.web;

import neo4j.ir.Service.MovieService;
import neo4j.ir.Service.SecurityHelper;
import neo4j.ir.Service.UserService;
import neo4j.ir.nodes.Movie;
import neo4j.ir.nodes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ali Asghar on 28/06/2017.
 */
@Controller
public class MainController {

    @Autowired
    private SecurityHelper securityHelper;
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String welcome(Map<String,Object> model){

        User currentUser = securityHelper.getCurrentUser();

        model.put("userName",currentUser.getUserName());
        model.put("firstName",currentUser.getFirstName());
        model.put("lastName",currentUser.getLastName());

        model.put("test",movieService.getAll());

        return "index";
    }



}
