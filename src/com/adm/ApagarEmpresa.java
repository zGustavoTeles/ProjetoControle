package com.adm;

import com.litebase.LitebasePack;
import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.ui.ComboBox;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;

public class ApagarEmpresa extends totalcross.ui.Window {

	private Label				lblAviso;
	private ComboBox			cmbEmpresa;
	private ArtButton			btnApagar;
	private ArtButton 			btnVoltar;  
	
	private int					codigoEmpresa = 0;

	public ApagarEmpresa() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("POR FAVOR SELECIONE A EMPRESA QUE DESEJA\n APAGAR DO SISTEMA SISTEMA:");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP + 2, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			cmbEmpresa = new ComboBox();
			add(cmbEmpresa);
			cmbEmpresa.setRect(LEFT, AFTER + 25, FILL + 5, PREFERRED);		
			
			btnApagar = new ArtButton("APAGAR");
			add(btnApagar);
			btnApagar.setRect(CENTER, AFTER + 350, width - 300, PREFERRED, cmbEmpresa);
			btnApagar.setBackColor(0xDF0101);
			btnApagar.setForeColor(Color.WHITE);	

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao carregar a Tela");
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

				} else if (evt.target == btnApagar) {

					if (cmbEmpresa.getSelectedIndex() == -1) {

						MessageBox msg = new MessageBox("CONTROLE", "Selecione uma Empresa");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						return;

					}

					apagarEmpresaDoSistema();
					MessageBox msg = new MessageBox("CONTROLE", "Empresa apagada\n do Sistema");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();
					unpop();
					
				} else if (evt.target == cmbEmpresa) {
					buscaCodigoEmpresa();
				}
				break;

			case PenEvent.PEN_DOWN:

				if (evt.target == cmbEmpresa) {

					cmbEmpresa.removeAll();
					carregaCmbEmpresa();

				}
			}
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void carregaCmbEmpresa() {
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;
 
			try {
				try {
					lb = new LitebasePack();
					sql = " SELECT NOME, CODIGO FROM EMPRESA";

					rs = lb.executeQuery(sql);
					rs.first();			
				for (int i = 0; rs.getRowCount() > i; i++) {
					String[] b = new String[1];
					b[0] = rs.getString("NOME");
					cmbEmpresa.add(b);
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
	
	public void apagarEmpresaDoSistema() {
		String sql = "";
		LitebasePack lb = null;

		try {

			try {
				lb = new LitebasePack();
				
				sql = " DELETE FROM EMPRESA " + " WHERE CODIGO = " + getCodigoEmpresa();
				lb.executeUpdate(sql);
				
				sql = "DELETE FROM EMPRESAESCOLHIDA " + " WHERE CODIGO = " + getCodigoEmpresa();
				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao Apagar Empresa\n do Sistema");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
			
			unpop();
		}
	}
	
	public void buscaCodigoEmpresa() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {
			try {
				lb = new LitebasePack();
				sql = " SELECT CODIGO, NOME FROM EMPRESA "
					+ " WHERE NOME = "	+ "'" + cmbEmpresa.getSelectedItem() + "'";

				rs = lb.executeQuery(sql);
				rs.first();			
				setCodigoEmpresa(rs.getInt("CODIGO"));
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

	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

}
