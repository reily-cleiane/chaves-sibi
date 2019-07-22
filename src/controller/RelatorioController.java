package controller;
import view.RelatorioMes;
import view.RelatorioEmpAtivo;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import persistencia.RelatorioDao;
import java.util.ArrayList;

/**
 * @author cleiane
 */
public class RelatorioController {
    
    public ArrayList<RelatorioEmpAtivo> relatorioEmpAtivo() throws SQLException, ParseException {                 
        ArrayList<RelatorioEmpAtivo> relatorio = new RelatorioDao().exibirEmpAtivo();            
        return relatorio;
            
    }
    
    public ArrayList<RelatorioMes> relatorioMesAtual()throws SQLException, ParseException {
               
        ArrayList<RelatorioMes> relatorio = new RelatorioDao().exibirMes("atual");            
        return relatorio;        
    }
    
    public ArrayList<RelatorioMes> relatorioMesAnterior()throws SQLException, ParseException {
               
        ArrayList<RelatorioMes> relatorio = new RelatorioDao().exibirMes("anterior"); 
        return relatorio;        
    }
    
    public ArrayList<RelatorioMes> relatorioMesNumero(int nummes)throws SQLException, ParseException {
        
        LocalDate dataano = LocalDate.now();
        String ano = Integer.toString(dataano.getYear()); 
        
        String nm = numMes(nummes);
        String fm = numMes(nummes+1);
               
        nm = ano+"-"+nm;
        fm = ano+"-"+fm;
                
        ArrayList<RelatorioMes> relatorio = new RelatorioDao().exibirPeriodo(nm,fm);            
        return relatorio;        
    } 
    
    public ArrayList<RelatorioMes> relatorioPeriodo(String pi, String pf) 
		throws SQLException, ParseException {
                  
        ArrayList<RelatorioMes> relatorio = new RelatorioDao().exibirPeriodo(pi,pf);
        System.out.println("PI e PF"+ pi + pf);
        return relatorio; 
            
    }  
    
    private String numMes(int nummes) {
        String mes = Integer.toString(nummes);
        if(nummes <= 9)
            mes = "0"+mes;
        return mes;              
    }

}
