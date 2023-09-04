package com.example.TurismoaApplication.servicios;

import com.example.TurismoaApplication.modelos.Oferta;
import com.example.TurismoaApplication.repositorios.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OfertaServicio {
    @Autowired
    OfertaRepositorio ofertaRepositorio;
    public Oferta registrarOferta(Oferta datosARegistrar)throws Exception {
        try {

            Oferta prueba=this.ofertaRepositorio.save(datosARegistrar);
            System.out.println(prueba);
            return(prueba);

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Oferta modificarOferta(Integer id, Oferta datosAModificar) throws Exception{
        try {
            Optional<Oferta> ofertaEncontrada = this.ofertaRepositorio.findById(id);
            if(ofertaEncontrada.isEmpty()){
                throw new Exception("Oferta no encontrada");
            }
            Oferta ofertaQueExiste = ofertaEncontrada.get();

            ofertaQueExiste.setTitulo(datosAModificar.getTitulo());
            ofertaQueExiste.setDescripcion(datosAModificar.getDescripcion());

            return(this.ofertaRepositorio.save(ofertaQueExiste));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Oferta buscarOfertaPorId(Integer id) throws Exception{
        Optional<Oferta> ofertaEncontradaPorId = this.ofertaRepositorio.findById(id);

        if(ofertaEncontradaPorId.isEmpty()){
            throw new Exception("Oferta no encontrada");
        }

        return ofertaEncontradaPorId.get();
    }

    public List<Oferta> buscarTodasOfertas() throws Exception{
        try {
            List<Oferta>listaOferta = this.ofertaRepositorio.findAll();
            return listaOferta;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Boolean eliminarOferta(Integer id) throws Exception{
        try{
            Optional<Oferta> ofertaOpcional = this.ofertaRepositorio.findById(id);
            if (ofertaOpcional.isPresent()){
                this.ofertaRepositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Oferta no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
