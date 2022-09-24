/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.tudodebom.view;

import br.com.tudodebom.DAO.ClientesDAO;
import br.com.tudodebom.DAO.DetalhesComprasDAO;
import br.com.tudodebom.DAO.ProdutosDAO;
import br.com.tudodebom.controller.CompraController;
import br.com.tudodebom.model.Clientes;
import br.com.tudodebom.model.Compras;
import br.com.tudodebom.model.DetalhesCompras;
import br.com.tudodebom.model.Produto;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Walderney
 */
public class vendas extends javax.swing.JFrame {

    /**
     * Creates new form vendas
     */
    public vendas() {
        initComponents();
    }
    
    private ProdutoConsultaView consultaProduto;
    DefaultTableModel tabela;
    public MenuViews menuView; 
    private Produto produto;
    private Compras compras;
   
    
    
    ////FUNÇOES
    
    public void alteraQuantidade(){
        //Coloca dados da tela numa instancia de produto
        Produto produtoTela = new Produto();
        produtoTela.setNome_produto(txtProdutoNome.getText());
        produtoTela.setQtd_produto((Integer) jsProdutoQuantidade.getValue());
        produtoTela.setPreco(Double.parseDouble(txtProdutoValorUnitario.getText()));
        Double valorTotal = 0.0;
        
        //se quantidade for negativa ou maior que 999 altera o valor para 1
        if (produtoTela.getQtd_produto() <1 || produtoTela.getQtd_produto() >999){
            jsProdutoQuantidade.setValue(1);
            produtoTela.setQtd_produto(1);
        }
    }
     
    
    
    
    //VERIFICA A QUANTIDADE EM ESTOQUE
    public boolean verificaEstoque() {
        //Coloca dados da tela numa instancia de produto
        Produto produtoTela = new Produto();
        produtoTela.setNome_produto(txtProdutoNome.getText());
        produtoTela.setQtd_produto((Integer) jsProdutoQuantidade.getValue());
        produtoTela.setPreco(Double.parseDouble(txtProdutoValorUnitario.getText()));
        
        Integer quantidadeNaLista = 0;
        
        //pega toda a quantidade do produto ja inserida na lista
        for(int i = 0; i+1 <=tabelaVenda.getModel().getRowCount(); i++){
            //obtem o id dessa linha
            
            if(produto != null){
                if(Objects.equals(produto.getId_produto(), (Integer) tabelaVenda.getValueAt(i, 1))){
                    quantidadeNaLista += (Integer) tabelaVenda.getValueAt(i, 3);
                }
            }
        }
        
        //verifica se tem quantidade solicitada de produtos
        if(produto != null && produto.getId_produto() != null){
            //se a quantidade em estoque for menos que a quantidade solicitada
            if(produto.getQtd_produto()<(produtoTela.getQtd_produto()+quantidadeNaLista)){
                return false;
            }
        }
        return true;
    }
    
    //ATUALIZA O SUBTOTAL DA COMPRA
    public void atualizaSubtotal(){
        Double subtotal =0.0;
       
        //faz cálculo de subtotal da compra
        for(int i = 1; i <=tabelaVenda.getRowCount(); i++){
            subtotal += (Double) tabelaVenda.getValueAt(i-1, 5);   
        }
        
        //insere valor subtotal da compra na label
        txtSubtotal.setText(subtotal.toString());
    }
    public void limpaTelaVenda(){
        //Limpa todos os campos de produto
        txtProdutoNome.setText("Clique aqui para pesquisar o produto...");
        jsProdutoQuantidade.setValue(0);
        txtProdutoValorUnitario.setText("0");
        txtProdutoValorTotal.setText("0");
        
        //Limpa todos os campos de cliente
        txtCpf.setText("");
        txtClienteNomeInfo.setText("");
        txtClienteCpfInfo.setText("");
       
        txtClienteNumeroInfo.setText("");
        
        //Limpa todos os campos da venda
        cbDinheiro.setSelected(false);
        txtPagamentoDinheiro.setValue(0);
        txtPagamentoDinheiro.setEditable(false);
        txtSubtotal.setText("0");
                
        //Obtém a tabela para trabalhar nela
        tabela = (DefaultTableModel) tabelaVenda.getModel();
        
        //Limpa todas as linhas 
        tabela.setRowCount(0);
        
        
    }
    
     //VERIFICA SE O VALOR DO CARTÃO É MAIOR QUE SUBTOTAL DA COMPRA
    public boolean verificaValor(){
        Double subtotal =  Double.parseDouble(txtSubtotal.getText().replaceAll(",", "."));
        Double  valorCartao =  Double.parseDouble(txtPagamentoDinheiro.getText().replaceAll(",", "."));
        if (valorCartao>subtotal){
            return false;
        }
        return true;
    }
    
    
      private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {                                         
        //Muda a cor do cabecalho da tabela
        tabelaVenda.getTableHeader().setBackground(new Color(017, 128, 216));
        tabelaVenda.getTableHeader().setForeground(Color.white);
        
        //Muda a cor da fonte da tabela
        tabelaVenda.setForeground(Color.black);
        
        
       
        
        //coloca quantidade = 1 para quantidade de produto
        jsProdutoQuantidade.setValue(1);
       
    }       
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        btAdicionarItem = new javax.swing.JButton();
        btRemoverItem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbSubtotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtClienteNomeInfo = new javax.swing.JTextField();
        txtClienteNumeroInfo = new javax.swing.JTextField();
        txtClienteCpfInfo = new javax.swing.JTextField();
        btRegistrarVenda = new javax.swing.JButton();
        txtProdutoNome = new javax.swing.JTextField();
        jsProdutoQuantidade = new javax.swing.JSpinner();
        lbVendaClienteCpf = new javax.swing.JLabel();
        lbProdutoValorTotal = new javax.swing.JLabel();
        lbProdutoValorUnitario = new javax.swing.JLabel();
        lbProdutoQuantidade = new javax.swing.JLabel();
        txtProdutoValorUnitario = new javax.swing.JTextField();
        txtProdutoValorTotal = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cbDinheiro = new javax.swing.JCheckBox();
        txtPagamentoDinheiro = new javax.swing.JFormattedTextField();
        jbProduto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(585, 465));
        setMinimumSize(new java.awt.Dimension(585, 465));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id do Item", "id do Produto", "Nome", "Quantidade", "Valor unitário", "Valor total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVenda.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaVenda);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        btAdicionarItem.setBackground(new java.awt.Color(64, 166, 65));
        btAdicionarItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btAdicionarItem.setForeground(new java.awt.Color(255, 255, 255));
        btAdicionarItem.setText("ADD+ ITEM");
        btAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarItemActionPerformed(evt);
            }
        });

        btRemoverItem.setBackground(new java.awt.Color(198, 25, 25));
        btRemoverItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btRemoverItem.setForeground(new java.awt.Color(255, 255, 255));
        btRemoverItem.setText("REMOVER ITEM");
        btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(57, 138, 217));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENDAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel1.setBackground(new java.awt.Color(57, 138, 217));

        lbSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbSubtotal.setText("SUBTOTAL COMPRA:");

        txtSubtotal.setBackground(new java.awt.Color(57, 138, 217));
        txtSubtotal.setText("0");
        txtSubtotal.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSubtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSubtotal)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setText("Cliente");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtClienteNomeInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(txtClienteNumeroInfo)
                    .addComponent(txtClienteCpfInfo))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteNomeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteCpfInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtClienteNumeroInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btRegistrarVenda.setBackground(new java.awt.Color(64, 166, 65));
        btRegistrarVenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btRegistrarVenda.setText("CONFIRMAR");
        btRegistrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarVendaActionPerformed(evt);
            }
        });

        txtProdutoNome.setEditable(false);
        txtProdutoNome.setText("Clique aqui para pesquisar o produto...");
        txtProdutoNome.setMinimumSize(new java.awt.Dimension(14, 25));
        txtProdutoNome.setPreferredSize(new java.awt.Dimension(14, 25));
        txtProdutoNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProdutoNomeMouseClicked(evt);
            }
        });
        txtProdutoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoNomeActionPerformed(evt);
            }
        });

        jsProdutoQuantidade.setMinimumSize(new java.awt.Dimension(14, 25));
        jsProdutoQuantidade.setPreferredSize(new java.awt.Dimension(14, 25));
        jsProdutoQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsProdutoQuantidadeStateChanged(evt);
            }
        });
        jsProdutoQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jsProdutoQuantidadeFocusLost(evt);
            }
        });

        lbVendaClienteCpf.setText("CPF Cliente");

        lbProdutoValorTotal.setText("Valor Total");

        lbProdutoValorUnitario.setText("Valor unitario");

        lbProdutoQuantidade.setText("Quantidade");

        txtProdutoValorUnitario.setEditable(false);
        txtProdutoValorUnitario.setText("0");
        txtProdutoValorUnitario.setMinimumSize(new java.awt.Dimension(14, 25));
        txtProdutoValorUnitario.setPreferredSize(new java.awt.Dimension(14, 25));
        txtProdutoValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoValorUnitarioActionPerformed(evt);
            }
        });

        txtProdutoValorTotal.setEditable(false);
        txtProdutoValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoValorTotalActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        txtCpf.setMinimumSize(new java.awt.Dimension(4, 26));
        txtCpf.setPreferredSize(new java.awt.Dimension(47, 26));
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        jLabel4.setText("Pagamento em:");

        cbDinheiro.setBackground(new java.awt.Color(255, 255, 255));
        cbDinheiro.setForeground(new java.awt.Color(51, 51, 51));
        cbDinheiro.setText("Dinheiro");
        cbDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDinheiroActionPerformed(evt);
            }
        });

        txtPagamentoDinheiro.setEditable(false);
        txtPagamentoDinheiro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPagamentoDinheiro.setText("0");
        txtPagamentoDinheiro.setMaximumSize(new java.awt.Dimension(101, 24));
        txtPagamentoDinheiro.setMinimumSize(new java.awt.Dimension(101, 24));
        txtPagamentoDinheiro.setPreferredSize(new java.awt.Dimension(101, 24));
        txtPagamentoDinheiro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPagamentoDinheiroFocusLost(evt);
            }
        });

        jbProduto.setText("Produto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProdutoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jsProdutoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtProdutoValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbProdutoQuantidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbProdutoValorUnitario)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbProdutoValorTotal)
                                    .addComponent(txtProdutoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btAdicionarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRemoverItem, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btRegistrarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbVendaClienteCpf)
                            .addComponent(txtPagamentoDinheiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDinheiro)
                            .addComponent(jLabel4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbVendaClienteCpf)
                            .addComponent(lbProdutoValorTotal)
                            .addComponent(lbProdutoValorUnitario)
                            .addComponent(lbProdutoQuantidade))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsProdutoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdutoValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdutoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdicionarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(cbDinheiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPagamentoDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btRegistrarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarItemActionPerformed
        // TODO add your handling code here:
         //Obtém a tabela para trabalhar nela
        tabela = (DefaultTableModel) tabelaVenda.getModel();
        DetalhesCompras dc  =new DetalhesCompras();
        //se a quantidade solicitada for maior que valor em estoque
        if (verificaEstoque()){
            
            if (!txtProdutoNome.getText().equalsIgnoreCase("Clique aqui para pesquisar o produto...")) 
            {
                Integer idItem;

                //pega numero do ultimo item adicionado
                Integer ultimaLinha = tabelaVenda.getModel().getRowCount();
                if(ultimaLinha < 1){
                    idItem = 1;
                }
                else{
                    idItem = (Integer) tabelaVenda.getValueAt(ultimaLinha-1, 0);
                    idItem +=1;
                }

                //Cria array com valores do produto
                Object[] dadosTabela = new Object[6];
                //Cada dado na coluna correspondente
                dadosTabela[0] = idItem;
                dadosTabela[1] = produto.getId_produto();
                dadosTabela[2] = produto.getNome_produto();
                dadosTabela[3] = (Integer) jsProdutoQuantidade.getValue();
                dadosTabela[4] = produto.getPreco();
                dadosTabela[5] = Float.parseFloat(txtProdutoValorTotal.getText());

                //Adiciona a linha de dados na tabela
                tabela.addRow(dadosTabela);

                atualizaSubtotal();
            }
        }else{
            //informa usuario que nao tem quantidade suficiente em estoque 
            //para inserir na venda
            JOptionPane.showMessageDialog(rootPane, 
                "Usuário, a quantidade de produtos solicitadas não existem em estoque! \n"
                        + "A quantidade deste produto em estoque é "+produto.getQtd_produto()+".",
                "Atenção", 
                JOptionPane.INFORMATION_MESSAGE);
        }
     
    }//GEN-LAST:event_btAdicionarItemActionPerformed

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
     
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void btRegistrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarVendaActionPerformed
        // TODO add your handling code here:
           // TODO add your handling code here:
        compras = new Compras();
        Double valorTotal = 0.0;
        Double valorFaltante = 0.0;
        Double troco = 0.0;
        String respostaController = null;
        String respostaController2 = null;
        String respostaController3 = null;
        ProdutosDAO dao = new ProdutosDAO();
    
        
        //se compra não tiver itens
        if(tabelaVenda.getModel().getRowCount()<1){
            JOptionPane.showMessageDialog(rootPane,
                "Você precisa adicionar itens no carrinho!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            //sai do método 
            return;
        }
        
        //se não foi selecionada uma forma de pagamento
        if(!cbDinheiro.isSelected()){
           JOptionPane.showMessageDialog(rootPane,
                 "Você deve selecionar uma forma de pagamento!",
                 "Atenção",
                 JOptionPane.ERROR_MESSAGE);
             //sai do método 
             return;
        }
       /* 
        //se não houver cliente na venda
        if(!Validacao.vendaCliente(txtClienteNomeInfo.getText(), txtClienteCpfInfo.getText(),
                txtClienteCidadeInfo.getText(), txtClienteLogradouroInfo.getText(), 
                txtClienteNumeroInfo.getText())){
        */    
            //avisa que não existe cliente para registrar junto a venda
            int respostaConfirmacao = JOptionPane.showConfirmDialog(
                    rootPane,
                    "Não existe cliente na venda.\n\n"
                            + "Deseja continuar?",
                    "Confirmação", 
                    JOptionPane.YES_NO_OPTION);

            //se resposa for não para continuar o registro da venda
            if (respostaConfirmacao == JOptionPane.NO_OPTION) 
            {
                //sai do método 
                return;
            }
        
        
        //se o valor do cartao for maior que o subtotal
        if(!verificaValor()){
            JOptionPane.showMessageDialog(rootPane,
                "O Valor de pagamento em cartão não pode ser maior que o subtotal da venda!",
                "Atencão",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
      
        compras.setSubtotal(Double.parseDouble(txtSubtotal.getText()));
        compras.setPagamento(Double.parseDouble(txtPagamentoDinheiro.getText().replaceAll(",", ".")));
        
        //coloca cada item da venda na lista de itens da venda da instancia de venda
        for(int i = 0; i+1 <=tabelaVenda.getModel().getRowCount(); i++){
            //obtem o id dessa linha
            DetalhesCompras itemVenda = new  DetalhesCompras();
            itemVenda.setIdVenda(compras.getIdCompra());
            itemVenda.setIdItem((Integer) tabelaVenda.getValueAt(i, 0));
            itemVenda.setId_produto((Integer) tabelaVenda.getValueAt(i, 1));
            itemVenda.setNome_produto((String) tabelaVenda.getValueAt(i, 2)); 
            itemVenda.setQtd_produto((Integer) tabelaVenda.getValueAt(i, 3));
            itemVenda.setPreco((Double) tabelaVenda.getValueAt(i, 4));
            itemVenda.setValorTotal(itemVenda.getQtd_produto()*itemVenda.getPreco());
            compras.adicionarItem(itemVenda);
        }
        compras.getClientes().setNomeCliente(txtClienteNomeInfo.getText());
        compras.getClientes().setCpf(txtClienteCpfInfo.getText());
        compras.getClientes().setTelefone(txtClienteNumeroInfo.getText());
         //se o valor pago for maior ou igual que o subtotal da compra
        if(compras.getPagamento() >= compras.getSubtotal()){

            //envia venda para salvar para o controller
            respostaController = CompraController.inserir(compras);
            
            //se a resposta for positiva salva os itens da venda
           
             }
      
    }//GEN-LAST:event_btRegistrarVendaActionPerformed

    private void txtProdutoNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProdutoNomeMouseClicked

        //verifica se a tela ja existe
        if(consultaProduto == null )
        {
            //se não existir faz uma tela
            consultaProduto = new ProdutoConsultaView();

            //Centraliza o jInternalFrame no painel principal
            consultaProduto.setLocation(170, 100);
        }

        //verifico se a tela ja esta no painel
        if(!consultaProduto.isVisible())
        {
            //mostro a tela no painel principal caso nao esteja la
           //menuView.getDskPainelPrincipal().add(consultaProduto);//ESTAAAAA DANDO ERRRRROOOOOOO VER COM PROFESSOR
            consultaProduto.setVisible(true);
        }

        //coloco ela na frente de todas para todos os casos
        consultaProduto.toFront();

        //retira o painel superior
        //((BasicInternalFrameUI)consultaProduto.getUI()).setNorthPane(null);
    }//GEN-LAST:event_txtProdutoNomeMouseClicked

    private void txtProdutoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoNomeActionPerformed

    private void jsProdutoQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsProdutoQuantidadeStateChanged
        alteraQuantidade();
    }//GEN-LAST:event_jsProdutoQuantidadeStateChanged

    private void jsProdutoQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jsProdutoQuantidadeFocusLost
        alteraQuantidade();
    }//GEN-LAST:event_jsProdutoQuantidadeFocusLost

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost

        //chama o controller para obter o cliente do id selecionado (nova instancia de cliente)
        Clientes cliente = new Clientes();
        ClientesDAO clienteDAO = new ClientesDAO();
         cliente= clienteDAO.buscarPeloCpf(txtCpf.getText());
           //se cliente foi encontrado
        if(cliente != null)
        {
            //limpa os campos de cliente
            txtClienteNomeInfo.setText(cliente.getNomeCliente());
            txtClienteCpfInfo.setText(cliente.getCpf());
            txtClienteNumeroInfo.setText(cliente.getTelefone());

        }
        else
        {
            //informa ao usuário que não foi possível encontrar o cliente para edição
            JOptionPane.showMessageDialog(rootPane,
                "O Cliente não foi encontrado! \n\n"
                + "Para cadastrar o Cliente vá para Menu > Cadastrar Cliente.",
                "Não encontrado",
                JOptionPane.INFORMATION_MESSAGE);

            //limpa os campos de cliente
            txtClienteNomeInfo.setText("");
            txtClienteCpfInfo.setText("");
            txtClienteNumeroInfo.setText("");
        }

    }//GEN-LAST:event_txtCpfFocusLost

    private void cbDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDinheiroActionPerformed
        if(cbDinheiro.isSelected()){
            txtPagamentoDinheiro.setEditable(true);
        }
        else{
            txtPagamentoDinheiro.setEditable(false);
        }
        txtPagamentoDinheiro.setValue(0);
    }//GEN-LAST:event_cbDinheiroActionPerformed

    private void txtPagamentoDinheiroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPagamentoDinheiroFocusLost
        if (txtPagamentoDinheiro.getText().length()>10){
            txtPagamentoDinheiro.setValue(0);
        }
    }//GEN-LAST:event_txtPagamentoDinheiroFocusLost

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formComponentShown

    private void txtProdutoValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoValorTotalActionPerformed
        // TODO add your handling code here:
         alteraQuantidade();
    }//GEN-LAST:event_txtProdutoValorTotalActionPerformed

    private void txtProdutoValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoValorUnitarioActionPerformed
        // TODO add your handling code here:
          alteraQuantidade();
    }//GEN-LAST:event_txtProdutoValorUnitarioActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new vendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarItem;
    private javax.swing.JButton btRegistrarVenda;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JCheckBox cbDinheiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbProduto;
    private javax.swing.JSpinner jsProdutoQuantidade;
    private javax.swing.JLabel lbProdutoQuantidade;
    private javax.swing.JLabel lbProdutoValorTotal;
    private javax.swing.JLabel lbProdutoValorUnitario;
    private javax.swing.JLabel lbSubtotal;
    private javax.swing.JLabel lbVendaClienteCpf;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.JTextField txtClienteCpfInfo;
    private javax.swing.JTextField txtClienteNomeInfo;
    private javax.swing.JTextField txtClienteNumeroInfo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtPagamentoDinheiro;
    private javax.swing.JTextField txtProdutoNome;
    private javax.swing.JTextField txtProdutoValorTotal;
    private javax.swing.JTextField txtProdutoValorUnitario;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables

    

   
}
