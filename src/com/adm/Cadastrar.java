package com.adm;


import com.litebase.LitebasePack;

import litebase.ResultSet;
import nx.componentes.ArtButton;
import principal.Home;
import totalcross.sys.Convert;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class Cadastrar extends totalcross.ui.Window {

	private ArtButton		    btnCadastrarEmpresa;
	private ArtButton 			btnApagarEmpresa;
	private ArtButton 			btnVoltar;

	public Cadastrar() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {

			btnCadastrarEmpresa = new ArtButton("CADASTRAR EMPRESA");
			add(btnCadastrarEmpresa);
			btnCadastrarEmpresa.setRect(CENTER, TOP + 150, width - 200, PREFERRED + 80);
			btnCadastrarEmpresa.setBackColor(0x003366);
			btnCadastrarEmpresa.setForeColor(Color.WHITE);
			
			btnApagarEmpresa = new ArtButton("APAGAR EMPRESA");
			add(btnApagarEmpresa);
			btnApagarEmpresa.setRect(CENTER, AFTER + 15, width - 200, PREFERRED + 80);
			btnApagarEmpresa.setBackColor(0x003366);
			btnApagarEmpresa.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao carregar a Tela");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x363636);
			msg.popup();

		}

	}

	public void onEvent(Event evt) {

		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					buscaEmpresaCadastrada();
					unpop();

				}else if (evt.target == btnCadastrarEmpresa) {
					CadastrarEmpresa cadastrarEmpresa = new CadastrarEmpresa();
					cadastrarEmpresa.popup();

				} else if(evt.target == btnApagarEmpresa) {
					ApagarEmpresa apagarEmpresa = new ApagarEmpresa();
					apagarEmpresa.popup();
				}

			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void buscaEmpresaCadastrada(){
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				sql = "SELECT * FROM EMPRESA ";

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					MessageBox msg = new MessageBox("CONTROLE", "Sistema não possui\n empresa cadastrada");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();

					return;
				}

				Home.editEmpresa.setText(rs.getString("NOME"));
				Home.editCnpj.setText(rs.getString("CNPJ"));
				Home.editUsuario.setText(rs.getString("USUARIO"));
				Home.editCodigo.setText(Convert.toString(rs.getInt("CODIGO")));

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao buscar empresa");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
			return;
		}
	}

}
