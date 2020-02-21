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

						sql = " create table marca ( " + "codigo int," + " descricao char(40), " + "categoria char(30)" + ")";

					lb.execute(sql);
					lb.execute("create index marca01 ON marca(codigo,descricao, categoria)");
					
//------------------REFRIGERANTES---------------------------------------------------------------------------------------------------------	
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('01', 'COCA-COLA', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('02', 'FANTA', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('03', 'PEPSI', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('04', 'GUARANA KUAT', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('05', 'SUKITA', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('06', 'DOLLY', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('07', 'GUARANA ANTÁRCTICA','REFRIGERANTES')";

					lb.executeUpdate(sql);
					
//------------------SUCOS-----------------------------------------------------------------------------------------------------------					
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('08', 'SUVALAN', 'SUCOS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('09', 'MAGUARY LIFE','SUCOS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('10', 'DO BEM INTEGRAL', 'SUCOS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('11', 'DEL VALLE 100% SUCO', 'SUCOS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('12', 'SUFRESH 100% SUCO', 'SUCOS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('13', 'TIAL 100% SUCO', 'SUCOS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('14', 'NOVA ALIANÇA 100% SUCO', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('15', 'CERES 100% JUICE BLEND', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('16', 'LINHA 100% JANDAIA', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('17', 'CAMPO LARGO LARANJA INTEGRAL', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('18', 'LA FRUIT', 'SUCOS')";
					
					lb.executeUpdate(sql);
//------------------VODKA-----------------------------------------------------------------------------------------------------------					
									
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('19', 'SMIENOFF', 'VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('20', 'ABSOLUT', 'VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('21', 'GREY GOOSE', 'VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('22', 'STOLI CHNAYA', 'VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('23', 'SVEDKA','VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('24', 'SKYY', 'VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('25', 'CÎROC','VODKAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('26', 'FINLANDIA','VODKAS')";
					
					lb.executeUpdate(sql);
					
//------------------CERVEJA---------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('27', 'STELLA', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('28', 'ANTARTICA', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('29', 'KAISER', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('30', 'BAVARIA', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('31', 'SOL', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('32', 'BRAHMA','CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('33', 'COORS LIGHT', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('34', 'HEINEKEN', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('35', 'SKOL','CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('36', 'CORONA', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('37', 'BUD LIGHT', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('38', 'YANJING','CERVEJAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('39', 'BUDWEISER', 'CERVEJAS')";
					
					lb.executeUpdate(sql);
//------------------VINHO------------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('40', 'CONCHA Y TORO', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('41', 'BAREFOOT', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('42', 'E&J GALLO WINERY', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('43', 'ROBERT MONDAVI', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('44', 'CANTINA DA SERRA', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('45', 'PÉRGOLA', 'VINHOS')";
					
					lb.executeUpdate(sql);
//------------------WHISKY-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('46', 'JOHNNIE WALKER', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('47', 'JACK DANIELS', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('48', 'CHIVAS REGAL', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('49', 'BALLANTINES', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('50', 'JIM BEAM', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('51', 'JAMESON', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('52', 'SUNTORY WHISKY', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('53', 'CROWN ROYAL', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('54', 'DEWARS', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('55', 'GRANTS', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('56', 'J&B', 'WHISKYS')";
					
					lb.executeUpdate(sql);
//------------------CONHAQUES----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('57', 'HENNESSY', 'CONHAQUES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('58', 'MARTELL', 'CONHAQUES')";
					
					lb.executeUpdate(sql);
//------------------COQUITEIS-------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('59', 'OLD FASHIONED', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('60', 'NEGRONI', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('61', 'MANHATTAN', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('62', 'DAIQUIRI', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('63', 'DRY MARTINI', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('64', 'WHISKEY SOUR', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('65', 'MARGARITA', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('66', 'SAZERAC', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
//------------------CHAMPANHES-----------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('67', 'MOET & CHANDON', 'CHAMPANHES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('68', 'VEUVE CLICQUOT', 'CHAMPANHES')";
					
					lb.executeUpdate(sql);
//------------------TEQUILAS--------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('69', 'PATRÓN', 'TEQUILAS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('70', 'JOSÉ CUERVO', 'TEQUILAS')";
					
					lb.executeUpdate(sql);
//------------------GIMS------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('71', 'TANQUERAY', 'GIMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('72', 'GORDONS', 'GIMS')";
					
					lb.executeUpdate(sql);
//------------------RUM-------------------------------------------------------------------------------------------------------------------					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('73', 'BACARDI','RUMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('74', 'CAPTAIN MORGAN', 'RUMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('75', 'MALIBU', 'RUMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('76', 'HAVANA CLUB', 'RUMS')";
					
					lb.executeUpdate(sql);
//------------------LICOR------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('77', 'BAILEYS', 'LICORS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('78', 'RICARD', 'LICORS')";
					
					lb.executeUpdate(sql);
//------------------DIGESTIVO-----------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('79', 'FERNET-BRANCA', 'DIGESTIVOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('80', 'JAGERMEISTER', 'DIGESTIVOS')";
					
					lb.executeUpdate(sql);
//------------------VERMOUTH------------------------------------------------------------------------------------------------------------------
					sql = " INSERT INTO marca (codigo, descricao, categoria)" + " VALUES "
							+ " ('81', 'MARTINI', 'VERMOUTHS')";
					
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
							+ " ('12', 'RUMS')";
					
					lb.executeUpdate(sql);
										
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('13', 'LICORS' )";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('14', 'DIGESTIVOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO categoria (codigo, descricao)" + " VALUES "
							+ " ('15', 'VERMOUTHS')";
					
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

					sql = " create table produto ( " + "codigo int," + " produto char(40), " +  " categoria char(30) " + ")";

					lb.execute(sql);
					lb.execute("create index produto01 ON produto(codigo,produto,categoria)");

					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('01', 'REFRIGERANTE', 'REFRIGERANTES')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('02', 'SUCO', 'SUCOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('03', 'VODKA', 'VODKAS')";

					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('04', 'CERVEJA', 'CERVEJAS')";

					lb.executeUpdate(sql);
										
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('05', 'VINHO', 'VINHOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('06', 'WHISKY', 'WHISKYS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('07', 'CONHAQUE', 'CONHAQUES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('08', 'COQUITEI', 'COQUITEIS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('09', 'CHAMPANHE', 'CHAMPANHES')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('10', 'TEQUILA', 'TEQUILAS')";
					
					lb.executeUpdate(sql);
								
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('11', 'GIM', 'GIMS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('12', 'RUM', 'RUMS')";
					
					lb.executeUpdate(sql);
										
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('13', 'LICOR','LICORS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('14', 'DIGESTIVO', 'DIGESTIVOS')";
					
					lb.executeUpdate(sql);
					
					sql = " INSERT INTO produto (codigo, produto, categoria)" + " VALUES "
							+ " ('15', 'VERMOUTH', 'VERMOUTHS')";
					
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

					sql = " create table vendaproduto ( " + "codigo int," + " produto char(40), " + " valor char(10), "
							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
							+ "tipopagamento char(20)," + "datasaida date"
							+ ")";

					lb.execute(sql);
					lb.execute("create index vendaproduto01 ON vendaproduto(codigo,produto)");
				}
//------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("VENDAPRODUTOTEMP")) {

					sql = " create table vendaprodutoTemp ( " + "codigo int," +  "codigoProd int," + " produto char(40), " + " valor char(10), "
							+ " quantidade int, " + "categoria char(20)," + " marca char(20), " + "descricao char(40),"
							+ "tipopagamento char(20)," + "datasaida date"
							+ ")";

					lb.execute(sql);
					lb.execute("create index vendaprodutoTemp01 ON vendaprodutoTemp(codigo,produto)");
				}
//------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("EMPRESA")) {

					sql = " create table empresa ( " + "codigo int," + " nome char(40), " + " cnpj char(30), "
						+ " usuario char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index empresa01 ON empresa(codigo,nome)");
				}
//--------------------------------------------------------------------------------------------------------------------------------------------
				if (!lb.exists("TIPOPAGAMENTO")) {

					sql = " create table tipopagamento ( " + "codigo int," + " descricao char(40) " + ")";

					lb.execute(sql);
					lb.execute("create index tipopagamento01 ON tipopagamento(codigo,descricao)");

					sql = " INSERT INTO tipopagamento (codigo, descricao)" 
					    + " VALUES " + " ('01', 'DINHEIRO')";

					lb.executeUpdate(sql);

					sql = " INSERT INTO tipopagamento (codigo, descricao)" 
					    + " VALUES " + " ('02', 'CARTAO')";

					lb.executeUpdate(sql);

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

