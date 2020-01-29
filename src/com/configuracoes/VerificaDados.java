package com.configuracoes;

import com.litebase.LitebasePack;
import nx.componentes.ArtButton;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;

public class VerificaDados extends totalcross.ui.Window {

	public Label                lblAviso;
	public Label 				lblUsuario;
	public Label 				lblSenha;
	public Edit 				editUsuario;
	public Edit 				editSenha;
	public ArtButton		    btnApagar;
	public ArtButton 			btnVoltar;

	public VerificaDados() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("POR FAVOR INSIRA O USUÁRIO E A SENHA PARA\n APAGAR TODOS OS DADOS DO SISTEMA:");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			lblUsuario = new Label("USUÁRIO:   ");
			add(lblUsuario);
			lblUsuario.setRect(LEFT + 150, CENTER - 100, PREFERRED, PREFERRED);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);

			editUsuario = new Edit();
			add(editUsuario);
			editUsuario.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblUsuario);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);

			lblSenha = new Label("SENHA:       ");
			add(lblSenha);
			lblSenha.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editUsuario);
			lblSenha.setBackColor(0x003366);
			lblSenha.setForeColor(Color.WHITE);
			
			editSenha = new Edit();
			editSenha.setMode(TAB_ONLY_BORDER);
			add(editSenha);
			editSenha.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblSenha);
			editSenha.setBackColor(Color.WHITE);
			editSenha.setForeColor(0x003366);

			btnApagar = new ArtButton("APAGAR");
			add(btnApagar);
			btnApagar.setRect(CENTER, AFTER + 50, width - 400, PREFERRED, editSenha);
			btnApagar.setBackColor(0x009933);
			btnApagar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!", "Erro ao carregar a Tela");
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

				}
				if (evt.target == btnApagar) {
					if (editUsuario.getText().equals("admin") && editSenha.getText().equals("123456")) {
						deletaDados();

						MessageBox msg = new MessageBox("Aviso!", "Dados deletados");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						unpop();

					} else if (editUsuario.getText().equals("") || editSenha.getText().equals(" ")) {
						MessageBox msg = new MessageBox("Aviso!", "Todos os campos devem\n ser preenchidos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						editSenha.setText("");
						editUsuario.setText("");

					} else {
						MessageBox msg = new MessageBox("Aviso!", "Usuário ou senha incorretos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						editSenha.setText("");
						editUsuario.setText("");
					}
				}

			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}

	public void deletaDados() {
		LitebasePack lb = null;
		String sql = "";

		try {

			try {
				lb = new LitebasePack();
//----------------------------------------------------------------------------------------------------------------------					
				if (lb.exists("MARCA")) {

					sql = " DROP TABLE marca ";

					lb.executeUpdate(sql);
				}
//-----------------------------------------------------------------------------------------------------------------------						
				if (lb.exists("CATEGORIA")) {

					sql = " DROP TABLE categoria ";

					lb.executeUpdate(sql);
				}

//--------------------------------------------------------------------------------------------------------------------------
				if (lb.exists("DESCRICAO")) {

					sql = " DROP TABLE descricao ";

					lb.executeUpdate(sql);
				}

//-------------------------------------------------------------------------------------------------------------------------	
				if (lb.exists("PRODUTO")) {

					sql = " DROP TABLE produto ";

					lb.executeUpdate(sql);
				}

//----------------------------------------------------------------------------------------------------------------------------------------
				if (lb.exists("ESTOQUE")) {

					sql = " DROP TABLE estoque ";

					lb.executeUpdate(sql);
				}
//-----------------------------------------------------------------------------------------------------------------------------------------
				if (lb.exists("VENDAPRODUTO")) {

					sql = " DROP TABLE vendaproduto ";

					lb.executeUpdate(sql);
				}

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!", "Erro " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}

}
