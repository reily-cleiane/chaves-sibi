package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import model.Objeto;
import persistencia.ObjetoDao;

/**
 * @author cleiane
 */
public class ObjetoController {
       
    public String salvar(String tipo) throws SQLException, ParseException{
        Objeto obj = new Objeto();
        obj.setTipo(tipo.toLowerCase());
        return new ObjetoDao().salvar(obj);
        
    }
    
    public ArrayList tiposObj()throws SQLException{       
        ArrayList tipos = new ObjetoDao().tiposObj();       
        return tipos;
        
    }
    
    public void alterar(String old_id, String new_id,String descricao)throws SQLException, ParseException {
        Objeto new_objeto = new Objeto();
        new_objeto.setId(Short.parseShort(new_id));
        new_objeto.setTipo(descricao);
        
        new ObjetoDao().alterar(old_id, new_objeto);
        
    }

    
}
