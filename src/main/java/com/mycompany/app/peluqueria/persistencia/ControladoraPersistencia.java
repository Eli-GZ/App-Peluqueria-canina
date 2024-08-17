package com.mycompany.app.peluqueria.persistencia;

import com.mycompany.app.peluqueria.logica.Duenio;
import com.mycompany.app.peluqueria.logica.Mascota;
import com.mycompany.app.peluqueria.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascoJpa = new MascotaJpaController();
    
    public void guardar(Duenio duenio, Mascota masco) {
//CREAR EN LA BD EL DUEÑO
        duenioJpa.create(duenio);
        //CREAR EN LA BD LA MASCOTA     
        mascoJpa.create(masco);
    }
    
    public List<Mascota> traerMascotas() {
        
        return mascoJpa.findMascotaEntities();
    }
    
    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Mascota traerMascota(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }
    
    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }
    
    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
