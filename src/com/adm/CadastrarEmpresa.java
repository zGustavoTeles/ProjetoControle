package com.adm;

import java.util.Random;

import com.litebase.LitebasePack;

import litebase.ResultSet;
import nx.componentes.ArtButton;
import totalcross.sys.Convert;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.util.Date;

public class CadastrarEmpresa extends totalcross.ui.Window {

	public Label                lblAviso;
	public Label 				lblEmpresa;
	public Label 				lblCnpj;
	public Label 				lblUsuario;
	public Label				lblCodigo;
	public Edit					editCodigo;
	public Edit 				editUsuario;
	public Edit 				editSenha;
	public Edit					editEmpresa;
	public Edit					editCnpj;
	public ArtButton		    btnCadastrar;
	public ArtButton			btnGerarCodigo;
	public ArtButton 			btnVoltar;

	public CadastrarEmpresa() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("POR FAVOR PREENCHA TODOS OS CAMPOS PARA\n CADASTRAR UMA EMPRESA PARA O SISTEMA:");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, lblAviso);

			add(editEmpresa = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED, lblEmpresa);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);

			lblCnpj = new Label("CNPJ: ");
			add(lblCnpj);
			lblCnpj.setBackColor(0x003366);
			lblCnpj.setForeColor(Color.WHITE);
			lblCnpj.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, editEmpresa);

			add(editCnpj = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED, lblCnpj);
			editCnpj.setBackColor(Color.WHITE);
			editCnpj.setForeColor(0x003366);
			editCnpj.setValidChars("0 1 2 3 4 5 6 7 8 9 /");
			
			lblUsuario = new Label("USUÁRIO: ");
			add(lblUsuario);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);
			lblUsuario.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
			
			add(editUsuario = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);
			
			btnGerarCodigo = new ArtButton("CÓDIGO");
			add(btnGerarCodigo);
			btnGerarCodigo.setRect(LEFT, AFTER + 20, SCREENSIZE - 5, PREFERRED, editUsuario);
			btnGerarCodigo.setBackColor(0x003366);
			btnGerarCodigo.setForeColor(Color.WHITE);	
			
			add(editCodigo = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED);
			editCodigo.setBackColor(Color.WHITE);
			editCodigo.setForeColor(0x003366);
			
			btnCadastrar = new ArtButton("CADASTRAR");
			add(btnCadastrar);
			btnCadastrar.setRect(CENTER, AFTER + 50, width - 400, PREFERRED, editSenha);
			btnCadastrar.setBackColor(0x009933);
			btnCadastrar.setForeColor(Color.WHITE);		

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED);
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

				} else if (evt.target == btnCadastrar) {
					if (editEmpresa.getText().equals("") || editCnpj.getText().equals("")
							|| editUsuario.getText().equals("")) {
						MessageBox msg = new MessageBox("Aviso!", "Preencha todos os campos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
					} else {
						cadastrarNovaEmpresa();

						MessageBox msg = new MessageBox("Aviso!", "Empresa cadastrada\n com Sucesso!");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						unpop();
					}
					
				} else if (evt.target == btnGerarCodigo) {
					Random random = new Random();
					int codigo = random.nextInt(900);
					editCodigo.setText(Convert.toString(codigo));

				}

			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void cadastrarNovaEmpresa() {
		String sql = "";
		LitebasePack lb = null;
		
		try {
			
			try {

				lb = new LitebasePack();

				sql = "DELETE EMPRESA";

				lb.executeUpdate(sql);
				

				sql = "INSERT INTO EMPRESA " + "(" + " CODIGO, NOME, CNPJ, USUARIO " + ")" + " VALUES " + "( '" + editCodigo.getText()
						+ "' , '" + editEmpresa.getText() + "', '" + editCnpj.getText() + "', '" + editUsuario.getText()
						+ "'" + ")";

				lb.executeUpdate(sql);

			} finally {
				if(lb != null) {
					lb.closeAll();	
				}
			}
			
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Ao Cadastrar Empresa" + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}
	}

}
