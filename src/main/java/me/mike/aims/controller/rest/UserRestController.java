package me.mike.aims.controller.rest;

import me.mike.aims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael Keith
 */
@RestController
public class UserRestController {
    @Autowired
    private UserService service;

    // TODO
}
