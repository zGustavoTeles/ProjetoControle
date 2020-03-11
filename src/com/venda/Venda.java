package com.venda;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.carrinho.Carrinho;
import com.inserir.Inserir;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class Venda extends totalcross.ui.Window{
	
	private Label 							lblBuscar;
	private Label							lblCategoria;
	private ArtButton 						btnVoltar;
	private ArtButton						btnBuscar;
	private ArtButton						btnInserir;
	private ComboBox						cmbCategoria;
	private Edit							editBuscar;
	public Grid							    gridProdutos;
	
	public static Button					btnCarrinho;
	public static String					codigo = "";
	public static String					produto = "";
	public static String					quantidade = "";
	public static String				    valor = "";
	public static String					categoria = "";
	public static String					marca = "";
	public static String  					descricao;
	
	public Venda(){
		 setBackColor(0x003366);
		 initUI();
	}
	
	public void initUI() {
		
		try {
					
			lblCategoria = new Label("CATEGORIA:");
			add(lblCategoria);
			lblCategoria.setRect(LEFT, TOP + 5, PREFERRED, PREFERRED);
			lblCategoria.setBackColor(0x003366);
			lblCategoria.setForeColor(Color.WHITE);
			
			cmbCategoria = new ComboBox();
			add(cmbCategoria);
			cmbCategoria.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblCategoria);
			
			lblBuscar = new Label("BUSCAR");
			add(lblBuscar);
			lblBuscar.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, cmbCategoria);
			lblBuscar.setBackColor(0x003366);
			lblBuscar.setForeColor(Color.WHITE);
			
			editBuscar = new Edit();
			add(editBuscar);
			editBuscar.capitalise = (Edit.ALL_UPPER);
			editBuscar.setRect(LEFT, AFTER + 5, width - 130, PREFERRED, lblBuscar);
			editBuscar.setBackColor(Color.WHITE);
			editBuscar.setForeColor(0x003366);

			btnBuscar = new ArtButton("BUSCAR");
			add(btnBuscar);
			btnBuscar.setRect(AFTER + 1, SAME, SCREENSIZE - 5, PREFERRED, editBuscar);
			btnBuscar.setBackColor(0x003366);
	        btnBuscar.setForeColor(Color.WHITE);
	            
            btnVoltar = new ArtButton("VOLTAR");
            add(btnVoltar);
            btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
            btnVoltar.setBackColor(0x003366);
            btnVoltar.setForeColor(Color.WHITE);
            
            btnInserir = new ArtButton("INSERIR");
            add(btnInserir);
            btnInserir.setRect(LEFT, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
            btnInserir.setBackColor(0x009933);
            btnInserir.setForeColor(Color.WHITE);
            
            btnCarrinho = BottomImg.imageOnly(new Image("img/carrinho.png"));
			add(btnCarrinho, AFTER + 5, BOTTOM, SCREENSIZE + 16, PREFERRED, btnInserir);
			btnCarrinho.setEnabled(false);

            int gridWidths[] = new int[7];
				gridWidths[0] = 40;
				gridWidths[1] = 50;
				gridWidths[2] = 40;
				gridWidths[3] = 110;
				gridWidths[4] = 100;
				gridWidths[5] = 10;
				gridWidths[6] = 2;
	
			String[] caps = { "COD.", "PRODUTO", "QNT", "MARCA", "CATEGORIA","DESC", " VALOR"};
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT};
			gridProdutos = new Grid(caps, gridWidths, aligns, false);
			add(gridProdutos);
			gridProdutos.setBackColor(Color.WHITE);
			gridProdutos.setForeColor(0x003366);
			gridProdutos.transparentBackground = false;
			gridProdutos.drawCheckBox = true;
			gridProdutos.disableSort = false;
			gridProdutos.canClickSelectAll = true;
			gridProdutos.boldCheck = false;
			gridProdutos.enableColumnResize = false;
//			gridProdutos.captionsBackColor = Color.BLACK;
			gridProdutos.setRect(Container.LEFT + 1, Container.AFTER + 10,
					Container.FILL - 1, Container.FIT, btnBuscar);
			
			reposition();
			
			habilitaCarrinho();
			
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO","Erro ao construir a tela venda\n" + e);
			
		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnBuscar) {
					if (editBuscar.getText().equals("")) {
						Auxiliares.artMsgbox("CONTROLE", "O campo de busca deve ser preenchido!");
						
					} else {
						gridProdutos.removeAllElements();
						carregaGridProdutosBusca();
					}
					
				} else if (evt.target == cmbCategoria) {
					if (cmbCategoria.getItems() != null) {
						editBuscar.setText("");
						gridProdutos.removeAllElements();
						carregaGridProdutos();
						
					} else {
						return;
					}

				} else if (evt.target == btnInserir) {
					if (gridProdutos.getSelectedItem() != null) {						
						boolean prodAdicionado = false;
						prodAdicionado = validaProdutoCarrinho(prodAdicionado);

						if (prodAdicionado == false) {
							gridProdutos.removeAllElements();
							Inserir inserir = new Inserir();
							inserir.popup();
						} else {

							Auxiliares.artMsgbox("CONTROLE",
									"Esse produto encontra-se no carrinho.\nPor favor finalize a venda para inseri-lo\nnovamente!");
						}

					} else {
						Auxiliares.artMsgbox("CONTROLE", "Deve-se selecionar um item!");
					}

				} else if (evt.target == btnCarrinho) {
					gridProdutos.removeAllElements();
					Carrinho carrinho = new Carrinho();
					carrinho.popup();
				}
				  break;
			case ControlEvent.FOCUS_IN :
				if (evt.target == cmbCategoria) {
					cmbCategoria.removeAll();
					carregaCmbCategoria();
				}
			}
			switch (evt.type) {
			case GridEvent.SELECTED_EVENT:
				if (evt.target == gridProdutos) {

					try {

						codigo = gridProdutos.getSelectedItem()[0];
						produto = gridProdutos.getSelectedItem()[1];
						quantidade = gridProdutos.getSelectedItem()[2];
						marca = gridProdutos.getSelectedItem()[3];
						categoria = gridProdutos.getSelectedItem()[4];
						descricao = gridProdutos.getSelectedItem()[5];
						valor = gridProdutos.getSelectedItem()[6];

					} catch (Exception e) {
						Auxiliares.artMsgbox("CONTROLE", "Clique em um Item!");
					}

				}

			}
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela venda\n" + e);
		}

	}
	
	public void carregaGridProdutos() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				
				lb = new LitebasePack();
				sql = " SELECT * FROM ESTOQUE WHERE CATEGORIA = " + "'" + cmbCategoria.getSelectedItem() + "'";

				rs = lb.executeQuery(sql);
				rs.first();
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[7];
					b[0] = Convert.toString(rs.getInt("CODIGO"));
					b[1] = rs.getString("PRODUTO");
					b[2] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[3] = rs.getString("MARCA");
					b[4] = rs.getString("CATEGORIA");
					b[5] = rs.getString("DESCRICAO");
					b[6] = rs.getString("VALOR");
					gridProdutos.add(b);
					rs.next();
				}

			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao carregarGridProdutos\n" + e);

		}

	}
	
	public void carregaGridProdutosBusca() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				lb = new LitebasePack();
				sql = " SELECT * FROM ESTOQUE WHERE PRODUTO LIKE " 
				    + "'%" + editBuscar.getText() + "%'"
				    + "OR MARCA LIKE "  + "'%" + editBuscar.getText() + "%'";

				rs = lb.executeQuery(sql);
				rs.first();
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[7];
					b[0] = Convert.toString(rs.getInt("CODIGO"));
					b[1] = rs.getString("PRODUTO");
					b[2] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[3] = rs.getString("MARCA");
					b[4] = rs.getString("CATEGORIA");
					b[5] = rs.getString("DESCRICAO");
					b[6] = rs.getString("VALOR");
					gridProdutos.add(b);
					rs.next();
				}
			} finally {
 				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao carregaGridProdutosBusca\n" + e);

		}

	}
	
	public void carregaCmbCategoria() {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM CATEGORIA";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbCategoria.add(b);
						rs.next();
					}
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.artMsgbox("ERRO", "Erro ao carregaCmbCategoria\n" + e);

			}

		}
	}
	
	public boolean validaProdutoCarrinho(boolean prodAdicionado) {
 		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {

				lb = new LitebasePack();

				sql = "SELECT * FROM VENDAPRODUTOTEMP WHERE CODIGOPROD = " + codigo;

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					return prodAdicionado = false;

				} else {
					
					return prodAdicionado = true;
				}

			}
			finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} 
		catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro validaProdutoCarrinho\n" + e);
		}
		return prodAdicionado;

	}
	
	public void habilitaCarrinho() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {

				lb = new LitebasePack();

				sql = "SELECT * FROM VENDAPRODUTOTEMP";

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					return;

				} else {
					btnCarrinho.setEnabled(true);
				}

			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao habilitaCarrinho\n" + e);
		}

	}
	
}
