package org.example.controller;

import org.example.controller.dto.User;
import org.example.service.ServiceLayer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
//todo: step6: create controller to project
//todo: step7: confige tomcat server to project

@RestController
@RequestMapping("/api/test")
public class DemoController {
//todo step14: inject service to controller
    private final ServiceLayer serviceLayer;
    public  DemoController(ServiceLayer service) {
        this.serviceLayer = service;
    }

    @GetMapping("/h1")
    public String h1(){
        return "h1 Method calling....";
    }

    //todo: step8: add h2 method , and get variable from user with @PathVariable
    @GetMapping("/h2/{name}")
    public String h2(@PathVariable String name){
        return " h2 Method calling" + name;
    }

    //todo:step9: query string method get variable from user
@GetMapping("/h3")
    public String h3(@PathParam("username") String username,
                     @PathParam("password") String password,
                     @PathParam("city") String city,
                     @PathParam("numberPhone") String numberPhone) {
    return "h3 Method calling " + " ....and username is:" + username +
            " " + ",password is :" + password + " " + "city  is:" + city +
            " " + "numberPhone is:" + numberPhone;
    //result : --- command in browser --->>> http://localhost:8090/api/test/h3?username=miladrostami71&password=4444443434&city=shiraz&numberPhone=9175026769
}
    //todo:step10: query string method get variable from user
    @GetMapping("/h4")
    public String h4(@RequestParam("username") String username,
            @RequestParam("password") String password){
        return "h4 Method calling " + " ....and username is:" + username +
                " " + ",password is :" + password + " " ;
        // result : --- command in browser --->>>    http://localhost:8090/api/test/h4?username=miladrostami71&password=4444443434
}
    //todo:step11: request body method for get Object from user
// User convert to json
    @PostMapping("/h5")
    public String h5(@RequestBody User user){
        return "h5 Method calling " + " " + user.toString();
    }

    //todo :step12: request body method for get Object from user
// json convert to User(object)
    @PostMapping("/h6")
    public User h6(@RequestBody User user){
        //todo step15: comment two code next step16
//          user.setName(user.getName() + "name updated") ;
//          user.setFamily(user.getFamily() + "family updated");
          return user;
    }


    // todo step16: use the service in controller injection

    @PostMapping("/h8")
    public User h8(@RequestBody User user){
        return serviceLayer.h7(user);
    }

    // todo step17: use the service in controller injection
// other method for pass entity
    @PostMapping("/h9")
    public ResponseEntity<User> h9(@RequestBody User user){
        var result = serviceLayer.h7(user);
        return ResponseEntity.ok(result);
    }

    // todo step18: use the service in controller injection
// other method for pass entity
    @PostMapping("/h10")
    public ResponseEntity<User> h10(@RequestBody User user){
        var result = serviceLayer.h11(user);
        if (result == null)
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }

    //todo : step20 matrix variable example

    @GetMapping("/h12/{nameId}")
    public String h12(@PathVariable String nameId,@MatrixVariable int number){

        return "h12 Method calling..." + " nameId is: " + nameId + " and number is: "
                + number;
    }
    @GetMapping("/h13/{nameId}")
    public String h13
            (@MatrixVariable(name = "q" ,pathVar = "ownerId") int number1
            ,@MatrixVariable(name = "w" ,pathVar = "ownerPat") int number2 ){

        return "h12 Method calling..." + " number1: " + number1 + " and number2 is: "
                + number2;
    }

    @GetMapping("/h14/{nameId}")
    public String h14(@PathVariable String nameId,@MatrixVariable int number){

        return "h12 Method calling..." + " nameId is: " + nameId + " and number is: "
                + number;
    }









}
