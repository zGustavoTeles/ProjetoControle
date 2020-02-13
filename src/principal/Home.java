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

import com.adm.Administrador;
import com.adm.ValidaAdm;
import com.litebase.LitebasePack;
import com.menu.Menu;
import com.sun.xml.internal.bind.util.Which;

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
		public ArtButton		btnAtualizar;
		public ArtButton        btnSair;
		public ImageControl		imgHome;
		
		
	public Home() {
		setBackColor(0x003366);
		Tabelas tabelas = new Tabelas();
		tabelas.criaTabelas();
//		Settings.resizableWindow = true;
	}
		
		public void initUI(){
			
		try {
			
			imgHome = new ImageControl(new Image("img/home.png"));
			imgHome.scaleToFit = true;
			imgHome.centerImage = true;
			add(imgHome, CENTER, TOP - 15, SCREENSIZE + 50, PREFERRED, btnAtualizar);

			lblEmpresa = new Label("EMPRESA: ");
			add(lblEmpresa);
			lblEmpresa.setBackColor(0x003366);
			lblEmpresa.setForeColor(Color.WHITE);
			lblEmpresa.setRect(CENTER, AFTER - 10, PREFERRED, PREFERRED, imgHome);

			add(editEmpresa = new Edit(), LEFT, AFTER + 1, PREFERRED, PREFERRED);
			editEmpresa.setBackColor(Color.WHITE);
			editEmpresa.setForeColor(0x003366);
			editEmpresa.setEditable(false);

			lblCnpj = new Label("CNPJ: ");
			add(lblCnpj);
			lblCnpj.setBackColor(0x003366);
			lblCnpj.setForeColor(Color.WHITE);
			lblCnpj.setRect(CENTER, AFTER + 5, PREFERRED, PREFERRED, editEmpresa);

			add(editCnpj = new Edit(), LEFT, AFTER + 1, PREFERRED, PREFERRED);
			editCnpj.setBackColor(Color.WHITE);
			editCnpj.setForeColor(0x003366);
			editCnpj.setEditable(false);
			
//			lblUsuario = new Label("USUÁRIO: ");
//			add(lblUsuario);
//			lblUsuario.setBackColor(0x003366);
//			lblUsuario.setForeColor(Color.WHITE);
//			lblUsuario.setRect(CENTER, AFTER + 20, PREFERRED, PREFERRED, editCnpj);
//			
//			add(editUsuario = new Edit(), LEFT, AFTER + 4, PREFERRED, PREFERRED);
//			editUsuario.setBackColor(Color.WHITE);
//			editUsuario.setForeColor(0x003366);
//			editUsuario.setEditable(false);
			
			lblCodigo = new Label("CÓDIGO: ");
			add(lblCodigo);
			lblCodigo.setBackColor(0x003366);
			lblCodigo.setForeColor(Color.WHITE);
			lblCodigo.setRect(CENTER, AFTER + 5, PREFERRED, PREFERRED, editCnpj);
			
			add(editCodigo = new Edit(), LEFT, AFTER + 1, PREFERRED, PREFERRED);
			editCodigo.setMode(TAB_ONLY_BORDER);
			editCodigo.setBackColor(Color.WHITE);
			editCodigo.setForeColor(0x003366);
			editCodigo.setEditable(false);
			
			btnEntrar = new ArtButton("ENTRAR");
			add(btnEntrar);
			btnEntrar.setBackColor(0x003366);
			btnEntrar.setForeColor(Color.WHITE);
			btnEntrar.setRect(CENTER, AFTER + 70, SCREENSIZE + 100, PREFERRED + 20, editCodigo);

//			btnAdm = new ArtButton("Administrador");
//			add(btnAdm);
//			btnAdm.setBackColor(0x003366);
//			btnAdm.setForeColor(Color.WHITE);
//			btnAdm.setRect(LEFT + 40, BOTTOM - 10, SCREENSIZE + 30, PREFERRED, editCodigo);
			
			btnAdm = new ArtButton("CADASTRAR");
			add(btnAdm);
			btnAdm.setBackColor(0x003366);
			btnAdm.setForeColor(Color.WHITE);
			btnAdm.setRect(CENTER,AFTER + 10, SCREENSIZE + 100, PREFERRED + 20, btnEntrar);
			
			btnAtualizar = new ArtButton("ATUALIZAR");
			add(btnAtualizar);
			btnAtualizar.setBackColor(0xFFBF00);
			btnAtualizar.setForeColor(Color.WHITE);
			btnAtualizar.setRect(CENTER,AFTER + 10, SCREENSIZE + 100, PREFERRED + 20, btnAdm);
			
			btnSair = new ArtButton("SAIR");
			add(btnSair);
			btnSair.setBackColor(0xDF0101);
			btnSair.setForeColor(Color.WHITE);
			btnSair.setRect(CENTER,AFTER + 10, SCREENSIZE + 100, PREFERRED + 20, btnAtualizar);
			
			buscaEmpresaCadastrada();
			
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro" + e);
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
						MessageBox msg = new MessageBox("CONTROLE", "Deve-se cadastrar\n uma empresa");
						msg.setBackColor(Color.WHITE);
						msg.setForeColor(0x003366);
						msg.popup();
						
						MessageBox msg2 = new MessageBox("CONTROLE", "Se você já efetuou o cadastro\n clique em 'ESCOLHER EMPRESA' na aba\n de cadastro para torna-la\n padrão para o sistema ");
						msg2.setBackColor(Color.WHITE);
						msg2.setForeColor(0x003366);
						msg2.popup();
						
						MessageBox msg3 = new MessageBox("CONTROLE", "Se você já efetuou\n todos os passos então\n clique em 'Atualizar'\n para buscarmos a empresa\n selecionada para o sistema");
						msg3.setBackColor(Color.WHITE);
						msg3.setForeColor(0x003366);
						msg3.popup();

					} else {
						validaEmpresa();
						Menu menu = new Menu();
						menu.popup();
					}

				} else if (evt.target == btnAdm) {
//					ValidaAdm validaAdm = new ValidaAdm();
//					validaAdm.popup();
					Administrador adm = new Administrador();
					adm.popup();

				} else if (evt.target == btnAtualizar) {
					buscaEmpresaCadastrada();
					
				}else if(evt.target == btnSair) {
					Home.exit(0);
				}
			}
		} catch (Exception e) {
			MessageBox msg = new MessageBox("CONTROLE", "Erro na validação" + e);
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
					MessageBox msg = new MessageBox("CONTROLE", "Sistema não possui\n empresa cadastrada");
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
			MessageBox msg = new MessageBox("CONTROLE", "Erro ao buscar empresa");
			msg.setBackColor(Color.WHITE);
			msg.setForeColor(0x003366);
			msg.popup();
			return;
		}
	}
	
	public void validaEmpresa() {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {
				lb = new LitebasePack();
				sql = "SELECT * FROM EMPRESAESCOLHIDA "
				    + " WHERE CODIGO = " + editCodigo.getText();

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					MessageBox msg = new MessageBox("CONTROLE",
							"Essa empresa não esta mais\n cadastrada no Sistema. Por favor\n clique em Atualizar para\n procurarmos uma empresa\n cadastrada.");
					msg.setBackColor(Color.WHITE);
					msg.setForeColor(0x003366);
					msg.popup();

					return;
				}
				
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

