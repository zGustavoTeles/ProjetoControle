package com.adm;

import com.litebase.LitebasePack;
import litebase.ResultSet;
import nx.componentes.ArtButton;
import principal.Home;
import totalcross.sys.Convert;
import totalcross.ui.ComboBox;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.PenEvent;
import totalcross.ui.gfx.Color;

public class EscolherEmpresa extends totalcross.ui.Window {

	private Label				lblAviso;
	private ComboBox			cmbEmpresa;
	private ArtButton		    btnSalvar;
	private ArtButton			btnCadastrar;
	private ArtButton 			btnVoltar;

	public EscolherEmpresa() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("POR FAVOR SELECIONE A EMPRESA QUE DESEJA\n TORNAR PADRÃO PARA O SISTEMA:");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP + 2, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			cmbEmpresa = new ComboBox();
			add(cmbEmpresa);
			cmbEmpresa.setRect(LEFT, AFTER + 25, FILL + 5, PREFERRED);

			btnSalvar = new ArtButton("SALVAR");
			add(btnSalvar);
			btnSalvar.setRect(LEFT + 20, AFTER + 350, width - 350, PREFERRED, cmbEmpresa);
			btnSalvar.setBackColor(0x009933);
			btnSalvar.setForeColor(Color.WHITE);		
			
			btnCadastrar = new ArtButton("CADASTRAR");
			add(btnCadastrar);
			btnCadastrar.setRect(RIGHT - 20, AFTER + 350, width - 350, PREFERRED, cmbEmpresa);
			btnCadastrar.setBackColor(0xDF0101);
			btnCadastrar.setForeColor(Color.WHITE);	

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

				} else if(evt.target == btnCadastrar) { 
					CadastrarEmpresa cadastrarEmpresa = new CadastrarEmpresa();
					cadastrarEmpresa.popup();
				} else if (evt.target == btnSalvar) {

					if (cmbEmpresa.getSelectedIndex() == -1) {

						MessageBox msg = new MessageBox("CONTROLE", "Selecione uma Empresa");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						return;

					}

					selecionaEmpresaSistema();
					MessageBox msg = new MessageBox("CONTROLE", "Empresa selecionada\n para o Sistema");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();
					unpop();
					
				}
			break;
			
			case PenEvent.PEN_DOWN:

			if(evt.target == cmbEmpresa) {
				
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
					sql = " SELECT NOME FROM EMPRESA";

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
	
	public void selecionaEmpresaSistema() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				sql = " SELECT * FROM EMPRESA " + " WHERE NOME = " + "'" + cmbEmpresa.getSelectedItem() + "'";

				rs = lb.executeQuery(sql);
				rs.first();
				
				sql = "DELETE EMPRESAESCOLHIDA";
				lb.executeUpdate(sql);
				
				sql = "INSERT INTO EMPRESAESCOLHIDA " + "(" + " CODIGO, NOME, CNPJ, USUARIO " + ")" + " VALUES " + "( '" + rs.getInt("CODIGO")
				+ "' , '" + rs.getString("NOME") + "', '" + rs.getString("CNPJ") + "', '" + rs.getString("USUARIO")
				+ "'" + ")";

				lb.executeUpdate(sql);

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao Buscar Empresa");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}
	}

}
