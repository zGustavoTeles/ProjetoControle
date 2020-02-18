package com.carrinho;


import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
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
	public int 								qntEstoqueCalculo = 0;
	public int  				 			quantidadeVendida = 0;
	public String 				 			dataEntrada = "";
	
	public int 								codigoTemp;
	public String							produtoTemp;
	public String							valorTemp;
	public int   							quantidadeTemp;
	public String							categoriaTemp;
	public String							marcaTemp;
	public String                           descricaoTemp;
	public String							TipoVenda;
	public Date								dataSaidaTemp;
		
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

            int gridWidths[] = new int[8];
				gridWidths[0] = 40;
				gridWidths[1] = 50;
				gridWidths[2] = 40;
				gridWidths[3] = 100;
				gridWidths[4] = 100;
				gridWidths[5] = 10;
				gridWidths[6] = 10;
				gridWidths[7] = 5;
	
			String[] caps = { "COD.", "PRODUTO", "QNT", "MARCA", "CATEGORIA","DESC", "PAGAMENTO", " VALOR"};
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT};
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

				rs = lb.executeQuery(sql);
				rs.first();
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[8];
					b[0] = Convert.toString(rs.getInt("CODIGO"));
					b[1] = rs.getString("PRODUTO");
					b[2] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[3] = rs.getString("MARCA");
					b[4] = rs.getString("CATEGORIA");
					b[5] = rs.getString("DESCRICAO");
					b[6] = rs.getString("TIPOPAGAMENTO");
					b[7] = rs.getString("VALOR");
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
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				
				sql = "SELECT * FROM VENDAPRODUTOTEMP";
				
				rs = lb.executeQuery(sql);
				rs.first();
				
				if (rs.next()) {
					codigoTemp = rs.getInt("CODIGO");
					produtoTemp = rs.getString("PRODUTO");
					valorTemp = rs.getString("VALOR");
					quantidadeTemp = rs.getInt("QUANTIDADE");
					categoriaTemp = rs.getString("CATEGORIA");
					marcaTemp = rs.getString("MARCA");
					descricaoTemp = rs.getString("DESCRICAO");
					dataSaidaTemp = rs.getDate("DATASAIDA");

					sql = " SELECT QUANTIDADE, CODIGO, DATAENTRADA FROM ESTOQUE " + " WHERE CODIGO = " + codigoTemp;

					rs = lb.executeQuery(sql);

					qntEstoqueCalculo = rs.getInt("QUANTIDADE");
					dataEntrada = rs.getString("DATAENTRADA");
					quantidadeVendida = quantidadeTemp;

					quantidadeEstoque = qntEstoqueCalculo - quantidadeVendida;

					sql = "DELETE FROM ESTOQUE WHERE CODIGO = " + codigoTemp;

					lb.executeUpdate(sql);

					sql = "INSERT INTO 	ESTOQUE " + "(" + " CODIGO, PRODUTO, MARCA, VALOR, QUANTIDADE, "
							+ " CATEGORIA, MARCA, DESCRICAO, DATASAIDA " + ")" + " VALUES " + "( '" + codigoTemp
							+ "' , '" + produtoTemp + "', '" + marcaTemp + "', '" + valorTemp + "', '"
							+ quantidadeEstoque + "', '" + categoriaTemp + "','" + marcaTemp + "', '" + descricaoTemp
							+ "', '" + dataEntrada + "'" + ")";

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
				rs.first();
				
				if (rs.next()) {
					codigoTemp = rs.getInt("CODIGO");
					produtoTemp = rs.getString("PRODUTO");
					valorTemp = rs.getString("VALOR");
					quantidadeTemp = rs.getInt("QUANTIDADE");
					categoriaTemp = rs.getString("CATEGORIA");
					marcaTemp = rs.getString("MARCA");
					descricaoTemp = rs.getString("DESCRICAO");
					dataSaidaTemp = rs.getDate("DATASAIDA");

					sql = "INSERT INTO VENDAPRODUTO " + "(" + " CODIGO, PRODUTO, VALOR, QUANTIDADE, "
							+ " CATEGORIA, MARCA, DESCRICAO, DATASAIDA " + ")" + " VALUES " + "( '" + codigoTemp
							+ "' , '" + produtoTemp + "', '" + valorTemp + "', '" + quantidadeTemp + "', '"
							+ categoriaTemp + "','" + marcaTemp + "', '" + descricaoTemp + "', '" + dataSaidaTemp + "'"
							+ ")";

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
	
}
