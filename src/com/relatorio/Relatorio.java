package com.relatorio;

import com.agenda.Agenda;

import com.litebase.LitebasePack;
import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.ui.Container;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;

public class Relatorio extends totalcross.ui.Window{
	
	private Label							lblData;
	private Label							lblA;
	private Edit							editDataUm;
	private Edit							editDataDois;
	private Grid							gridProdutos;
	private ArtButton 						btnVoltar;
	private ArtButton						btnBuscar;
	
	public Agenda							agenda;
	public Relatorio(){
		 setBackColor(0x003366);
		 initUI();
	}
	
	public void initUI() {
		
		try {

			lblData = new Label("DATA: ");
			add(lblData);
			lblData.setRect(LEFT, TOP + 5, PREFERRED, PREFERRED);
			lblData.setBackColor(0x003366);
			lblData.setForeColor(Color.WHITE);

			editDataUm = new Edit();
			add(editDataUm);
			editDataUm.setRect(AFTER + 2, SAME, SCREENSIZE - 4, PREFERRED, lblData);
			editDataUm.setBackColor(Color.WHITE);
			editDataUm.setForeColor(0x003366);

			lblA = new Label(" Á ");
			add(lblA);
			lblA.setRect(AFTER + 2, SAME, PREFERRED, PREFERRED, editDataUm);
			lblA.setBackColor(0x003366);
			lblA.setForeColor(Color.WHITE);

			editDataDois = new Edit();
			add(editDataDois);
			editDataDois.setRect(AFTER + 2, SAME, SCREENSIZE - 4, PREFERRED, lblA);
			editDataDois.setBackColor(Color.WHITE);
			editDataDois.setForeColor(0x003366);

			btnBuscar = new ArtButton("BUSCAR");
			add(btnBuscar);
			btnBuscar.setRect(AFTER + 5 , SAME, SCREENSIZE - 4, PREFERRED, editDataDois);
			btnBuscar.setBackColor(0x003366);
			btnBuscar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

			int gridWidths[] = new int[6];
			gridWidths[0] = 100;
			gridWidths[1] = 2;
			gridWidths[2] = 100;
			gridWidths[3] = 120;
			gridWidths[4] = 8;
			gridWidths[5] = 5;

			String[] caps = { "DATA", "COD", "DESCRICAO", "MARCA", "QNT", "VALOR" };
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT };
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
			gridProdutos.setRect(Container.LEFT + 1, Container.AFTER + 10, Container.FILL - 1, Container.FIT, lblData);

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

				} else if (evt.target == btnBuscar) {
					if (editDataUm.getText().equals("") || editDataDois.getText().equals("")) {
						
						MessageBox msg = new MessageBox("CONTROLE",
								"Preencha todos os campos\n de data à serem pesquisados");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						return;
						
					} else {
						pesquisaVendasPorPeriodo();
						editDataUm.setText("");
						editDataDois.setText("");
					}
				}
				
				break;
			case PenEvent.PEN_DOWN:

				if (evt.target == editDataUm) {
					Agenda.setDateByCalendarBox(editDataUm);

				} else if (evt.target == editDataDois) {
					Agenda.setDateByCalendarBox(editDataDois);
				}
			}
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void pesquisaVendasPorPeriodo() throws Exception {
		String sql		   = "";
		LitebasePack lb    = null;
		ResultSet rs	   = null;

		try {

			try {
				gridProdutos.removeAllElements();

				lb = new LitebasePack();
				sql = " SELECT * FROM VENDAPRODUTO WHERE DATAVENDA >= " + "'" + editDataUm.getText() + "'"
					+ " AND DATAVENDA<= " + "'" + editDataDois.getText() + "'";

				rs = lb.executeQuery(sql);
				rs.first();
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[6];
					b[0] = rs.getString("DATAVENDA");
					b[1] = Convert.toString(rs.getInt("CODIGO"));
					b[2] = rs.getString("PRODUTO");
					b[3] = rs.getString("MARCA");
					b[4] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[5] = rs.getString("VALOR");
					gridProdutos.add(b);
					rs.next();
				}

			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {

		}

	}	
	
}
