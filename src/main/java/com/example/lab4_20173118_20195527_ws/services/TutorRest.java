package com.example.lab4_20173118_20195527_ws.services;

import com.example.lab4_20173118_20195527_ws.entities.Employees;
import com.example.lab4_20173118_20195527_ws.entities.Jobs;
import com.example.lab4_20173118_20195527_ws.repositories.EmployeesRepo;
import com.example.lab4_20173118_20195527_ws.repositories.JobsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class TutorRest {
    @Autowired
    EmployeesRepo employeesRepo;
    @Autowired
    JobsRepo jobsRepo;
    @GetMapping("/difPRES")
    public List<Employees> difPresi(){
        Jobs jobs = jobsRepo.findById("AD_PRES").get();
        return employeesRepo.findAllByJobIdNot(jobs);
    }

    @PutMapping("/asignarTutoria")
    public ResponseEntity<HashMap<String, String>> asignarTutoria(
            @RequestParam("idEmployee") int idEmployee,
            @RequestParam("idTutor") int idTutor){
        HashMap<String, String> respuesta = new HashMap<>();
        Optional<Employees> optTrabajador = employeesRepo.findById(idEmployee);
        Optional<Employees> optTutor = employeesRepo.findById(idTutor);
        if (optTrabajador.isPresent()){
            Employees trabajador = optTrabajador.get();
            if (optTutor.isPresent()){
                if (trabajador.getManagerId()!=null && trabajador.getManagerId() == idTutor){
                    if (trabajador.getMeeting() == 1){
                        respuesta.put("Error", "El trabajador ya tiene una cita asignada");
                        return ResponseEntity.badRequest().body(respuesta);
                    }else {
                        trabajador.setMeeting((byte) 1);
                        System.out.println("Reunión"+trabajador.getMeeting());
                        employeesRepo.save(trabajador);
                        respuesta.put("Estado", "Cita asignada");
                        return ResponseEntity.ok(respuesta);
                    }
                }else {
                    respuesta.put("Error", "No es el tutor del trabajador seleccionado");
                    return ResponseEntity.badRequest().body(respuesta);
                }
            }else {
                respuesta.put("Error", "Tutor no encontrado");
                return ResponseEntity.badRequest().body(respuesta);
            }
        }else {
            respuesta.put("Error","Trabajador no encontrado");
            return ResponseEntity.badRequest().body(respuesta);
        }
    }
}
