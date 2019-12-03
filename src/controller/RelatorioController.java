package controller;
import view.RelatorioMes;
import view.RelatorioEmpAtivo;
import java.sql.SQLException;
import java.text.ParseException;
//Java 8. Não é compatível com 7
//import java.time.LocalDate;
import persistencia.RelatorioDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        
        // JAVA 8, não é compatível em java 7
        //LocalDate dataano = LocalDate.now();
        //String ano = Integer.toString(dataano.getYear()); 
        
        Calendar cal = GregorianCalendar.getInstance();
        String ano = Integer.toString(cal.get(Calendar.YEAR));
        
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
