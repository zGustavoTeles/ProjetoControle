package principal;

import nx.componentes.ArtButton;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.*;

import com.adm.ValidaAdm;
import com.informacao.Informacao;
import com.litebase.LitebasePack;
import com.menu.Menu;
import litebase.LitebaseConnection;
import litebase.ResultSet;
import com.tabelas.Tabelas;

public class Home extends MainWindow{
	
		private Edit			editEmpresa;
		private Edit			editCnpj;
		private Edit            editUsuario;
		private Edit			editBuscarEmpresa;
		private Label			lblBuscarEmpresa;
		private Label			lblEmpresa;
		private Label           lblCnpj;
		private Label			lblUsuario;
		private ArtButton       btnAdm;
		private ArtButton       btnEntrar;
		private ArtButton		btnBuscar;
		private ImageControl	imgHome;
		
	public Home() {
		setBackColor(0x003366);
		Tabelas tabelas = new Tabelas();
		tabelas.criaTabelas();
	}

		
		
		public void initUI(){
		try {
			
			lblBuscarEmpresa = new Label("CÓDIGO: ");
			add(lblBuscarEmpresa);
			lblBuscarEmpresa.setBackColor(0x003366);
			lblBuscarEmpresa.setForeColor(Color.WHITE);
			lblBuscarEmpresa.setRect(LEFT, TOP + 5, PREFERRED, PREFERRED);

			add(editBuscarEmpresa = new Edit(), AFTER + 2, SAME, width - 200, PREFERRED, lblBuscarEmpresa);
			editBuscarEmpresa.setBackColor(Color.WHITE);
			editBuscarEmpresa.setForeColor(0x003366);
			
			btnBuscar = new ArtButton("BUSCAR");
			add(btnBuscar);
			btnBuscar.setRect(AFTER + 2, SAME, width - 450, PREFERRED, editBuscarEmpresa);
			btnBuscar.setBackColor(0x003366);
	        btnBuscar.setForeColor(Color.WHITE);
			
			imgHome = new ImageControl(new Image("img/home.png"));
			imgHome.scaleToFit = true;
			imgHome.centerImage = true;
			add(imgHome, CENTER, AFTER + 10, SCREENSIZE + 50, PREFERRED);

			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(CENTER, AFTER + 30, PREFERRED, PREFERRED, imgHome);

			add(editEmpresa = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);

			lblCnpj = new Label("CNPJ: ");
			add(lblCnpj);
			lblCnpj.setBackColor(0x003366);
			lblCnpj.setForeColor(Color.WHITE);
			lblCnpj.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editEmpresa);

			add(editCnpj = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editCnpj.setBackColor(Color.WHITE);
			editCnpj.setForeColor(0x003366);
			
			lblUsuario = new Label("USUÁRIO: ");
			add(lblUsuario);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);
			lblUsuario.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
			
			add(editUsuario = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);
			
			btnEntrar = new ArtButton("Entrar");
			add(btnEntrar);
			btnEntrar.setBackColor(0x003366);
			btnEntrar.setForeColor(Color.WHITE);
			btnEntrar.setRect(RIGHT - 40, AFTER + 200, SCREENSIZE + 30, PREFERRED, editCnpj);

			btnAdm = new ArtButton("Administrador");
			add(btnAdm);
			btnAdm.setBackColor(0x003366);
			btnAdm.setForeColor(Color.WHITE);
			btnAdm.setRect(LEFT + 40, AFTER + 200, SCREENSIZE + 30, PREFERRED, editCnpj);
			
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!","Erro ao carregar a Tela");
			msg.setBackColor(0x345D7E);
			msg.setForeColor(Color.WHITE);
			msg.popup();
		}	
		
	}
		
		public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnEntrar) {

					if (editEmpresa.getText().equals("") || editCnpj.getText().equals("")
							|| editUsuario.getText().equals("")) {
						MessageBox msg = new MessageBox("Aviso!", "Preencha todos os campos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
					} else {
						Menu menu = new Menu();
						menu.popup();
					}

				} else if (evt.target == btnAdm) {
					ValidaAdm validaAdm = new ValidaAdm();
					validaAdm.popup();

				} else if (evt.target == btnBuscar) {
					if (editBuscarEmpresa.getText().equals("")) {

						MessageBox msg = new MessageBox("Aviso!", " Insira o Código da Empresa");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
					} else {
						carregaInformacoesEmpresa();
					}
				}
			}
		}catch (Exception e) {
				MessageBox msg = new MessageBox("Aviso!","Erro ao carregar a Tela");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();
			}
			
			
		}
		public void carregaInformacoesEmpresa() {
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;
			
		try {

			try {
				lb = new LitebasePack();
				sql = " SELECT * FROM EMPRESA " + " WHERE CODIGO = " + editBuscarEmpresa.getText();

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					MessageBox msg = new MessageBox("Aviso!", "Empresa não Cadastrada");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();
					editBuscarEmpresa.setText("");
					return;
				}
				
				editEmpresa.setText(rs.getString("NOME"));
				editCnpj.setText(rs.getString("CNPJ"));
				editUsuario.setText(rs.getString("USUARIO"));

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("Aviso!","Erro ao Buscar Empresa");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
			}
		}
		
	}

