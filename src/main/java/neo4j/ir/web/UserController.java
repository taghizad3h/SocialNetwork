package neo4j.ir.web;

import neo4j.ir.Service.UserService;
import neo4j.ir.nodes.User;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Ali Asghar on 28/06/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    GraphDatabaseService db;

    @Autowired
    UserService userService;

    @PostMapping("/edit")
    public ResponseEntity editUser(@RequestBody User user) {
        try{
            userService.update(user);
            return ResponseEntity.ok("user edited successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("couldn't edit user");
        }
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        try{
            userService.add(user);
            return ResponseEntity.ok("user added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("couldn't add user");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List> getOfUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

}