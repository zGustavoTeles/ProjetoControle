package principal;

import nx.componentes.ArtButton;
import totalcross.sys.Convert;
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
import com.litebase.LitebasePack;
import com.menu.Menu;
import litebase.ResultSet;
import com.tabelas.Tabelas;

public class Home extends MainWindow{
	
		public Edit				editEmpresa;
		public Edit				editCnpj;
		public Edit             editUsuario;
		public Edit				editCodigo;
		public Label			lblCodigo;
		public Label			lblEmpresa;
		public Label            lblCnpj;
		public Label			lblUsuario;
		public ArtButton        btnAdm;
		public ArtButton        btnEntrar;
		public ArtButton		btnBuscar;
		public ImageControl		imgHome;
		
		
	public Home() {
		setBackColor(0x003366);
		Tabelas tabelas = new Tabelas();
		tabelas.criaTabelas();
	}
		
		public void initUI(){
			
		try {
			
			imgHome = new ImageControl(new Image("img/home.png"));
			imgHome.scaleToFit = true;
			imgHome.centerImage = true;
			add(imgHome, CENTER, TOP - 20, SCREENSIZE + 50, PREFERRED);

			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(CENTER, AFTER + 5, PREFERRED, PREFERRED, imgHome);

			add(editEmpresa = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);
			editEmpresa.setEnabled(false);

			lblCnpj = new Label("CNPJ: ");
			add(lblCnpj);
			lblCnpj.setBackColor(0x003366);
			lblCnpj.setForeColor(Color.WHITE);
			lblCnpj.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editEmpresa);

			add(editCnpj = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editCnpj.setBackColor(Color.WHITE);
			editCnpj.setForeColor(0x003366);
			editCnpj.setEnabled(false);
			
			lblUsuario = new Label("USU�RIO: ");
			add(lblUsuario);
			lblUsuario.setBackColor(0x003366);
			lblUsuario.setForeColor(Color.WHITE);
			lblUsuario.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
			
			add(editUsuario = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editUsuario.setBackColor(Color.WHITE);
			editUsuario.setForeColor(0x003366);
			editUsuario.setEditable(false);
			
			lblCodigo = new Label("C�DIGO: ");
			add(lblCodigo);
			lblCodigo.setBackColor(0x003366);
			lblCodigo.setForeColor(Color.WHITE);
			lblCodigo.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editUsuario);
			
			add(editCodigo = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
			editCodigo.setBackColor(Color.WHITE);
			editCodigo.setForeColor(0x003366);
			editCodigo.setEnabled(false);
			
			btnEntrar = new ArtButton("Entrar");
			add(btnEntrar);
			btnEntrar.setBackColor(0x003366);
			btnEntrar.setForeColor(Color.WHITE);
			btnEntrar.setRect(RIGHT - 40, AFTER + 90, SCREENSIZE + 30, PREFERRED, editCodigo);

			btnAdm = new ArtButton("Administrador");
			add(btnAdm);
			btnAdm.setBackColor(0x003366);
			btnAdm.setForeColor(Color.WHITE);
			btnAdm.setRect(LEFT + 40, AFTER + 90, SCREENSIZE + 30, PREFERRED, editCodigo);
			
			buscaEmpresaCadastrada();
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE","Erro ao carregar a Tela");
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
						MessageBox msg = new MessageBox("CONTROLE", "Preencha todos os campos");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();

					} else {					
						
						buscaEmpresaEscolhida(); 
						Menu menu = new Menu();
						menu.popup();
					}

				} else if (evt.target == btnAdm) {
					ValidaAdm validaAdm = new ValidaAdm();
					validaAdm.popup();

				}
			}
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao carregar a Tela");
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
				sql = "SELECT * FROM EMPRESAESCOLHIDA ";

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					MessageBox msg = new MessageBox("CONTROLE", "Sistema n�o possui\n Empresa cadastrada");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();

					return;
				}

				editEmpresa.setText(rs.getString("NOME"));
				editCnpj.setText(rs.getString("CNPJ"));
				editUsuario.setText(rs.getString("USUARIO"));
				editCodigo.setText(Convert.toString(rs.getInt("CODIGO")));

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao Buscar Empresa");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
			return;
		}
	}
	
	public void buscaEmpresaEscolhida(){
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				sql = "SELECT * FROM EMPRESAESCOLHIDA ";

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					MessageBox msg = new MessageBox("CONTROLE", "Sistema n�o possui\n Empresa cadastrada");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();

					return;
				}
				
				if (!editCodigo.getText().equals((Convert.toString(rs.getInt("CODIGO"))))) {
					MessageBox msg = new MessageBox("CONTROLE",
							"H� uma nova empresa selecionada.\n " + " Iremos atualizar o Sistema");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();
				}
				
				editEmpresa.setText(rs.getString("NOME"));
				editCnpj.setText(rs.getString("CNPJ"));
				editUsuario.setText(rs.getString("USUARIO"));
				editCodigo.setText(Convert.toString(rs.getInt("CODIGO")));

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao Buscar Empresa");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
			return;
		}
	}
			
	}

