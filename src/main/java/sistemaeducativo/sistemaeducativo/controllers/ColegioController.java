package sistemaeducativo.sistemaeducativo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import sistemaeducativo.sistemaeducativo.entities.Colegio;
import sistemaeducativo.sistemaeducativo.interfaces.IColegioService;

@RestController
@RequestMapping("/colegio")
@CrossOrigin
public class ColegioController {
    
    private IColegioService colegioService;

    public ColegioController(IColegioService colegioService) {
        this.colegioService= colegioService;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Colegio> getColegios() {
        return colegioService.getColegios();
    }
}
