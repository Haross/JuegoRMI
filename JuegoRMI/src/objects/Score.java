/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;


public class Score implements Serializable {
   
    private long idU;
    
    private String usuario;
   
    private long score;

    public Score(String usuario, long score) {
        this.usuario = usuario;
        this.score = score;
    }
    
    public Long getId() {
        return idU;
    }

    public void setId(long id) {
        this.idU = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    
    
    
}
