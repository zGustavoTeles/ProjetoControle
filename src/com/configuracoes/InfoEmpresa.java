package com.configuracoes;

import java.awt.image.RescaleOp;

import com.litebase.LitebasePack;

import litebase.ResultSet;
import nx.componentes.ArtButton;
import principal.Home;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class InfoEmpresa extends totalcross.ui.Window {

	public Label                lblInformacao;
	public Label 				lblEmpresa;
	public Label 				lblCnpj;
	public Label				lblUsuario;
	public Edit					editUsuario;
	public Edit 				editEmpresa;
	public Edit 				editCnpj;
	public ImageControl			imgInfo;
	public ArtButton 			btnVoltar;

	public InfoEmpresa() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblInformacao = new Label("ATUALMENTE A EMPRESA CADASTRADA É: ");
			add(lblInformacao);
			lblInformacao.setRect(CENTER, TOP + 2, PREFERRED, PREFERRED);
			lblInformacao.setBackColor(0x003366);
			lblInformacao.setForeColor(Color.WHITE);
			
			imgInfo = new ImageControl(new Image("img/info.png"));
			imgInfo.scaleToFit = true;
			imgInfo.centerImage = true;
			add(imgInfo,  CENTER, AFTER - 20, SCREENSIZE + 50, PREFERRED, lblInformacao);
			
			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, imgInfo);

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
			
			lblUsuario = new Label("USUÁRIO: ");
			add(lblUsuario);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);
			lblUsuario.setRect(LEFT, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
			
			add(editUsuario = new Edit(), LEFT, AFTER + 20, PREFERRED, PREFERRED);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, width - 400, PREFERRED);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
//			consultarEmpresa();

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

				}


			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void consultarEmpresa() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;
		
		try {
			
			try {
				Home home = new Home();

				lb = new LitebasePack();

				sql = " SELECT * FROM EMPRESA "
					+ " WHERE CODIGO = " + home.editCodigo.getText();	

				rs = lb.executeQuery(sql);
				
				editEmpresa.setText(rs.getString("NOME"));
				editCnpj.setText(rs.getString("CNPJ"));
				editUsuario.setText(rs.getString("USUARIO"));

			} finally {
				if(lb != null) {
					lb.closeAll();	
				}
			}
			
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE!", "Ao Cadastrar Empresa" + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}
	}

}
