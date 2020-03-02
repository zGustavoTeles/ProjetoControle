package com.configuracoes;

import com.auxiliares.Auxiliares;
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
			btnApagar.setRect(CENTER, AFTER + 80, width - 350, PREFERRED, editCodigo);
			btnApagar.setBackColor(0xDF0101);
			btnApagar.setForeColor(Color.WHITE);

			btnVoltar = new ArtButton("VOLTAR");
			add(btnVoltar);
			btnVoltar.setRect(RIGHT, BOTTOM, SCREENSIZE - 4, PREFERRED + 15);
			btnVoltar.setBackColor(0x003366);
			btnVoltar.setForeColor(Color.WHITE);
			
			reposition();
			
			setEmpresa();
			
		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO","Erro ao construir a tela apagarDados\n" + e);

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

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.artMsgbox("CONTROLE", "Deseja apagar os dados do sistema?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							deletaDados();

							Auxiliares.artMsgbox("CONTROLE", "Dados deletados!");
							unpop();
							unpop();
							unpop();
						}

					} else if (editCodigo.getText().equals("")) {
						Auxiliares.artMsgbox("CONTROLE", "Por favor digite um código!");

					} else {
						Auxiliares.artMsgbox("CONTROLE", "Código da empresa incorreto!");						
						editCodigo.setText("");
					}
				}

			}

		} catch (Exception e) {
			Auxiliares.artMsgbox("ERRO", "Erro na validação da tela ApagarDados\n" + e);
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
				if (lb.exists("VENDAPRODUTOTEMP")) {

					sql = " DROP TABLE vendaprodutotemp ";

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
			Auxiliares.artMsgbox("ERRO", "Erro ao deletarDados\n" + e);
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
			Auxiliares.artMsgbox("ERRO", "Erro setEmpresa\n" + e);
		}
	}

	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

}
