package com.example.TurismoaApplication.controladores;

import com.example.TurismoaApplication.modelos.Oferta;
import com.example.TurismoaApplication.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oferta")
public class OfertaControlador {
    @Autowired
    OfertaServicio ofertaServicio;
    @PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta datosOferta){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ofertaServicio.registrarOferta(datosOferta));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> editarOferta(@RequestBody Oferta datosNuevosOferta, @PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ofertaServicio.modificarOferta(id, datosNuevosOferta));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @GetMapping("{id}")
    public ResponseEntity<?> buscarUnaOferta(@PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ofertaServicio.buscarOfertaPorId(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @GetMapping
    public ResponseEntity<?> buscarTodasOfertas(){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ofertaServicio.buscarTodasOfertas());

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> borrarOferta(@PathVariable Integer id){
        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ofertaServicio.eliminarOferta(id));

        }catch(Exception error){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}
