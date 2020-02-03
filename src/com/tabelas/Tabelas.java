package com.tabelas;

import com.litebase.LitebasePack;

import litebase.ResultSet;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;

public class Tabelas {
	
	public Tabelas() {
		criaTabelas();
	}
	
	public void criaTabelas() {
		ResultSet rs = null;
		LitebasePack lb = null;
		String sql = "";
		
		try {

			try {
				lb = new LitebasePack();
//---------------------------------------------------------------------------------------------------------------------------------------					
					if (!lb.exists("MARCA")) {

						sql = " create table marca ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index marca01 ON marca(codigo,descricao)");
					
//------------------REFRIGERANTES---------------------------------------------------------------------------------------------------------	
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('01', 'COCA-COLA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('02', 'FANTA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('03', 'PEPSI')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('04', 'GUARANA KUAT')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('05', 'SUKITA')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('06', 'DOLLY ')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('07', 'GUARANA ANTÁRCTICA')";

					lb.executeUpdate(sql);
					
//------------------SUCOS-----------------------------------------------------------------------------------------------------------					
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('08', 'SUVALAN')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('09', 'MAGUARY LIFE')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('10', 'DO BEM INTEGRAL')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('11', 'DEL VALLE 100% SUCO')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('12', 'SUFRESH 100% SUCO')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('13', 'TIAL 100% SUCO')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('14', 'NOVA ALIANÇA 100% SUCO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('15', 'CERES 100% JUICE BLEND')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('16', 'LINHA 100% JANDAIA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('17', 'CAMPO LARGO LARANJA INTEGRAL')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('18', 'LA FRUIT')";
					
					lb.executeUpdate(sql);
//------------------VODKA-----------------------------------------------------------------------------------------------------------					
									
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('19', 'SMIENOFF')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('20', 'ABSOLUT')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('21', 'GREY GOOSE')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('22', 'STOLI CHNAYA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('23', 'SVEDKA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('24', 'SKYY')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('25', 'CÎROC')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('26', 'FINLANDIA')";
					
					lb.executeUpdate(sql);
					
//------------------CERVEJA---------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('27', 'STELLA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('28', 'ANTARTICA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('29', 'KAISER')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('30', 'BAVARIA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('31', 'SOL')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('32', 'BRAHMA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('33', 'COORS LIGHT')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('34', 'HEINEKEN')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('35', 'SKOL')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('36', 'CORONA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('37', 'BUD LIGHT')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('38', 'YANJING')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('39', 'BUDWEISER')";
					
					lb.executeUpdate(sql);
//------------------VINHO------------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('40', 'CONCHA Y TORO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('41', 'BAREFOOT')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('42', 'E&J GALLO WINERY')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('43', 'ROBERT MONDAVI')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('44', 'CANTINA DA SERRA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('45', 'PÉRGOLA')";
					
					lb.executeUpdate(sql);
//------------------WHISKY-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('46', 'JOHNNIE WALKER')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('47', 'JACK DANIELS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('48', 'CHIVAS REGAL')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('49', 'BALLANTINES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('50', 'JIM BEAM')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('51', 'JAMESON')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('52', 'SUNTORY WHISKY')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('53', 'CROWN ROYAL')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('54', 'DEWARS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('55', 'GRANTS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('56', 'J&B')";
					
					lb.executeUpdate(sql);
//------------------CONHAQUES----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('57', 'HENNESSY')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('58', 'MARTELL')";
					
					lb.executeUpdate(sql);
//------------------COQUITEIS-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('59', 'OLD FASHIONED')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('60', 'NEGRONI')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('61', 'MANHATTAN')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('62', 'DAIQUIRI')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('63', 'DRY MARTINI')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('64', 'WHISKEY SOUR')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('65', 'MARGARITA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('66', 'SAZERAC')";
					
					lb.executeUpdate(sql);
//------------------CHAMPANHES-----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('67', 'MOET & CHANDON')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('68', 'VEUVE CLICQUOT')";
					
					lb.executeUpdate(sql);
//------------------TEQUILAS--------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('69', 'PATRÓN')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('70', 'JOSÉ CUERVO')";
					
					lb.executeUpdate(sql);
//------------------GIMS------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('71', 'TANQUERAY')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('72', 'GORDONS')";
					
					lb.executeUpdate(sql);
//------------------RUM-------------------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('73', 'BACARDI')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('74', 'CAPTAIN MORGAN')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('75', 'MALIBU')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('76', 'HAVANA CLUB')";
					
					lb.executeUpdate(sql);
//------------------LICOR------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('77', 'BAILEYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('78', 'RICARD')";
					
					lb.executeUpdate(sql);
//------------------DIGESTIVO-----------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('79', 'FERNET-BRANCA')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('80', 'JAGERMEISTER')";
					
					lb.executeUpdate(sql);
//------------------VERMOUTH------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao)" + " VALUES "
							+ " ('81', 'MARTINI')";
					
					lb.executeUpdate(sql);
					
					}
//--------------------------------------------------------------------------------------------------------------------------------------------						
					if (!lb.exists("CATEGORIA")) {

						sql = " create table categoria ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index categoria01 ON categoria(codigo,descricao)");				
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('01', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('02', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('03', 'VODKAS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('04', 'CERVEJAS')";

					lb.executeUpdate(sql);
										
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('05', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('06', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('07', 'CONHAQUES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('08', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('09', 'CHAMPANHES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('10', 'TEQUILAS')";
					
					lb.executeUpdate(sql);
								
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('11', 'GIMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('12', 'RUM')";
					
					lb.executeUpdate(sql);
										
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('13', 'LICOR' )";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('14', 'DIGESTIVO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('15', 'VERMOUTH')";
					
					lb.executeUpdate(sql);
					
					}

//--------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("DESCRICAO")) {

					sql = " create table descricao ( " + "codigo int," + " descricao char(20) " + ")";

					lb.execute(sql);
					lb.execute("create index descricao01 ON descricao(codigo,descricao)");

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('01', '200-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('02', '300-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('03', '400-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('04', '500-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('05', '600-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('06', '700-ML')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('07', '1-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('08', '1,5-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('09', '2-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('10', '2,5-LT')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO descricao (codigo, descricao)" + " VALUES " + " ('11', '3-LT')";

					lb.executeUpdate(sql);

				}

//--------------------------------------------------------------------------------------------------------------------------------------	
				if (!lb.exists("PRODUTO")) {

					sql = " create table produto ( " + "codigo int," + " produto char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index produto01 ON produto(codigo,produto)");

					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('01', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('02', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('03', 'VODKAS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('04', 'CERVEJAS')";

					lb.executeUpdate(sql);
										
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('05', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('06', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('07', 'CONHAQUES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('08', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('09', 'CHAMPANHES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('10', 'TEQUILAS')";
					
					lb.executeUpdate(sql);
								
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('11', 'GIMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('12', 'RUM')";
					
					lb.executeUpdate(sql);
										
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('13', 'LICOR' )";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('14', 'DIGESTIVO')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto)" + " VALUES "
							+ " ('15', 'VERMOUTH')";
					
					lb.executeUpdate(sql);

				}
//----------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("ESTOQUE")) {

					sql = " create table estoque ( " + "codigo int," + " produto char(40), " + " valor char(10), "
							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
							+ "dataentrada date"
							+ ")";

					lb.execute(sql);
					lb.execute("create index estoque01 ON estoque(codigo,produto)");
				}
//-----------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("VENDAPRODUTO")) {

					sql = " create table vendaproduto ( " + "codigo int," + " produto char(40), " + " marca char(20), " 
					    + " valor char(10), "
						+ " quantidade int, " + "datavenda date" + ")";

					lb.execute(sql);
					lb.execute("create index vendaproduto01 ON vendaproduto(codigo,produto)");
				}
//------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("EMPRESA")) {

					sql = " create table empresa ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
						+ " usuario char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index empresa01 ON empresa(codigo,nome)");
				}
//--------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("EMPRESAESCOLHIDA")) {

					sql = " create table empresaescolhida ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
						+ " usuario char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index empresaescolhida01 ON empresaescolhida(codigo,nome)");
				}
				
			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
				MessageBox msg = new MessageBox("CONTROLE","Erro " + e);
				msg.setBackColor(Color.WHITE);
				msg.setForeColor(0x424242);
				msg.popup();
			}
			
		}

}

