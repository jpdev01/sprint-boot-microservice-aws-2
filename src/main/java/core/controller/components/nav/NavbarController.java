package core.controller.components.nav;

import core.components.nav.Navbar;
import core.entity.User;
import core.service.components.nav.NavbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nav")
public class NavbarController {

    @Autowired
    NavbarService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Navbar> findAll() {
        Navbar navbar = service.get();

        return new ResponseEntity<Navbar>(navbar, HttpStatus.OK);
    }
}
