package view;

import controller.RelatorioController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RelatorioEmpAtivo extends javax.swing.JFrame {
    private String matricula;
    private String nome;
    private String objeto;
    private String dataemp;

    public RelatorioEmpAtivo() {
        initComponents();

        try {
            ArrayList<RelatorioEmpAtivo> lista = new RelatorioController().relatorioEmpAtivo();
            DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
            tabela.setModel(modelo);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(90);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(300);
            int i = 0;

            for(RelatorioEmpAtivo rel : lista){
                modelo.addRow(new Object[]{null,null,null,null});
                modelo.setValueAt(rel.getMatricula(), i, 0);
                modelo.setValueAt(rel.getNome(), i, 1);
                modelo.setValueAt(rel.getObjeto(), i, 2);
                modelo.setValueAt(rel.getDataemp(), i, 3);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioEmpAtivo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro na view relatorio emp ativo");
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioEmpAtivo.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    public RelatorioEmpAtivo(String matricula, String nome, String objeto, String dataemp) {
        this.matricula = matricula;
        this.nome = nome;
        this.objeto = objeto;
        this.dataemp = dataemp;
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
                "Matrícula", "Nome", "Chave", "Data de empréstimo"
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
        jLabel1.setText("Relatório - Empréstimos ativos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addGap(17, 17, 17))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    // End of variables declaration//GEN-END:variables

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
        /*String data = dataemp.replaceAll("-", "/");
        String[] s = data.split("/");
        String novaData = s[2]+"/"+s[1]+"/"+s[0];*/
        this.dataemp = dataemp;
    }
    
}  
