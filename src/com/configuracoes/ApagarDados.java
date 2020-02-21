package com.configuracoes;

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

public class ApagarDados extends totalcross.ui.Window {

	public Label                lblAviso;
	public Label 				lblEmpresa;
	public Label 				lblCodigo;
	public Edit 				editEmpresa;
	public Edit 				editCodigo;
	public ArtButton		    btnApagar;
	public ArtButton 			btnVoltar;
	
	private int 				codigoEmpresa;

	public ApagarDados() {
		setBackColor(0x003366);
		initUI();
	}

	public void initUI() {

		try {
			
			lblAviso = new Label("POR FAVOR INSIRA O CÓDIGO DA EMPRESA PARA\n APAGAR TODOS OS DADOS DO SISTEMA:");
			add(lblAviso);
			lblAviso.setRect(CENTER, TOP, PREFERRED, PREFERRED);
			lblAviso.setBackColor(0x003366);
			lblAviso.setForeColor(Color.WHITE);
			
			lblEmpresa = new Label("EMPRESA:    ");
			add(lblEmpresa);
			lblEmpresa.setRect(LEFT + 150, CENTER - 100, PREFERRED, PREFERRED);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);

			editEmpresa = new Edit();
			add(editEmpresa);
			editEmpresa.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblEmpresa);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);
			editEmpresa.setEditable(false);

			lblCodigo = new Label("CÓDIGO:       ");
			add(lblCodigo);
			lblCodigo.setRect(LEFT + 150, AFTER + 15, PREFERRED, PREFERRED, editEmpresa);
			lblCodigo.setBackColor(0x003366);
			lblCodigo.setForeColor(Color.WHITE);
			
			editCodigo = new Edit();
			editCodigo.setMode(TAB_ONLY_BORDER);
			add(editCodigo);
			editCodigo.setRect(AFTER, SAME, FILL - 150, PREFERRED, lblCodigo);
			editCodigo.setBackColor(Color.WHITE);
			editCodigo.setForeColor(0x003366);

			btnApagar = new ArtButton("APAGAR");
			add(btnApagar);
			btnApagar.setRect(CENTER, AFTER + 80, width - 400, PREFERRED, editCodigo);
			btnApagar.setBackColor(0xDF0101);
			btnApagar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 5, PREFERRED + 13);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
			setEmpresa();
			
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
				if (evt.target == btnApagar) {
					if (editCodigo.getText().equals(Convert.toString(getCodigoEmpresa()))) {
						deletaDados();

						MessageBox msg = new MessageBox("CONTROLE", "Dados deletados");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						unpop();

					} else if (editCodigo.getText().equals("")) {
						MessageBox msg = new MessageBox("CONTROLE", "Por favor digite um código");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();

					} else {
						MessageBox msg = new MessageBox("CONTROLE", "Código da empresa incorreto");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						editCodigo.setText("");
					}
				}

			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro no evento\n " + e);
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
//------------------------------------------------------------------------------------------------------------------------------------------
				if (lb.exists("EMPRESA")) {

					sql = " DROP TABLE empresa ";

					lb.executeUpdate(sql);
				}

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro " + e);
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
		}

	}
	
	public void setEmpresa() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				sql = "SELECT NOME, CODIGO FROM EMPRESA";
				
				rs = lb.executeQuery(sql);
				rs.first();
				
				editEmpresa.setText(rs.getString("NOME"));
				setCodigoEmpresa(rs.getInt("CODIGO"));
				
			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro " + e);
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
