package com.relatorio;

import com.agenda.Agenda;
import com.auxiliares.Auxiliares;
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
			btnBuscar.setRect(AFTER + 5 , SAME, SCREENSIZE - 5, PREFERRED, editDataDois);
			btnBuscar.setBackColor(0x003366);
			btnBuscar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

			int gridWidths[] = new int[7];
			gridWidths[0] = 100;
			gridWidths[1] = 2;
			gridWidths[2] = 100;
			gridWidths[3] = 100;
			gridWidths[4] = 8;
			gridWidths[5] = 5;
			gridWidths[6] = 5;

			String[] caps = { "DATA", "COD.V", "PRODUTO", "MARCA", "DESC.", "QNT", "VALOR" };
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT };
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
			
			reposition();
			
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO","Erro ao construir a tela relatorio\n" + e);

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
						
						Auxiliares.artMsgbox("CONTROLE",
								"Preencha todos os campos de data à serem pesquisados!");
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
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela relatorio\n" + e);
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
				sql = " SELECT * FROM VENDAPRODUTO "
					+ " WHERE DATASAIDA >= " + "'" + editDataUm.getText() + "'"
					+ " AND DATASAIDA<= " + "'" + editDataDois.getText() + "'";

				rs = lb.executeQuery(sql);
				rs.first();
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[7];
					b[0] = rs.getString("DATASAIDA");
					b[1] = Convert.toString(rs.getInt("CODIGO"));
					b[2] = rs.getString("PRODUTO");
					b[3] = rs.getString("MARCA");
					b[4] = rs.getString("DESCRICAO");
					b[5] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[6] = rs.getString("VALOR") + " $$";
					gridProdutos.add(b);
					rs.next();
				}

			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro ao pesquisaVendasPorPeriodo\n" + e);

		}

	}	
	
}
