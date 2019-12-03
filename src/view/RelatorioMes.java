
package view;

import controller.RelatorioController;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//Incompatível com java 7
//import java.time.LocalDate;
//import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class RelatorioMes extends javax.swing.JFrame {
    
    private String matricula;
    private String nome;
    private String objeto;
    private String dataemp;
    private String datadev;

    public RelatorioMes(String matricula, String nome, String objeto, String dataemp, String datadev) {
        this.matricula = matricula;
        this.nome = nome;
        this.objeto = objeto;
        this.dataemp = dataemp;
        this.datadev = datadev;
    }
    
    public RelatorioMes(String matricula, String nome, String objeto, String dataemp) {
        this.matricula = matricula;
        this.nome = nome;
        this.objeto = objeto;
        this.dataemp = dataemp;
        this.datadev = "";
    }
    
    /*LocalDate dia = LocalDate.now();
    String d = dia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());*/
    //DefaultTableModel modelo = new DefaultTableModel();


    public RelatorioMes() {
        initComponents();
        
        //DefaultTableModel modelo = new DefaultTableModel();
        DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(300);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(300);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cabecalho = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        Relatorios = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cabecalho.setBackground(new java.awt.Color(255, 255, 255));

        logo.setFont(new java.awt.Font("Eras Medium ITC", 0, 22)); // NOI18N
        logo.setForeground(new java.awt.Color(153, 0, 0));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo2.png"))); // NOI18N

        Relatorios.setFont(new java.awt.Font("Corbel", 1, 36)); // NOI18N
        Relatorios.setForeground(new java.awt.Color(153, 0, 0));
        Relatorios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Relatorios.setText("Relatórios");

        javax.swing.GroupLayout cabecalhoLayout = new javax.swing.GroupLayout(cabecalho);
        cabecalho.setLayout(cabecalhoLayout);
        cabecalhoLayout.setHorizontalGroup(
            cabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(Relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        cabecalhoLayout.setVerticalGroup(
            cabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Relatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(new javax.swing.border.MatteBorder(null));

        tabela.setFont(tabela.getFont().deriveFont(tabela.getFont().getSize()+1f));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "Chave", "Data de empréstimo", "Data de devolução"
            }
        ));
        tabela.setCellSelectionEnabled(true);
        tabela.setGridColor(new java.awt.Color(255, 255, 255));
        tabela.setIntercellSpacing(new java.awt.Dimension(2, 3));
        tabela.setMinimumSize(new java.awt.Dimension(50, 0));
        tabela.setOpaque(false);
        tabela.setRowHeight(30);
        jScrollPane3.setViewportView(tabela);

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório - Mês");

        total.setFont(total.getFont().deriveFont(total.getFont().getStyle() | java.awt.Font.BOLD, total.getFont().getSize()+3));
        total.setText("Empréstimos efetuados: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Relatorios;
    private javax.swing.JPanel cabecalho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    public void relatorioMesAtual(){
        
        try {
            ArrayList<RelatorioMes> lista = new RelatorioController().relatorioMesAtual();
            preencherTabela(lista);   
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(RelatorioMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Calendar cal = GregorianCalendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("America/Recife");
	TimeZone.setDefault(tz);
        cal.setTimeZone(tz);
        
        DateFormat dtf = new SimpleDateFormat ("MMMMM", new Locale ("pt", "BR"));
        String d = dtf.format (1);
                
        //Incompatível com java 7
        //LocalDate dia = LocalDate.now();
        //String d = dia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        jLabel1.setText("Relatório - "+ d);

    }
    
    public void relatorioMesAnterior(){
        
        Calendar cal = GregorianCalendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone("America/Recife");
	TimeZone.setDefault(tz);
        cal.setTimeZone(tz);
        
        cal.add(Calendar.MONTH, -1);
        
        DateFormat dtf = new SimpleDateFormat ("MMMMM", new Locale ("pt", "BR"));
        String d = dtf.format(cal.getTime());
               
        //Incompatível com java 7
        //LocalDate dia = LocalDate.now();       
        //dia = dia.plusMonths(-1);
        //String d = dia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        jLabel1.setText("Relatório - "+ d);
        
        try{
            
            ArrayList<RelatorioMes> lista = new RelatorioController().relatorioMesAnterior();
            if(lista == null){
                System.out.println("lista nula");
            } else{
                preencherTabela(lista);
                
            }
            
        }catch (SQLException e){
            System.out.println("Não há empréstimos no mês anterior");
            
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioMes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void relatorioMes(int nummes, String nomemes){
   
        jLabel1.setText("Relatório - "+nomemes);
        
        try{
            
            ArrayList<RelatorioMes> lista = new RelatorioController().relatorioMesNumero(nummes);
            preencherTabela(lista);
                      
        }catch (SQLException e){
            System.out.println("Não há empréstimos no mês anterior");
            
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioMes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    public void relatorioPeriodo(String di, String df, String dfLabel){

        String pi = di.substring(8,10)+"-"+di.substring(5,8)+di.substring(0,4);
        String pf = dfLabel.substring(8,10)+"-"+dfLabel.substring(5,8)+dfLabel.substring(0,4);
        pi = pi.replaceAll("-", "/");
        pf = pf.replaceAll("-", "/");
        jLabel1.setText("Relatório - Período: "+ pi + " à " + pf);
        
        try{
            
            ArrayList<RelatorioMes> lista = new RelatorioController().relatorioPeriodo(di, df);

            preencherTabela(lista);
                      
        }catch (SQLException e){
            System.out.println("Não há empréstimos no mês anterior");
            
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioMes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        
  
    private void preencherTabela(ArrayList<RelatorioMes> lista){
        int i = 0;
       
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel)tabela.getModel();
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(300);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(300);
        
        for(RelatorioMes rel : lista){
            modelo.addRow(new Object[]{null,null,null,null,null});
            modelo.setValueAt(rel.getMatricula(), i, 0);
            modelo.setValueAt(rel.getNome(), i, 1);
            modelo.setValueAt(rel.getObjeto(), i, 2);
            modelo.setValueAt(rel.getDataemp(), i, 3);
            modelo.setValueAt(rel.getDatadev(), i, 4);
            i++;
        }
        total.setText("Empréstimos efetuados: " +i);
                      
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDataemp() {
        
        String data = dataemp.replaceAll("-", "/");
        String[] datahora = data.split(" ");
        String hora = datahora[1];
        String[] dataf = datahora[0].split("/");       
        dataemp = dataf[2]+"/"+dataf[1]+"/"+dataf[0]+" "+hora;
        
        return dataemp;
    }

    public void setDataemp(String dataemp) {
        this.dataemp = dataemp;
    }

    public String getDatadev() { 
        if(datadev!=""){
            String data = datadev.replaceAll("-", "/");
            String[] datahora = data.split(" ");
            String hora = datahora[1];
            String[] dataf = datahora[0].split("/");       
            datadev = dataf[2]+"/"+dataf[1]+"/"+dataf[0]+" "+hora;

        }
        return datadev;
        
    }

    public void setDatadev(String datadev) {
        this.datadev = datadev;
    }
    
}  
