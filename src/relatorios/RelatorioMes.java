
package relatorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;


public class RelatorioMes extends javax.swing.JFrame {
    LocalDate dia = LocalDate.now();
    String d = dia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
    DefaultTableModel modelo = new DefaultTableModel();


    public RelatorioMes() {
        initComponents();
        
        modelo = (DefaultTableModel)tabela.getModel();
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
        setPreferredSize(new java.awt.Dimension(700, 740));

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

    public void relatorioMesAtual(Connection conn){

        String sql = "select alunos.matricula, alunos.nome, emprestimos.emp_chave, emprestimos.dataemp, emprestimos.datadev from alunos"
                + " INNER JOIN emprestimos on (alunos.matricula = emp_aluno)"
                + " WHERE dataemp <= (datetime('now'))"
                + " AND dataemp >= (strftime('%Y', 'now') || '-' || strftime('%m', 'now')) ORDER BY dataemp;";
                
        LocalDate dia = LocalDate.now();
        String d = dia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        jLabel1.setText("Relatório - "+ d);
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            preencherTabela(rs);
            pst.close();
            rs.close();
            conn.close();
                       
        }catch (SQLException e){
            System.out.println("Não há empréstimos ativos");
            
        }
    }
    
    public void relatorioMesAnterior(Connection conn){
       
        String sql = "select alunos.matricula, alunos.nome, emprestimos.emp_chave, emprestimos.dataemp, emprestimos.datadev from alunos"
                + " INNER JOIN emprestimos on (alunos.matricula = emp_aluno)"
                + " WHERE dataemp >= (strftime('%Y-%m', 'now', '-1 month'))"
                + " AND dataemp < date('now', 'start of month') ORDER BY dataemp;";
        
        LocalDate dia = LocalDate.now();       
        dia = dia.plusMonths(-1);
        String d = dia.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        jLabel1.setText("Relatório - "+ d);
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            preencherTabela(rs);
                     
            pst.close();
            rs.close();
            conn.close();
                       
        }catch (SQLException e){
            System.out.println("Não há empréstimos no mês anterior");
            
        }
    }
    
    public void relatorioMes(Connection conn, int nummes, String nomemes){
   
        String sql = "select alunos.matricula, alunos.nome, emprestimos.emp_chave, emprestimos.dataemp, emprestimos.datadev from alunos"
                + " INNER JOIN emprestimos on (alunos.matricula = emp_aluno)"
                + " WHERE dataemp >= ?"
                + " AND dataemp < ? ORDER BY dataemp";
        

        jLabel1.setText("Relatório - "+nomemes);
        
        LocalDate dataano = LocalDate.now();
        String ano = Integer.toString(dataano.getYear()); 
        
        String nm = numMes(nummes);
        String fm = numMes(nummes+1);
               
        nm = ano+"-"+nm;
        fm = ano+"-"+fm;
          
        try{            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nm);
            pst.setString(2, fm);
            ResultSet rs = pst.executeQuery();
            
            preencherTabela(rs);
                     
            pst.close();
            rs.close();
            conn.close();
                       
        }catch (SQLException e){
            System.out.println("Não há empréstimos no mês especificado");
            
        }
    }
    
        
    public void relatorioPeriodo(Connection conn, String di, String df){

        String sql = "select alunos.matricula, alunos.nome, emprestimos.emp_chave, emprestimos.dataemp, emprestimos.datadev from alunos"
                + " INNER JOIN emprestimos on (alunos.matricula = emp_aluno)"
                + " WHERE dataemp >= ? "
                + " AND dataemp < ? ORDER BY dataemp";
               
        String pi = di.substring(8,10)+"-"+di.substring(5,8)+di.substring(0,4);
        String pf = df.substring(8,10)+"-"+df.substring(5,8)+df.substring(0,4);
        jLabel1.setText("Relatório - Período: "+ pi + " à " + pf);
        
        try{
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, di);
            pst.setString(2, df);
            ResultSet rs = pst.executeQuery();
            
            preencherTabela(rs);
                     
            pst.close();
            rs.close();
            conn.close();
                       
        }catch (SQLException e){
            System.out.println("Não há empréstimos ativos");
            
        }
    }
        
    
    private void preencherTabela(ResultSet rs){
        int i = 0;
        try{
            while(rs.next()){
            modelo.addRow(new Object[]{null,null,null,null});
            modelo.setValueAt(rs.getString(1), i, 0);
            modelo.setValueAt(rs.getString(2), i, 1);
            modelo.setValueAt(rs.getString(3), i, 2);
            modelo.setValueAt(rs.getString(4), i, 3);
            modelo.setValueAt(rs.getString(5), i, 4);
            i++;
            }           
        }catch(SQLException e){
            System.out.println("Ocorreu um erro ao preencher a tabela");
        }
        total.setText("Empréstimos efetuados: " +i);
                      
    }

    private String numMes(int nummes) {
        String mes = Integer.toString(nummes);
        if(nummes <= 9)
            mes = "0"+mes;
        return mes;
                
    }
    
}  
