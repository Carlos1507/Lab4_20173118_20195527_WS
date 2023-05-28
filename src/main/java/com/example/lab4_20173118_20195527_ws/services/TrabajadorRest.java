package com.example.lab4_20173118_20195527_ws.services;

import com.example.lab4_20173118_20195527_ws.entities.Employees;
import com.example.lab4_20173118_20195527_ws.entities.Jobs;
import com.example.lab4_20173118_20195527_ws.repositories.EmployeesRepo;
import com.example.lab4_20173118_20195527_ws.repositories.JobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabajador")
public class TrabajadorRest {
    @Autowired
    EmployeesRepo employeesRepo;
    @Autowired
    JobsRepo jobsRepo;

    @GetMapping("/verInfo")
    public ResponseEntity<HashMap<String, Object>> infoTrabajador(@RequestParam("id") int id){
        Optional<Employees> employee = employeesRepo.findById(id);
        HashMap<String, Object> respuesta = new HashMap<>();
        if (employee.isPresent()){
            respuesta.put("respuesta","encontrado");
            respuesta.put("empleado",employee.get());
            return ResponseEntity.ok(respuesta);
        }else {
            respuesta.put("respuesta","no encontrado");
            return ResponseEntity.badRequest().body(respuesta);
        }
    }
    @GetMapping("/difPRES")
    public List<Employees> difPresi(){
        Jobs jobs = jobsRepo.findById("AD_PRES").get();
        return employeesRepo.findAllByJobIdNot(jobs);
    }
}
