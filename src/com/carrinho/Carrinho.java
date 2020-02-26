package com.carrinho;


import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import com.venda.Venda;

import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Grid;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class Carrinho extends totalcross.ui.Window{
	
	private Label							lblCarrinho;
	private ArtButton 						btnVoltar;
	private ArtButton						btnVender;
	public Grid							    gridCarrinho;
	public Button					        btnCarrinho;
	
	public int 					 			quantidadeEstoque = 0;
	public int 						        qntEstoqueCalculo = 0;
	public int  				 			quantidadeVendida = 0;
	public int								codigo = 0;
	public int								codigoProdTemp = 0;
	public int 								codigoTemp;
	public Date 				 			dataEntrada;
	public String							dataString;
	public String							dataSaidaString;
	
	public String							produtoTemp;
	public String							valorTemp;
	public String							categoriaTemp;
	public String							marcaTemp;
	public String                           descricaoTemp;
	public String							tipoPagamento;
	public Date								dataSaidaTemp;
	public int   							quantidadeTemp;
	
	public Carrinho(){
		 setBackColor(0x003366);
		 initUI();
	}
	
	public void initUI() {
		
		try {
					
			lblCarrinho = new Label("CARRINHO:");
			add(lblCarrinho);
			lblCarrinho.setRect(CENTER, TOP + 5, PREFERRED, PREFERRED);
			lblCarrinho.setBackColor(0x003366);
			lblCarrinho.setForeColor(Color.WHITE);
			
			btnCarrinho = BottomImg.imageOnly(new Image("img/carrinho.png"));
			add(btnCarrinho, AFTER + 2, TOP, SCREENSIZE + 16, PREFERRED, lblCarrinho);
			
			btnVoltar = new ArtButton("VOLTAR");
            add(btnVoltar);
            btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
            btnVoltar.setBackColor(0x003366);
            btnVoltar.setForeColor(Color.WHITE);
            
            btnVender = new ArtButton("VENDER");
            add(btnVender);
            btnVender.setRect(LEFT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
            btnVender.setBackColor(0x009933);
            btnVender.setForeColor(Color.WHITE);

            int gridWidths[] = new int[9];
				gridWidths[0] = 10;
				gridWidths[1] = 50;
				gridWidths[2] = 10;
				gridWidths[3] = 50;
				gridWidths[4] = 10;
				gridWidths[5] = 50;
				gridWidths[6] = 20;
				gridWidths[7] = 50;
				gridWidths[8] = 20;
	
			String[] caps = { "COD.", "PRODUTO", "QNT", "COD.PROD.", "MARCA", "CAT.","DESC.", "PAG.", " TOTAL"};
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT};
			gridCarrinho = new Grid(caps, gridWidths, aligns, false);
			add(gridCarrinho);
			gridCarrinho.setBackColor(Color.WHITE);
			gridCarrinho.setForeColor(0x003366);
			gridCarrinho.transparentBackground = false;
			gridCarrinho.drawCheckBox = true;
			gridCarrinho.disableSort = false;
			gridCarrinho.canClickSelectAll = true;
			gridCarrinho.boldCheck = false;
			gridCarrinho.setRect(Container.LEFT + 1, Container.AFTER + 10,
					Container.FILL - 1, Container.FIT, btnCarrinho);
			
			reposition();
			
            carregaGridProdutos();

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE","Erro ao carregar a Tela");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();

		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnVender) {

					baixaEstoque();
					salvaInfoVenda();
					
					MessageBox msg = new MessageBox("CONTROLE", "Venda efetuada\n com sucesso");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();
					
					Venda.btnCarrinho.setEnabled(false);
					unpop();
				}

			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void carregaGridProdutos() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				lb = new LitebasePack();
				sql = " SELECT * FROM VENDAPRODUTOTEMP";
				
				gridCarrinho.removeAllElements();
				rs = lb.executeQuery(sql);
				rs.first();
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[9];
					b[0] = Convert.toString(rs.getInt("CODIGO"));
					b[1] = rs.getString("PRODUTO");
					b[2] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[3] = Convert.toString(rs.getInt("CODIGOPROD"));
					b[4] = rs.getString("MARCA");
					b[5] = rs.getString("CATEGORIA");
					b[6] = rs.getString("DESCRICAO");
					b[7] = rs.getString("TIPOPAGAMENTO");
					b[8] = rs.getString("VALOR");
					gridCarrinho.add(b);
					rs.next();
				}
			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento" + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();

		}

	}
	
	public void baixaEstoque() {
		String sql 			= "";
		LitebasePack lb     = null;
		ResultSet rs 		= null;
		
		String sql2 		= "";
		ResultSet rs2 		= null;
		LitebasePack lb2 	= null;

		try {

			try {
				lb = new LitebasePack();
				
				sql = "SELECT * FROM VENDAPRODUTOTEMP";
				
				rs = lb.executeQuery(sql);
				rs.beforeFirst();
				
				while (rs.next()) {
					codigoTemp = rs.getInt("CODIGO");
					produtoTemp = rs.getString("PRODUTO");
					valorTemp = rs.getString("VALOR");
					codigoProdTemp = rs.getInt("CODIGOPROD");
					quantidadeTemp = rs.getInt("QUANTIDADE");
					categoriaTemp = rs.getString("CATEGORIA");
					marcaTemp = rs.getString("MARCA");
					descricaoTemp = rs.getString("DESCRICAO");
					tipoPagamento = rs.getString("TIPOPAGAMENTO");
					dataSaidaTemp = rs.getDate("DATASAIDA");
					
					lb2 = new LitebasePack();
					sql2 = " SELECT QUANTIDADE, CODIGO, DATAENTRADA FROM ESTOQUE ";

					rs2 = lb2.executeQuery(sql2);
					rs2.first();
					
					qntEstoqueCalculo = rs2.getInt("QUANTIDADE");
					dataEntrada = rs2.getDate("DATAENTRADA");
					
					dataString = dataEntrada.toString(Settings.DATE_YMD);
									
					codigo = rs2.getInt("CODIGO");
					quantidadeVendida = quantidadeTemp;

					quantidadeEstoque = qntEstoqueCalculo - quantidadeVendida;

					sql = "DELETE FROM ESTOQUE WHERE CODIGO = " + codigoProdTemp;

					lb.executeUpdate(sql);

					sql = "INSERT INTO 	ESTOQUE " + "(" + " CODIGO, PRODUTO, MARCA, VALOR, QUANTIDADE, "
							+ " CATEGORIA, MARCA, DESCRICAO, DATAENTRADA " + ")" + " VALUES " + "( '" + codigoProdTemp
							+ "' , '" + produtoTemp + "', '" + marcaTemp + "', '" + valorTemp + "', '"
							+ quantidadeEstoque + "', '" + categoriaTemp + "','" + marcaTemp + "', '" + descricaoTemp
							+ "', '" + dataString + "'" + ")";

					lb.executeUpdate(sql);

				}
				
			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao dar\n baixa no estoque");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}
	}
	
	public void salvaInfoVenda() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				
				sql = "SELECT * FROM VENDAPRODUTOTEMP WHERE CODIGO = " + codigoTemp;
				
				rs = lb.executeQuery(sql);
				rs.beforeFirst();
				
				while (rs.next()) {
					codigoTemp = rs.getInt("CODIGO");
					produtoTemp = rs.getString("PRODUTO");
					valorTemp = rs.getString("VALOR");
					codigoProdTemp = rs.getInt("CODIGOPROD");
					quantidadeTemp = rs.getInt("QUANTIDADE");
					categoriaTemp = rs.getString("CATEGORIA");
					marcaTemp = rs.getString("MARCA");
					descricaoTemp = rs.getString("DESCRICAO");
					tipoPagamento = rs.getString("TIPOPAGAMENTO");
					dataSaidaTemp = rs.getDate("DATASAIDA");
					
					dataSaidaString = dataSaidaTemp.toString(Settings.DATE_YMD);
					
					sql = "INSERT INTO VENDAPRODUTO " + "(" + " CODIGO, PRODUTO, VALOR, CODIGOPROD, QUANTIDADE, "
							+ " CATEGORIA, MARCA, DESCRICAO,TIPOPAGAMENTO, DATASAIDA " + ")" + " VALUES " + "( '" + codigoTemp
							+ "' , '" + produtoTemp + "', '" + valorTemp + "', '" +  codigoProdTemp + "', '" + quantidadeTemp + "', '"
							+ categoriaTemp + "','" + marcaTemp + "', '" + descricaoTemp + "', '" + tipoPagamento + "', '" + dataSaidaString + "'"
							+ ")";

					lb.executeUpdate(sql);

				}
				
				sql = "DELETE VENDAPRODUTOTEMP WHERE CODIGO = " + codigoTemp;

				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao dar\n baixa no estoque");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}
	}
	
}
