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
		private Label			lblEmpresa;
		private Label           lblCnpj;
		private Label           lblHome;
		private Label			lblUsuario;
		private ArtButton       btnInformacao;
		private ArtButton       btnEntrar;
		private ImageControl	imgHome;
		
	public Home() {
		setBackColor(0x003366);
//		lblHome = new Label("Bem Vindo!");
//		add(lblHome);
//		lblHome.setForeColor(Color.WHITE);
//		lblHome.setBackColor(0x003366);
//		lblHome.setRect(CENTER, TOP - 2, PREFERRED, PREFERRED);
		Tabelas tabelas = new Tabelas();
		tabelas.criaTabelas();
	}

		
		
		public void initUI(){
		try {
			
			imgHome = new ImageControl(new Image("img/home.png"));
			imgHome.scaleToFit = true;
			imgHome.centerImage = true;
			add(imgHome, CENTER, CENTER - 200, SCREENSIZE + 50, PREFERRED);
			
			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(CENTER, CENTER, PREFERRED, PREFERRED);

			add(editEmpresa = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);
			editEmpresa.setText("Umbrella");

			lblCnpj = new Label("CNPJ: ");
			add(lblCnpj);
			lblCnpj.setBackColor(0x003366);
			lblCnpj.setForeColor(Color.WHITE);
			lblCnpj.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editEmpresa);

			add(editCnpj = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editCnpj.setBackColor(Color.WHITE);
			editCnpj.setForeColor(0x003366);
			editCnpj.setText("59.291.534/0001-67");
			
			lblUsuario = new Label("USUÁRIO: ");
			add(lblUsuario);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);
			lblUsuario.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
			
			add(editUsuario = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);
			editUsuario.setText("admin");
			
			btnEntrar = new ArtButton("Entrar");
			add(btnEntrar);
			btnEntrar.setBackColor(0x003366);
			btnEntrar.setForeColor(Color.WHITE);
			btnEntrar.setRect(RIGHT - 40, AFTER + 200, SCREENSIZE + 30, PREFERRED, editCnpj);

			btnInformacao = new ArtButton("Informação");
			add(btnInformacao);
			btnInformacao.setBackColor(0x003366);
			btnInformacao.setForeColor(Color.WHITE);
			btnInformacao.setRect(LEFT + 40, AFTER + 200, SCREENSIZE + 30, PREFERRED, editCnpj);

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
					Menu menu = new Menu();
					menu.popup();
				}else if(evt.target == btnInformacao){
					Informacao informacao = new Informacao();
					informacao.popup();
					
				}
			}
		}catch (Exception e) {
				MessageBox msg = new MessageBox("Aviso!","Erro ao carregar a Tela");
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x003366);
				msg.popup();
			}
			
			
		}
		
	}

