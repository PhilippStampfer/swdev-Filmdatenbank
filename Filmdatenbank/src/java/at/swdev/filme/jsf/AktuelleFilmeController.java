/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.swdev.filme.jsf;

import at.swdev.filme.Filme;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TypedQuery;

/**
 *
 * @author Stefan Wiederhofer
 */
@Named(value = "aktuelleFilmeController")
@SessionScoped
public class AktuelleFilmeController implements Serializable {
    @EJB
    private at.swdev.filme.controller.FilmeFacade ejbFacade;
    
    /**
     * Creates a new instance of AktuelleFilmeController
     */
    public AktuelleFilmeController() {
    }
    
    EntityManager em = ejbFacade.getEntityManager();
    
    
    
    public List<Filme> getAktuelleFilme() {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
            
            int jahrAktuell = Integer.parseInt(ldt.format(dtf));
    
            TypedQuery<Filme> query =  em.createQuery("SELECT f.name, f.regisseure.nachname, f.regisseure.vorname, f.schauspieler.vorname FROM Filme f WHERE f.jahr = " + jahrAktuell, 
                                                    Filme.class);
            return query.getResultList();
    }
}
