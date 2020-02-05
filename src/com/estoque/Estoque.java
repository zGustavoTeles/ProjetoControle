package com.estoque;

import com.inserir.Inserir;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
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

public class Estoque extends totalcross.ui.Window{
	
	private Label 							lblBuscar;
	private Label						    lblProduto;
	private ArtButton 						btnVoltar;
	private ArtButton						btnBuscar;
	private ArtButton						btnRemover;
	private	ComboBox						cmbCategoria;
	private Edit							editBuscar;
	private Grid							gridProdutos;
	
	public static String					codigo = "";
	public static String					quantidade = "";
	public static String					produto = "";
	
	public Estoque(){
		 setBackColor(0x003366);
		 initUI();
		 carregaCmbCategoria();
	}
	
	public void initUI() {
		
		try {
			
			lblProduto = new Label("CATEGORIA: ");
			add(lblProduto);
			lblProduto.setRect(LEFT,  TOP + 5, PREFERRED, PREFERRED);
			lblProduto.setBackColor(0x003366);
			lblProduto.setForeColor(Color.WHITE);
			
			cmbCategoria = new ComboBox();
			add(cmbCategoria);
			cmbCategoria.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblProduto);
			
			lblBuscar = new Label("BUSCAR");
			add(lblBuscar);
			lblBuscar.setRect(LEFT,AFTER + 5, PREFERRED, PREFERRED, cmbCategoria);
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
			btnBuscar.setRect(AFTER + 1, SAME, width - 400, PREFERRED, editBuscar);
			btnBuscar.setBackColor(0x003366);
	        btnBuscar.setForeColor(Color.WHITE);
	        
	        btnRemover = new ArtButton("REMOVER");
            add(btnRemover);
            btnRemover.setRect(LEFT, BOTTOM, width - 400, PREFERRED);
            btnRemover.setBackColor(0xDF0101);
            btnRemover.setForeColor(Color.WHITE);
	            
            btnVoltar = new ArtButton("VOLTAR");
            add(btnVoltar);
            btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
            btnVoltar.setBackColor(0x003366);
            btnVoltar.setForeColor(Color.WHITE);
            
            int gridWidths[] = new int[8];
			gridWidths[0] = 30;
			gridWidths[1] = 100;
			gridWidths[2] = 40;
			gridWidths[3] = 100;
			gridWidths[4] = 100;
			gridWidths[5] = 10;
			gridWidths[6] = 5;
			gridWidths[7] = 100;

		String[] caps = { "COD.", "PRODUTO", "QNT", "MARCA", "CATEGORIA","DESC", " VALOR", "ENTRADA"};
		int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT};
		gridProdutos = new Grid(caps, gridWidths, aligns, false);
		add(gridProdutos);
		gridProdutos.setBackColor(Color.WHITE);
		gridProdutos.setForeColor(0x003366);
		gridProdutos.transparentBackground = false;
		gridProdutos.setBorderStyle(totalcross.ui.Container.BORDER_NONE);
		gridProdutos.verticalLineStyle = totalcross.ui.Grid.VERT_LINE;
		gridProdutos.drawCheckBox = true;
		gridProdutos.disableSort = false;
		gridProdutos.canClickSelectAll = true;
		gridProdutos.boldCheck = false;
		gridProdutos.setRect(Container.LEFT + 1, Container.AFTER + 10,
				Container.FILL - 1, Container.FIT, btnBuscar);

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

				}else if(evt.target == btnRemover) {
					
					if (gridProdutos.getSelectedItem() != null) {

						gridProdutos.removeAllElements();
						RemoverProduto removerProduto = new RemoverProduto();
						removerProduto.popup();

					} else {
						MessageBox msg = new MessageBox("CONTROLE", "Deve-se selecionar\n um item");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
					}

				}
				else if (evt.target == btnBuscar) {
					if (editBuscar.getText().equals("")) {
						MessageBox msg = new MessageBox("CONTROLE", "O campo de busca\n deve ser preenchido");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
					} else {
						gridProdutos.removeAllElements();
						carregaGridProdutosBusca();
					}
					
				}else if (evt.target == cmbCategoria) {
					if (cmbCategoria.getItems() != null) {
						gridProdutos.removeAllElements();
						carregaGridProdutos();
					} else {
						return;
					}
				}
				break;
			case GridEvent.SELECTED_EVENT:
				if (evt.target == gridProdutos) {

					try {
						
						codigo = gridProdutos.getSelectedItem()[0];
						produto = gridProdutos.getSelectedItem()[1];
						quantidade = gridProdutos.getSelectedItem()[2];

					} catch (Exception e) {
						MessageBox msg = new MessageBox("CONTROLE", "Clique em um Item");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
					}

				}
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
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
				sql = " SELECT * FROM ESTOQUE WHERE PRODUTO LIKE " + "'" + cmbCategoria.getSelectedItem() + "'";

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
					b[6] = rs.getString("VALOR");
					b[7] = rs.getString("DATAENTRADA");
					gridProdutos.add(b);
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
				MessageBox msg = new MessageBox("CONTROLE", "Erro no evento" + e);
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();

			}

		}
	}
	
	public void carregaGridProdutosBusca() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				lb = new LitebasePack();
				sql = " SELECT * FROM ESTOQUE WHERE PRODUTO LIKE " + "'%" + editBuscar.getText() + "%'";

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
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento" + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();

		}

	}		
}
