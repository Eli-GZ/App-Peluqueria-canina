package com.mycompany.app.peluqueria.logica;

import com.mycompany.app.peluqueria.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        //CREAMOS DUEÑO Y ASIGNAMOS VALORES
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        //CREAMOS MASCOTA Y ASIGNAMOS VALORES
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);

        controlPersis.guardar(duenio, masco);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();

    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);

        //MODIFICO LA MASCOTA
        controlPersis.modificarMascota(masco);

        //SETEO NUEVO VALORES DEL DUEÑO
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setNombre(nombreDuenio);
        dueno.setCelDuenio(celDuenio);

        //LLAMAR AL MODIFICAR DUEÑO
        this.modificarDuenio(dueno);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
}
